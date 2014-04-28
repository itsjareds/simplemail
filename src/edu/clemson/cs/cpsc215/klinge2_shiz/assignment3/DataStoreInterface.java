package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.IOException;

/**
 * Interface for DataStore
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public interface DataStoreInterface {

    /**
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws CryptographyException
     */
    public void loadConf() throws ClassNotFoundException, IOException,
        CryptographyException;
    /**
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void loadContacts() throws ClassNotFoundException, IOException;
    /**
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void loadDrafts() throws ClassNotFoundException, IOException;
    
    /**
     * @throws IOException
     * @throws CryptographyException
     */
    public void storeConf() throws IOException, CryptographyException;
    /**
     * @throws IOException
     */
    public void storeContacts() throws IOException;
    /**
     * @throws IOException
     */
    public void storeDrafts() throws IOException;

}