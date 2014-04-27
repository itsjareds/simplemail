package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class DataStore implements DataStoreInterface {
	private static DataStore instance;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration conf = new Configuration();
	private HashMap<String, SecretKey> keyring =
			new HashMap<String, SecretKey>();
	
	static {
	    instance = new DataStore();
	    instance.loadConf();
	    instance.loadContacts();
	}
	
	private DataStore() {
		// disable the default public constructor
	}
	
	public static DataStore getInstance() {
		return instance;
	}
	
	private void writeObjectToFile(String file, Object o) {
		File f = new File(file);
		try {
		    f.getParentFile().mkdirs();
		    f.createNewFile();
			if (!f.exists()) {
				System.out.println("Could not create file " + file);
			} else {
				ObjectOutputStream out;
				out = new ObjectOutputStream(
						new FileOutputStream(f));
				out.writeObject(o);
				out.close();
			}
		} catch (SecurityException e) {
			System.out.println("Permission denied.");
		} catch (IOException e) {
			System.out.println("Could not write object file " + file);
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
	
	private SecretKey getKey(String keyName) {
		SecretKey key = null;
		Object okey = null;
		try {
			okey = readObjectFromFile("data/keyring/" + keyName + ".dat");

			if (okey != null && okey instanceof SecretKey) {
				key = (SecretKey) okey;
				keyring.put(keyName, key);
			}
		} catch (Exception e) {
			System.out.println("Error obtaining key.");
		}
		return key;
	}
	
	private Object decryptObject(String keyName, String fileName) {
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
	
	private SealedObject encryptObject(Serializable obj, String keyName)
			throws Exception {
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		SealedObject sealedObject = null;
		
		try {
			writeObjectToFile("data/keyring/" + keyName + ".dat", key);
			
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			sealedObject = new SealedObject(obj, cipher);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return sealedObject;
	}
	
	// decrypt using a private key
	@Override
    public void loadConf() {
		try {
			Object obj = decryptObject("confkey", "data/systemcfg.dat");
			if (obj instanceof Configuration) {
				conf = (Configuration) obj;
				System.out.println("Restored configuration: " + conf);
			}
		} catch (Exception e) {
			System.out.println("Error decrypting config file.");
		}
	}
	
	@Override
    public void loadContacts() {
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
	}
	
	// encrypted because config contains sensitive data (passwords)
	@Override
    public void storeConf() {
		try {
			SealedObject sealedObject = encryptObject(conf, "confkey");
			writeObjectToFile("data/systemcfg.dat", sealedObject);
			System.out.println("New config file writen.");
		} catch (Exception e) {
			System.out.println("Could not write new config file.");
		}
	}
	
	/* (non-Javadoc)
     * @see edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStoreInterface#storeContacts()
     */
	@Override
    public void storeContacts() {
	    // clear directory
	    File dir = new File("data/contacts");
	    if (dir.exists() && dir.isDirectory()) {
	        File[] files = dir.listFiles();
	        for (File f : files) {
	            if (f.isFile())
	                f.delete();
	        }
	    }
	    
		int count = 0;
		for (Contact c : contacts) {
			try {
				String email = c.getEmail().replace("@", ".at.");
				writeObjectToFile("data/contacts/" + email + ".ser", c);
				count++;
			} catch (Exception e) {
				System.out.println("Could not serialize contact.");
			}
		}
		if (contacts.size() > 0) {
			System.out.println("Successfully serialized " + count + "/"
					+ contacts.size() + " contacts");
		}
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public Configuration getConf() {
		return conf;
	}
}
