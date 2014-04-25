package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.ArrayList;

public class Pop3Driver {

    /**
     * @param args Optional args for auth are [username] [password] [authport]
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
            contacts.add(new Contact("Jared K.", "White House",
                "123-456-7890", "jared.klingenberger@gmail.com"));
        }
        
        EmailHandler handler = new EmailHandler(conf, auth);
        
        handler.readMail();
        
        storage.storeConfig();
        storage.storeContacts();
    }

}