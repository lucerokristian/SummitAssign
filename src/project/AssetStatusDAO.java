package project;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AssetStatusDAO {
	private static SessionFactory factory;
	static{
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	//add status information for an asset
	public int add(int status, int userId, int assetId){
		Session session = factory.openSession();
		Transaction tx = null;
		int primaryKey = 0;
		try{
			tx = session.beginTransaction();
	        AssetStatus assetStatus = new AssetStatus(status, userId, assetId);
	        primaryKey = (int) session.save(assetStatus); //save() returns primary key of the inserted record
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
	        AssetStatus assetStatus = (AssetStatus) session.get(AssetStatus.class, assetId);
	        session.delete(assetStatus); 
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
			allStatus = session.createQuery("FROM AssetStatus").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return allStatus;
	}
}
