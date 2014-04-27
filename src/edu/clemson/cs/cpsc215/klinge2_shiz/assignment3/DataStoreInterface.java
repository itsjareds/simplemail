package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.IOException;

public interface DataStoreInterface {

    public void loadConf() throws ClassNotFoundException, IOException,
        CryptographyException;
    public void loadContacts() throws ClassNotFoundException, IOException;
    public void storeConf() throws IOException, CryptographyException;
    public void storeContacts() throws IOException;

}