package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

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
	
	private void writeObjectToFile(String file, Object o) throws Exception {
		File f = new File(file);
		if (!f.exists() && !f.createNewFile() || !f.isFile()) {
			System.out.println("Could not access file " + file);
		} else {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(f));
			out.writeObject(o);
			out.close();
		}
	}
	
	private Object readObjectFromFile(String file) throws Exception {
		Object o = null;
		File f = new File(file);
		if (f.exists()) {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(f));
			o = in.readObject();
			in.close();
		}
		return o;
	}
	
	private SealedObject getSealedObject(Serializable obj) throws Exception {
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();

		writeObjectToFile("data/privatekey.dat", key);

		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		return new SealedObject(obj, cipher);
	}
	
	// decrypt using a private key
	public Configuration loadConfig() {
		Object okey = null, obj = null;
		try {
			okey = readObjectFromFile("data/privatekey.dat");
			obj = readObjectFromFile("data/systemcfg.dat");
		} catch (Exception e) {
			System.out.println("Error while reading encrypted files.");
		}
		
		if (okey != null && obj != null &&
				okey instanceof SecretKey && obj instanceof SealedObject) {
			SecretKey key = (SecretKey) okey;
			SealedObject sealedObject = (SealedObject) obj;
			
			try {
				Cipher cipher = Cipher.getInstance(key.getAlgorithm());
				cipher.init(Cipher.DECRYPT_MODE, key);
				
				Object decryptedObject = sealedObject.getObject(cipher);
				if (decryptedObject instanceof Configuration) {
					conf = (Configuration) decryptedObject;
					System.out.println("Restored configuration: " + conf);
				}
			} catch (Exception e) {
				System.out.println("Error while decrypting config file.");
			}
		}
		
		return conf;
	}
	
	public ArrayList<Contact> loadContacts() {
		File[] fileList = new File("data/contacts/").listFiles();
		
		if (fileList != null) {
			for (File f : fileList) {
				try {
					Object o = readObjectFromFile(f.getPath());
					if (o instanceof Contact) {
						Contact c = (Contact) o;
						contacts.add(c);
						System.out.println("Restored contact: " + c.getName());
					}
				} catch (Exception e) {
					System.out.println("Error reading contact from disk.");
				}
			}
		}
		
		return contacts;
	}
	
	// encrypted because config contains sensitive data (passwords)
	public void storeConfig() {
		try {
			SealedObject sealedObject = getSealedObject(conf);
			writeObjectToFile("data/systemcfg.dat", sealedObject);
		} catch (Exception e) {
			System.out.println("Could not write new config file.");
			e.printStackTrace();
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