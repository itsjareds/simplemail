package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.search.FlagTerm;

/**
 * Class which handles the details in regards to sending and receiving mail.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class EmailHandler {
	/**
	 * sendMail(Email email) handles the nuts and bolts of sending an email
	 * using a configuration.
	 * 
	 * @param email Prepared email object which contains message information.
	 * @return Boolean value which indicates success or failure.
	 */
	public boolean sendMail(Email email) {
		boolean success = false;
		
		Configuration conf = DataStore.getInstance().getConf();
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
		
		if (conf.getSmtpServer() != null) {
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.sendpartial", true);
			props.put("mail.smtp.host", conf.getSmtpServer().getHostAddress());
			props.put("mail.smtp.port", conf.getSmtpPort());
			
			if (conf.getEmail() != null)
				props.put("mail.from", conf.getEmail());

			final AuthenticationInfo auth = conf.getAuthSmtp();
			if (conf.isSslUsedSmtp() && auth != null) {
				props.put("mail.smtp.socketFactory.port", conf.getSmtpPort());
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
				msg.setFrom(conf.getEmail());
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
			} catch (SendFailedException e) {
				for (Address address : e.getInvalidAddresses())
					System.out.println("Send failed to " + address);
				System.out.println("Failure message: " + e.getMessage());
			} catch (MessagingException e) {
				System.out.println("Caught exception:");
				e.printStackTrace();
			}
		} else
			System.out.println("No SMTP server configured.");
		
		return success;
	}
	
	/**
	 * Basic proof-of-concept POP mail reading function.
	 */
	public void readMail() {
		Configuration conf = DataStore.getInstance().getConf();
		final AuthenticationInfo auth = conf.getAuthPop3();
		if (auth == null) {
			System.out.println("Error: no authentication provided for POP3.");
		} else if (conf.getPopServer() == null) {
			System.out.println("Error: no POP host provided.");
		} else {
		    Folder inbox = null;
		    Message[] messages = {};
		    Store store = null;
		    
		    Properties props = new Properties();
		    
		    props.put("mail.pop3.socketFactory.class",
		            "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.pop3.socketFactory.fallback", "false");
		    props.put("mail.pop3.socketFactory.port",
		            conf.getPopPort());
		    props.put("mail.store.protocol", "pop3");
		    props.put("mail.pop3.host", conf.getPopServer().getHostName());
		    props.put("mail.pop3.auth", "true");
		    props.put("mail.pop3.port", conf.getPopPort());
		    
		    Session session = Session.getDefaultInstance(props, null);
		    try {
	            store = session.getStore();
	            System.out.println("Connecting...");
	            store.connect(auth.getUsername(), auth.getPassword());
	            System.out.println("Connected.");
	            inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_ONLY);
	            
	            messages = inbox.search(new FlagTerm(
	            		new Flags(Flags.Flag.SEEN), false));
	            
	            FetchProfile fp = new FetchProfile();
	            fp.add(FetchProfile.Item.ENVELOPE);
	            fp.add(FetchProfile.Item.CONTENT_INFO);
	            
	            System.out.println("Fetching messages...");
	            inbox.fetch(messages, fp);
	            System.out.println("Messages fetched.");
	            
	            for (int i = 0; i < messages.length; i++) {
	                System.out.println("=== Message " + i + " ===");
	                Address[] addresses;
	                
	                try {
	                    addresses = messages[i].getFrom();
	                    if (addresses != null) {
	                        System.out.println("FROM: ");
	                        for (Address address : addresses) {
	                            System.out.println(address);
	                        }
	                    }
	                    
	                    addresses = messages[i].getRecipients(
	                            Message.RecipientType.TO);
	                    if (addresses != null) {
	                        System.out.println("TO:   ");
	                        for (Address address : addresses) {
	                            System.out.println(address);
	                        }
	                    }
	                    
	                    String subject = messages[i].getSubject();
	                    String content = messages[i].getContent().toString();
	                    
	                    System.out.println("Subject: " + subject);
	                    System.out.println("Body: " + content);
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                } catch (MessagingException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                
	            }            
	            
	            System.out.println("Closing connections...");
	            inbox.close(true);
	            store.close();
	            System.out.println("Done.");
	        } catch (NoSuchProviderException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (MessagingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}
	}
}