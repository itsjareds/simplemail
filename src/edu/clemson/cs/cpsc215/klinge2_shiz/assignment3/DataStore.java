package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
	private HashMap<String, SecretKey> keyring = 
			new HashMap<String, SecretKey>();
	
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
	
	private SecretKey getKey(String keyName) throws Exception {
		SecretKey key = keyring.get(keyName);
		Object okey = null;
		
		if (key == null) {
			try {
				okey = readObjectFromFile("data/keyring/" + keyName + ".dat");
				
				if (okey != null && okey instanceof SecretKey) {
					key = (SecretKey) okey;
					keyring.put(keyName, key);
				}
			} catch (Exception e) {
				System.out.println("Error while trying to obtain key.");
			}
		}
		
		return key;
	}
	
	private Object decryptObject(String keyName, String fileName)
			throws Exception {
		Object obj = null, decryptedObject = null;
		SecretKey key = getKey(keyName);
		try {
			obj = readObjectFromFile(fileName);
		} catch (Exception e) {
			System.out.println("Error reading encrypted file " + fileName);
		}
		
		if (obj != null && key != null && obj instanceof SealedObject) {
			SealedObject sealedObject = (SealedObject) obj;
			
			try {
				Cipher cipher = Cipher.getInstance(key.getAlgorithm());
				cipher.init(Cipher.DECRYPT_MODE, key);
				
				decryptedObject = sealedObject.getObject(cipher);
			} catch (Exception e) {
				System.out.println("Error while decrypting file " + fileName);
			}
		}
		return decryptedObject;
	}
	
	private SealedObject encryptObject(Serializable obj) throws Exception {
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		writeObjectToFile("data/keyring/privatekey.dat", key);
	
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		return new SealedObject(obj, cipher);
	}
	
	// decrypt using a private key
	public Configuration loadConfig() {
		try {
			Object obj = decryptObject("data/privatekey.dat",
					"data/systemcfg.dat");
			if (obj instanceof Configuration) {
				conf = (Configuration) obj;
				System.out.println("Restored configuration: " + conf);
			}
		} catch (Exception e) {
			System.out.println("Error decrypting config file.");
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
			SealedObject sealedObject = encryptObject(conf);
			writeObjectToFile("data/systemcfg.dat", sealedObject);
		} catch (Exception e) {
			System.out.println("Could not write new config file.");
		}
	}
	
	public void storeContacts() {
		for (Contact c : contacts) {
			try {
				writeObjectToFile("data/contacts/" + c.getEmail() + ".ser", c);
			} catch (Exception e) {
				System.out.println("Could not serialize contact.");
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
