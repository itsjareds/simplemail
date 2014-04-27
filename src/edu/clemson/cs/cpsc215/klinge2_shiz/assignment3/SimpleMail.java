package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.ArrayList;

public class SimpleMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataStore storage = DataStore.getInstance();
		
		Configuration conf = storage.getConf();
		ArrayList<Contact> contacts = storage.getContacts();
		
		if (conf.getEmail() == null)
			conf.setEmail("klinge2@clemson.edu");
		if (conf.getSmtpServer() == null)
			conf.setSmtpServer("smtp.clemson.edu");
		
		contacts.clear();
		
		if (contacts.size() == 0) {
		    contacts.add(new Contact("Jared K.", "White House",
				"123-456-7890", "jared.klingenberger@gmail.com"));
		}
		
		EmailHandler handler = new EmailHandler();
		
		Email email = new Email(null, null, contacts,
				 "simplemail message", "you have received a simplemail!");
		
		handler.sendMail(email);
		
		try {
    		storage.storeConf();
		} catch (Exception e) {
		    System.out.println("Error while saving config file.");
		    e.printStackTrace();
		}
		try {
    		storage.storeContacts();
		} catch (Exception e) {
		    System.out.println("Error while saving contacts.");
		    e.printStackTrace();
		}
	}

}
