package myfirst.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtil {

	public static void sendMail(String receiveMail,String subject,String content) {
		try {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost(ConstantUtil.EMAIL_FROM_HOST);
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");
			messageHelper.setFrom(ConstantUtil.EMAIL_FROM_USERNAME);
			messageHelper.setTo(receiveMail);
			messageHelper.setSubject(subject);
			messageHelper.setText(content,true);
			Properties prop = new Properties();  
	        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
	        prop.put("mail.smtp.timeout", "25000");  
	        Authenticator authenticator = new Authenticator() {
	        	@Override
	        	protected PasswordAuthentication getPasswordAuthentication() {
	        		return new PasswordAuthentication(ConstantUtil.EMAIL_FROM_USERNAME, ConstantUtil.EMAIL_FROM_PASSWORD);
	        	}
			};
			Session session = Session.getDefaultInstance(prop,authenticator);
			mailSender.setSession(session);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
