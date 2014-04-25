package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.ArrayList;

public class SimpleMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    AuthenticationInfo auth = null;
	    
	    if (args.length >= 3)
	        auth = new AuthenticationInfo(args[0], args[1], args[2]);
	    
		DataStore storage = DataStore.getInstance();
		
		Configuration conf = storage.loadConfig();
		ArrayList<Contact> contacts = storage.loadContacts();
		
		if (conf.getEmail() == null)
			conf.setEmail("klinge2@clemson.edu");
		if (conf.getSmtpServer() == null)
			conf.setSmtpServer("smtp.clemson.edu");
		
		if (contacts.size() == 0) {
		    contacts.add(new Contact("Jared Klingenberger", "address here",
				"555-555-5555", "klinge2@clemson.edu"));
		}
		
		EmailHandler handler = new EmailHandler(conf, auth);
		
		Email email = new Email(contacts, null, null,
				 "simplemail message", "you have received a simplemail!");
		
		handler.sendMail(email);
		
		storage.storeConfig();
		storage.storeContacts();
	}

}