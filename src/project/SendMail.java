package project;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	 public boolean send(String username){
		 boolean flag = false;
    	 AccountDAO accountDAO = new AccountDAO();
		 int id = accountDAO.getId(username);
		 String to = AccountDAO.getEmail(id); //change accordingly  
		 if(to != null){
		     String from = "krblucero@gmail.com"; //change accordingly
			 Properties props = new Properties();
			 props.put("mail.smtp.host", "smtp.gmail.com");
			 props.put("mail.smtp.socketFactory.port", "465");
			 props.put("mail.smtp.socketFactory.class",
						"javax.net.ssl.SSLSocketFactory");
			 props.put("mail.smtp.auth", "true");
			 props.put("mail.smtp.port", "465");
	
			 Session session = Session.getDefaultInstance(props,
			 new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("krblucero@gmail.com","Star&Summer1510");
				}
			});
			try {
	
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				message.setSubject("Forgot Password Request");
				message.setText("Hi " + accountDAO.getFname(id) + ",\n\nThis is an automated message. Do not reply!\n\nHere is the password for " + username + ": " + accountDAO.getPassword(id));
	
				Transport.send(message);
	
				System.out.println("Done");
				flag = true;
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		 }
		return flag;
		} 
}
