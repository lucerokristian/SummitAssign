package project;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AccountDAO {
	private static SessionFactory factory;
	static{
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	//validate if username and password match : pass Strings username and password
	public boolean validate(String username, String password){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Account").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Account account = (Account) iterator.next();
				if(account.getUsername().equals(username) && account.getPassword().equals(password)){
					flag = true;
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

	//check if username is taken. Returns FALSE if it's TAKEN : pass String username
	public boolean checkUsername(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean flag = true;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Account").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Account account = (Account) iterator.next();
				if(account.getUsername().equals(username)){
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
	
	//check if the user is admin or not : pass String username
	public boolean isAdmin(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try{
			tx = session.beginTransaction();
			Account account = (Account) session.get(Account.class, username);
			if(account.getIsAdmin())
				flag = true;
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally{
			session.close();
		}
		return flag;
	}
	
	public List getAllUsers(){
		Session session = factory.openSession();
		Transaction tx = null;
		List users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM Account").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}
	
	//get email : pass String username
	public String getEmail(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		String email = null;
		try{
			tx = session.beginTransaction();
			Account account = (Account) session.get(Account.class, username);
			if(account != null)
				email = account.getEmail();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();  
		}finally{
			session.close();
		}
		return email;
	}
	
	public String getPassword(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		String password = null;
		try{
			tx = session.beginTransaction();
			Account account = (Account) session.get(Account.class, username);
			if(account != null)
				password = account.getPassword();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();  
		}finally{
			session.close();
		}
		return password;
	}
	
	public String getFname(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		String fname = null;
		try{
			tx = session.beginTransaction();
	        Account account = (Account) session.get(Account.class, username);
	        fname = account.getFirstName();
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return fname;
	}
	
	public String getLname(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		String fname = null;
		try{
			tx = session.beginTransaction();
	        Account account = (Account) session.get(Account.class, username);
	        fname = account.getLastName();
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return fname;
	}
	
	//update email AND/OR password of account by username
//	public void updatet(String username, String password, String email){
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//	        Account account = (Account) session.get(Account.class, username);
//	        if(password != null)
//	        	account.setPassword(password);
//	        if(email != null)
//	        	account.setEmail(email);
//	        session.update(account);
//	        tx.commit();
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
//	}
//	
	public void delete(String username){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	        Account account = (Account) session.get(Account.class, username);
	        session.delete(account); 
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	//add a new account with required fields and return the primary key;
	public int add(String username, String password, boolean isAdmin, String fname, String lname, String email){
		Session session = factory.openSession();
		Transaction tx = null;
		int primaryKey = 0;
		try{
			tx = session.beginTransaction();
	        Account account = new Account(username, password, isAdmin, fname, lname, email);
	        primaryKey = (int) session.save(account); //save() returns primary key of the inserted record
	        tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return primaryKey;
	}
	
	//retrieve all the users as List
	public List retrieve(){
		Session session = factory.openSession();
		Transaction tx = null;
		List users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM Account").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}
}
