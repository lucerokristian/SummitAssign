package project;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AssetAssignedDAO {
	private static SessionFactory factory;
	static{
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	//get primary key from asset_status table using the foreign key "asset_id";
	public int getId(int assetId){
		Session session = factory.openSession();
		Transaction tx = null;
		int id = 0;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM AssetAssigned").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				AssetAssigned assetAssigned = (AssetAssigned) iterator.next();
				if(assetAssigned.getAssetId() == assetId){
					id = assetAssigned.getId();
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
	
	public boolean update(int id, int userId){
		  Session session = factory.openSession();
		  boolean flag = true;
		  Transaction tx = null;
		  try{
		     tx = session.beginTransaction();
		     AssetAssigned assetAssigned = (AssetAssigned) session.get(AssetAssigned.class, id); 
		     assetAssigned.setUserId(1);
			 session.update(assetAssigned); 
		     tx.commit();
		  }catch (HibernateException e) {
			 flag = false;
		     if (tx!=null) tx.rollback();
		     e.printStackTrace(); 
		  }finally {
		     session.close(); 
		  }	
		  return flag;
	}
	
	//add status information for an asset
	public int add(int userId, int assetId){
		Session session = factory.openSession();
		Transaction tx = null;
		int primaryKey = 0;
		try{
			tx = session.beginTransaction();
	        AssetAssigned AssetAssigned = new AssetAssigned(userId, assetId);
	        primaryKey = (int) session.save(AssetAssigned); //save() returns primary key of the inserted record
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return primaryKey;
	}
	
	//delete by asset id
	public void delete(int assetId){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	        AssetAssigned AssetAssigned = (AssetAssigned) session.get(AssetAssigned.class, assetId);
	        session.delete(AssetAssigned); 
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	//retrieve and return all the asset status as List
	public List retrieve(int assetId){
		Session session = factory.openSession();
		Transaction tx = null;
		List allStatus = null;
		try {
			tx = session.beginTransaction();
			allStatus = session.createQuery("FROM AssetAssigned").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return allStatus;
	}
	
	public boolean isAssigned(int assetId){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM AssetAssigned").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				AssetAssigned assetAssigned = (AssetAssigned) iterator.next();
				if(assetAssigned.getAssetId() == assetId){
					if(assetAssigned.getUserId() > 0)
						flag = true; //meaning asset is assigned
					break;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			flag = false;
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
	}
}
