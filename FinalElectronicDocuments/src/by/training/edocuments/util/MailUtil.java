package by.training.edocuments.util;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import by.training.edocuments.connection.ConnectionPool;

public class MailUtil {
	private static Properties properties;
	
	
	
	static {
		properties = new Properties();
		try {
			properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("app.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
   public static void sendEmailWithAttachment(String userName1, String password1, String toAddress,
           String subject, String message, List<File> attachedFiles)
                   throws AddressException, MessagingException {
	   String userName = properties.getProperty("mailUser");
	   String password = properties.getProperty("mailPass");
       // creates a new session with an authenticator
       Authenticator auth = new Authenticator() {
           public PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(userName, password);
           }
       };
       Properties properties = new Properties();
	    try {
	    	properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("app.properties"));	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
       Session session = Session.getInstance(properties, auth);
       // creates a new e-mail message
       Message msg = new MimeMessage(session);
       msg.setFrom(new InternetAddress(userName));
       InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
       msg.setRecipients(Message.RecipientType.TO, toAddresses);
       msg.setSubject(subject);
       msg.setSentDate(new Date());
       // creates message part
       MimeBodyPart messageBodyPart = new MimeBodyPart();
       messageBodyPart.setContent(message, "text/html");
       // creates multi-part
       Multipart multipart = new MimeMultipart();
       multipart.addBodyPart(messageBodyPart);
       // adds attachments
       if (attachedFiles != null && attachedFiles.size() > 0) {
           for (File aFile : attachedFiles) {
               MimeBodyPart attachPart = new MimeBodyPart();
               try {
                   attachPart.attachFile(aFile);
               } catch (IOException ex) {
                   ex.printStackTrace();
               }

               multipart.addBodyPart(attachPart);
           }
       }
       msg.setContent(multipart);
       Transport.send(msg);
   }

	
	public static void send(final String fromEmail, final String pass, String toEmail, String subject, String msg) {
		  Session session = Session.getInstance(properties,
		          new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(fromEmail, pass);
		            }
		          });
		    try {
	        	 Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(fromEmail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
				message.setSubject(subject);
				message.setContent(msg, "text/html");
		//		message.setText(msg);
				Transport.send(message);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	        
		
	}

	public static void main(String[] args) {
		String fromEmail = properties.getProperty("mailUser");
		String pass = properties.getProperty("mailPass");
       System.out.println(fromEmail + "   " + pass);  
        String msg = "Hello from Java";
        String toEmail = "vatsa@tut.by";
        String subject = "This is not SPAM";
        
        
 //       send(fromEmail, pass, toEmail, subject, msg);
        
       try {
        sendEmailWithAttachment(fromEmail, pass, toEmail, "������ �� ����", "Hello from <h1>JAVA</h1>", null);
    } catch (AddressException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (MessagingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      

	}

}
