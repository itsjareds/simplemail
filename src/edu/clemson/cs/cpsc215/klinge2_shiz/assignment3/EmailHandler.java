package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * Class which handles the details in regards to sending and receiving mail.
 * 
 * @author Jared Klingenberger
 * @since 04-24-2014
 */
public class EmailHandler {
	private Configuration conf;
	private final AuthenticationInfo auth;
	
	public EmailHandler(Configuration conf, AuthenticationInfo auth) {
		this.conf = conf;
		this.auth = auth;
	}
	
	/**
	 * sendMail(Email email) handles the nuts and bolts of sending an email
	 * using a configuration.
	 * 
	 * @param email Prepared email object which contains message information.
	 * @return Boolean value which indicates success or failure.
	 */
	public boolean sendMail(Email email) {
		boolean success = false;
		
		Authenticator authenticator = null;
		
		System.out.println("Attempting to send email:");
		
		System.out.print("to: ");
		for (int i = 0; i < email.getToField().length; i++)
			System.out.print(email.getToField()[i] + ", ");
		
		System.out.print("\ncc: ");
		for (int i = 0; i < email.getCcField().length; i++)
			System.out.print(email.getCcField()[i] + ", ");
		
		System.out.print("\nbcc: ");
		for (int i = 0; i < email.getBccField().length; i++)
			System.out.print(email.getBccField()[i] + ", ");
		System.out.print("\n");
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", conf.getSmtpServer().getHostAddress());
		
		if (auth != null) {
		    props.put("mail.smtp.socketFactory.port", auth.getAuthport());
    		props.put("mail.smtp.socketFactory.class",
    		        "javax.net.ssl.SSLSocketFactory");
    		props.put("mail.smtp.auth", "true");
    	
    		authenticator = new Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(auth.getUsername(),
                              auth.getPassword());
                  }
            };
		}
		
		Session session = Session.getDefaultInstance(props, authenticator);
		
		Message msg = new MimeMessage(session);
		try {
			msg.setRecipients(RecipientType.TO, email.getToField());
			msg.setRecipients(RecipientType.CC, email.getCcField());
			msg.setRecipients(RecipientType.BCC, email.getBccField());
			msg.setSubject(email.getSubject());
			msg.setFrom(conf.getEmail());
			msg.setText(email.getMessage());
			
			if (msg.getAllRecipients() == null || 
			        msg.getAllRecipients().length > 0) {
				Transport.send(msg);
				System.out.println("Message sent.");
				success = true;
			} else {
				System.out.println("Error: zero recipients.");
			}
		} catch (MessagingException e) {
			System.out.println("Caught exception:");
			e.printStackTrace();
		}
		
		return success;
	}
}