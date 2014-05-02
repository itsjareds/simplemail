package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

/**
 * Data storage class which provides functionality to store and load
 * runtime configuration to and from the hard disk.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class DataStore implements DataStoreInterface {
	private static DataStore instance;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private ArrayList<Draft> drafts = new ArrayList<Draft>();
	private Configuration conf = new Configuration();
	private HashMap<String, SecretKey> keyring =
			new HashMap<String, SecretKey>();
	
	static {
	    instance = new DataStore();
	    try {
            instance.loadConf();
        } catch (Exception e) {
            System.out.println("Could not load config file.");
            e.printStackTrace();
        }
	    try {
            instance.loadContacts();
        } catch (Exception e) {
            System.out.println("Could not load contacts.");
            e.printStackTrace();
        }
	    try {
	    	instance.loadDrafts();
	    } catch (Exception e) {
	    	System.out.println("Could not load drafts.");
	    	e.printStackTrace();
	    }
	}
	
	private DataStore() {
		// disable the default public constructor
	}
	
	/**
	 * @return A reference to the single DataStore instance
	 */
	public static DataStore getInstance() {
		return instance;
	}
	
	/**
	 * @param file Name of the file to write
	 * @param o Object to write to file
	 * @throws IOException
	 */
	private void writeObjectToFile(String file, Object o) throws IOException {
		File f = new File(file);
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
	}
	
	/**
	 * @param file Name of the file to read
	 * @return The object read from file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private Object readObjectFromFile(String file) throws IOException,
	        ClassNotFoundException {
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
	
	/**
	 * @param keyName The name of the key
	 * @return The SecretKey object referred to by KeyName
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private SecretKey getKey(String keyName) throws IOException, 
	        ClassNotFoundException {
		SecretKey key = null;
		Object okey = null;
		okey = readObjectFromFile("data/keyring/" + keyName + ".dat");

		if (okey != null && okey instanceof SecretKey) {
			key = (SecretKey) okey;
			keyring.put(keyName, key);
		}
		return key;
	}
	
	/**
	 * @param keyName Name of the key which locks fileName
	 * @param fileName Name of the file to decrypt
	 * @return A decrypted object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws CryptographyException
	 */
	private Object decryptObject(String keyName, String fileName)
	        throws IOException, ClassNotFoundException, CryptographyException {
	    
	    Object obj = null, decryptedObject = null;
	    
	    try {
    		SecretKey key = getKey(keyName);
    		obj = readObjectFromFile(fileName);
    		
    		if (obj != null && key != null && obj instanceof SealedObject) {
    			SealedObject sealedObject = (SealedObject) obj;
    			
    			Cipher cipher = Cipher.getInstance(key.getAlgorithm());
    			cipher.init(Cipher.DECRYPT_MODE, key);
    			
    			decryptedObject = sealedObject.getObject(cipher);
    		}
	    } catch (NoSuchPaddingException e) {
	        throw new CryptographyException(e);
	    } catch (BadPaddingException e) {
	        throw new CryptographyException(e);
	    } catch (NoSuchAlgorithmException e) {
	        throw new CryptographyException(e);
	    } catch (InvalidKeyException e) {
	        throw new CryptographyException(e);
	    } catch (IllegalBlockSizeException e) {
	        throw new CryptographyException(e);
	    }
	    
		return decryptedObject;
	}
	
	/**
	 * @param obj Object to encrypt
	 * @param keyName Name of the key to use
	 * @return An encrypted object
	 * @throws IOException
	 * @throws CryptographyException
	 */
	private SealedObject encryptObject(Serializable obj, String keyName)
	        throws IOException, CryptographyException {
	    SealedObject sealedObject = null;
	    
	    try {
    		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    		sealedObject = null;
    		
    		writeObjectToFile("data/keyring/" + keyName + ".dat", key);
    		
    		Cipher cipher = Cipher.getInstance("DES");
    		cipher.init(Cipher.ENCRYPT_MODE, key);
    		
    		sealedObject = new SealedObject(obj, cipher);
	    } catch (NoSuchPaddingException e) {
	        throw new CryptographyException(e);
	    } catch (NoSuchAlgorithmException e) {
	        throw new CryptographyException(e);
	    } catch (InvalidKeyException e) {
	        throw new CryptographyException(e);
	    } catch (IllegalBlockSizeException e) {
	        throw new CryptographyException(e);
	    }

		return sealedObject;
	}
	
	@Override
    public void loadConf() throws ClassNotFoundException, IOException,
            CryptographyException {
		Object obj = decryptObject("confkey", "data/systemcfg.dat");
		if (obj instanceof Configuration) {
			conf = (Configuration) obj;
			System.out.println("Restored configuration: " + conf);
		}
	}
	
	@Override
    public void loadContacts() throws ClassNotFoundException, IOException {
		File[] fileList = new File("data/contacts/").listFiles();
		
		if (fileList != null) {
			contacts.clear();
			for (File f : fileList) {
				Object o = readObjectFromFile(f.getPath());
				if (o instanceof Contact) {
					Contact c = (Contact) o;
					contacts.add(c);
					System.out.println("Restored contact: " + c.getName());
				}
			}
		}
	}
	
	@Override
	public void loadDrafts() throws ClassNotFoundException, IOException {
		File[] fileList = new File("data/drafts/").listFiles();
		
		if (fileList != null) {
			drafts.clear();
			for (File f : fileList) {
				Object o = readObjectFromFile(f.getPath());
				if (o instanceof Draft) {
					Draft draft = (Draft) o;
					drafts.add(draft);
					System.out.println("Restored draft.");
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStoreInterface#storeConf()
	 */
	@Override
    public void storeConf() throws IOException, CryptographyException {
	    SealedObject sealedObject = encryptObject(conf, "confkey");
	    writeObjectToFile("data/systemcfg.dat", sealedObject);
	    System.out.println("New config file written.");
	}
	
	@Override
    public void storeContacts() throws IOException {
	    // clear directory
	    File dir = new File("data/contacts");
	    if (dir.exists() && dir.isDirectory()) {
	        File[] files = dir.listFiles();
	        for (File f : files) {
	            if (f.isFile())
	                f.delete();
	        }
	    }
	    
		for (Contact c : contacts) {
		    writeObjectToFile("data/contacts/" + c.hashCode() + ".ser", c);
		}
		System.out.println("Successfully serialized contacts.");
	}
	
	@Override
	public void storeDrafts() throws IOException {
	    // clear directory
	    File dir = new File("data/drafts");
	    if (dir.exists() && dir.isDirectory()) {
	        File[] files = dir.listFiles();
	        for (File f : files) {
	            if (f.isFile())
	                f.delete();
	        }
	    }
	    
		for (Draft d : drafts) {
		    writeObjectToFile("data/drafts/" + d.hashCode() + ".ser", d);
		}
		System.out.println("Successfully serialized drafts.");
	}

	/**
	 * @return A reference to the global configuration object
	 */
	public Configuration getConf() {
		return conf;
	}
	
	/**
	 * @return A reference to the global contacts list
	 */
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	
	/**
	 * @return A reference to the global drafts list
	 */
	public ArrayList<Draft> getDrafts() {
		return drafts;
	}
}
