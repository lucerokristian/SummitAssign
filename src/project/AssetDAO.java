package project;

import java.util.Date;
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
	
	//get primary key from asset table using the data from column "asset_tag";
	public int getId(String assetTag){
		Session session = factory.openSession();
		Transaction tx = null;
		int id = 0;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Asset").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Asset asset = (Asset) iterator.next();
				if(asset.getAssetTag().equals(assetTag)){
					id = asset.getId();
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
		return id;
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
	
	public int add(String branch, String assetTag, int status, String assetType, String model, String serialNumber, String purchaseOrder, String unitCost, String location, String building, String roomNumber, boolean softwareOs, String description, Date scanDate){
		Session session = factory.openSession();
		Transaction tx = null;
		int primaryKey = 0;
		try{
			tx = session.beginTransaction();
	        Asset asset = new Asset(branch, assetTag, status, assetType, model, serialNumber, purchaseOrder, unitCost, location, building, roomNumber, softwareOs, description, scanDate);
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
	
	public void delete(String assetTag){
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
	
	//return all the assets as List
	public List retrieve(){
		Session session = factory.openSession();
		Transaction tx = null;
		List assets = null;
		try {
			tx = session.beginTransaction();
			assets = session.createQuery("FROM Asset").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return assets;
	}
	
	//return all the assets as List without duplicate
		public List retrieveNoDuplicate(int status){
			Session session = factory.openSession();
			Transaction tx = null;
			List assets = null;
			try {
				tx = session.beginTransaction();
				assets = session.createQuery("FROM Asset A WHERE A.status = " + status + " GROUP BY A.assetType").list();
				tx.commit();
			} catch (HibernateException e) {
				if (tx!=null) tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return assets;
		}
	
	//return all assets with a status parameter
	public List retrieveByStatus(int status){
		Session session = factory.openSession();
		Transaction tx = null;
		List assets = null;
		try {
			tx = session.beginTransaction();
			assets = session.createQuery("FROM Asset A WHERE A.status = " + status).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return assets;
	}
	
	public int getAssetCount(String assetType){
		Session session = factory.openSession();
		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Asset").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Asset asset = (Asset) iterator.next();
				if(asset.getAssetType().equals(assetType)){
					++count;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	public int getAssetAssigned(String assetType){
		Session session = factory.openSession();
		AssetAssignedDAO aad = new AssetAssignedDAO();
		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Asset").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Asset asset = (Asset) iterator.next();
				if(asset.getAssetType().equals(assetType)){
					if(aad.isAssigned(asset.getId()))
						++count;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
}
