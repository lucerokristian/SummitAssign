package project;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AccountDAO {
	private static SessionFactory factory;
	
	//validate if username and password match : pass Strings username and password
	public boolean validate(String username, String password){
		configureFactory();
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
	public boolean isAdmin(int id){
		configureFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try{
			tx = session.beginTransaction();
			Account account = (Account) session.get(Account.class, id);
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
	
	public int getId(String username){
		configureFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		int id = 0;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Account").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Account account = (Account) iterator.next();
				if(account.getUsername().equals(username)){
					id = account.getId();
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
	//get email : pass String username
	public static String getEmail(int id){
		Session session = factory.openSession();
		Transaction tx = null;
		String email = null;
		try{
			tx = session.beginTransaction();
			Account account = (Account) session.get(Account.class, id);
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
	
	public static String getPassword(int id){
		Session session = factory.openSession();
		Transaction tx = null;
		String password = null;
		try{
			tx = session.beginTransaction();
			Account account = (Account) session.get(Account.class, id);
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
	
	public String getFname(int id){
		configureFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		String fname = null;
		try{
			tx = session.beginTransaction();
	        Account account = (Account) session.get(Account.class, id);
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
	
	public String getLname(int id){
		configureFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		String fname = null;
		try{
			tx = session.beginTransaction();
	        Account account = (Account) session.get(Account.class, id);
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
	
	public void delete(int id){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	        Account account = (Account) session.get(Account.class, id);
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
	
//	public boolean sendMail(String username){
//		int id = AccountDAO.getId(username);
//		String to = AccountDAO.getEmail(id);
//	    String from = "klucero.sd@gmail.com";
//	    String host = "192.168.1.241"; //or IP address
//	    boolean result = false;
//	      // Get system properties
//	      Properties properties = System.getProperties();
//
//	      // Setup mail server
//	      properties.setProperty("mail.smtp.host", host);
//
//	      // Get the default Session object.
//	      javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties);
//
//	      try {
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//	         // Set Subject: header field
//	         message.setSubject("Forgot Password");
//
//	         // Now set the actual message
//	         message.setText("This is your password: '" + AccountDAO.getPassword(id) + "'\n\nDo not reply to this email.");
//
//	         // Send message
//	         Transport.send(message);
//	         result = true;
//	      }catch (MessagingException mex) {
//	    	  result = false;
//	         mex.printStackTrace();
//	      }
//	      return result;
//	 }  
	
	public void configureFactory(){
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
}
