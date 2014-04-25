package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Data storage class which provides functionality to store and load
 * runtime configuration to and from the hard disk.
 * 
 * @author Jared Klingenberger
 * @since 04-24-2014
 */
public class DataStore {
	private static DataStore instance = new DataStore();
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration conf = new Configuration();
	
	private DataStore() {
		// disable the default public constructor
	}
	
	public static DataStore getInstance() {
		return instance;
	}
	
	public Configuration loadConfig() {
		ObjectInputStream in = null;
		File f = new File("data/systemcfg.ser");
		
		if (f.exists()) {
			try {
				in = new ObjectInputStream(new FileInputStream(f));
				
				Object o = in.readObject();
				if (o instanceof Configuration)
					conf = (Configuration) o;
				
				System.out.println("Restored configuration: " + conf);
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return conf;
	}
	
	public ArrayList<Contact> loadContacts() {
		ObjectInputStream in = null;
		File[] fileList = new File("data/contacts/").listFiles();
		
		if (fileList != null) {
			for (File f : fileList) {
				try {
					in = new ObjectInputStream(new FileInputStream(f));
					
					Object o = in.readObject();
					if (o instanceof Contact)
						contacts.add((Contact) o);
					
					System.out.println("Restored contact: " + ((Contact)o).getName());
					in.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		return contacts;
	}
	
	public void storeConfig() {
	    File workingDir = new File("data/");
	    if (!workingDir.exists() && !workingDir.mkdirs()) {
	        System.out.println("Could not create serialization directory.");
	    } else {
    		ObjectOutputStream out = null;
    		try {
    				out = new ObjectOutputStream(new FileOutputStream(new File(
    						workingDir, "systemcfg.ser")));
    				out.writeObject(conf);
    				out.close();
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    }
	}
	
	public void storeContacts() {
	    File workingDir = new File("data/contacts/");
	    if (!workingDir.exists() && !workingDir.mkdirs()) {
	        System.out.println("Could not create serialization directory.");
	    } else {
    		ObjectOutputStream out = null;
    		try {
    			for (Contact c : contacts) {
    				out = new ObjectOutputStream(new FileOutputStream(new File(
    						workingDir, c.getEmail() + ".ser")));
    				out.writeObject(c);
    				out.close();
    			}
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    }
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public Configuration getConf() {
		return conf;
	}
}
