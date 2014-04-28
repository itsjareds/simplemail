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
 * @author Jared Klingenberger
 * @since 04-24-2014
 */
public class DataStore implements DataStoreInterface {
	private static DataStore instance;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private ArrayList<Email> drafts = new ArrayList<Email>();
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
	
	public static DataStore getInstance() {
		return instance;
	}
	
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
	
	// decrypt using a private key
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
			for (File f : fileList) {
				Object o = readObjectFromFile(f.getPath());
				if (o instanceof Email) {
					Email draft = (Email) o;
					drafts.add(draft);
					System.out.println("Restored draft.");
				}
			}
		}
	}
	
	// encrypted because config contains sensitive data (passwords)
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
		    String email = c.getEmail().replace("@", ".at.");
		    writeObjectToFile("data/contacts/" + email + ".ser", c);
		}
		System.out.println("Successfully serialized contacts.");
	}
	
	@Override
	public void storeDraft(Email draft) throws IOException {
	    writeObjectToFile("data/drafts/" + draft.hashCode() + ".ser", draft);
	    System.out.println("Saved draft.");
	}

	public Configuration getConf() {
		return conf;
	}
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	
	public ArrayList<Email> getDrafts() {
		return drafts;
	}
}
