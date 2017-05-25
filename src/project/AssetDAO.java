package project;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AssetDAO {
	private static SessionFactory factory;
	static{
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	//check if assetTag already exists, return FALSE if it already EXISTS.
	public boolean checkAssetTag(String assetTag){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean flag = true;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Asset").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Asset asset = (Asset) iterator.next();
				if(asset.getAssetTag().equals(assetTag)){
					flag = false;
					break;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
	}
	
	public int addAsset(String branch, String assetTag, int currentStatus, String assetType){
		Session session = factory.openSession();
		Transaction tx = null;
		int primaryKey = 0;
		try{
			tx = session.beginTransaction();
	        Asset asset = new Asset(branch, assetTag, currentStatus, assetType);
	        primaryKey = (int) session.save(asset); //save() returns primary key of the inserted record
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return primaryKey;
	}
	
	//assign asset by setting the foreign key of Asset Table to the primary key of Account table
	public void updateAssetAssignment(String assetTag, int account_id){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	        Asset asset = (Asset) session.get(Asset.class, assetTag);
	        asset.setAccount_id(account_id);
	        session.update(asset);
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	public void deleteAsset(String assetTag){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	        Asset asset = (Asset) session.get(Asset.class, assetTag);
	        session.delete(asset); 
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
}
