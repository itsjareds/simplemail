package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.ArrayList;

public class SimpleMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataStore storage = DataStore.getInstance();
		
		Configuration conf = storage.loadConfig();
		ArrayList<Contact> contacts = storage.loadContacts();
		
		if (conf.getEmail() == null)
			conf.setEmail("klinge2@clemson.edu");
		if (conf.getSmtpServer() == null)
			conf.setSmtpServer("smtp.clemson.edu");
		
		contacts.add(new Contact("Jared Klingenberger", "address here",
				"555-555-5555", "klinge2@clemson.edu"));
		
		EmailHandler handler = new EmailHandler(conf);
		
		Email email = new Email(null, contacts, null,
				 "cc'd", "Tried making a mailing list");
		
		handler.sendMail(email);
		
		storage.storeConfig();
		storage.storeContacts();
	}

}