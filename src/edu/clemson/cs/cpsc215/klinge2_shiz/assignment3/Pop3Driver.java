package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.List;

public class Pop3Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DataStore storage = DataStore.getInstance();
        
        Configuration conf = storage.getConf();
        List<Contact> contacts = storage.getContacts();
        
        if (conf.getEmail() == null)
            conf.setEmail("klinge2@clemson.edu");
        if (conf.getSmtpServer() == null)
            conf.setSmtpServer("smtp.clemson.edu");
        
        if (contacts.size() == 0) {
            contacts.add(new Contact("Jared K.", "White House",
                "123-456-7890", "jared.klingenberger@gmail.com"));
        }
        
        EmailHandler handler = new EmailHandler();
        
        handler.readMail();
        
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
