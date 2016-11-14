package ua.com.hihelper.serviceimpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ua.com.hihelper.service.MailService;

@Service
public class MailServiceImpl implements MailService{

	
	
	private static final String ADMINMAIL="maryana.tsapiv@gmail.com";
	private static final String PASSWORD="maryana1995";
	
	
	
	
	@Async
	 public void sendMessage(String content, String email, String mailBody) {
		        Properties properties = System.getProperties();
		        properties.setProperty("mail.smtp.starttls.enable", "true");
		        properties.setProperty("mail.smtp.auth", "true");
		        properties.setProperty("mail.smtp.port", "465");
		        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		        properties.setProperty("mail.smtp.socketFactory.port", "465");
		        properties.setProperty("mail.smtp.socketFactory.class",
		                "javax.net.ssl.SSLSocketFactory");
		        Session session = Session.getDefaultInstance(properties,
		                new Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(ADMINMAIL, PASSWORD);
		                    }
		                });
try{
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(ADMINMAIL));
		 message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                 email));
         message.setSubject(content, "UTF-8");
         message.setText(mailBody);
         synchronized (this) {
             Transport.send(message);
} 
	
	}

		catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("You have some problems with connection!");}

		  }
	}	

