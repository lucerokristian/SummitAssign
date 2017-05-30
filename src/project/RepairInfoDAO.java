package project;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RepairInfoDAO {
	private static SessionFactory factory;
	static{
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	//get primary key from repair_info table using the data from column "asset_status_id";
	public int getId(int assetStatusId){
		Session session = factory.openSession();
		Transaction tx = null;
		int id = 0;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM RepairInfo").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				RepairInfo repairInfo = (RepairInfo) iterator.next();
				if(repairInfo.getAssetStatusId() == assetStatusId){
					id = repairInfo.getId();
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
	
	
	//add repair info for asset
	public int add(String repairCompany, int type, String ticketNumber, Date ticketDate, String comments, int assetStatusId){
		Session session = factory.openSession();
		Transaction tx = null;
		int primaryKey = 0;
		try{
			tx = session.beginTransaction();
	        RepairInfo repairInfo = new RepairInfo(repairCompany, type, ticketNumber, ticketDate, comments, assetStatusId);
	        primaryKey = (int) session.save(repairInfo); //save() returns primary key of the inserted record
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return primaryKey;
	}
	
	//delete by assetStatusId
	public void delete(int assetStatusId){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	        RepairInfo repairInfo = (RepairInfo) session.get(RepairInfo.class, assetStatusId);
	        session.delete(repairInfo); 
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	//retrieve and return all the repair information as list
	public List retrieve(int assetStatusId){
		Session session = factory.openSession();
		Transaction tx = null;
		List repairInfo = null;
		try {
			tx = session.beginTransaction();
			repairInfo = session.createQuery("FROM RepairInfo").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return repairInfo;
	}
}
