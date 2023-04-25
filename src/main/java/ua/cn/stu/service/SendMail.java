package ua.cn.stu.service;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void sendEmail(String userEmail){
	    String to = userEmail;
	    String from = "bengemingg@gmail.com";
	    final String username = "bengemingg@gmail.com";
	    final String password = "pkvuytsuagyyhise";
	    String host = "smtp.gmail.com";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(to));
	        message.setSubject("Authorization Information");
	        message.setText("Administrator account has been logged in!");
	        Transport.send(message);

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}

	
	
}
