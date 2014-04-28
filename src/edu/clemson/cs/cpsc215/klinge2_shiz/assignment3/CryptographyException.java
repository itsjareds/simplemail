package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

/**
 * Aggregate exception class which is thrown by DataStore.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public class CryptographyException extends Exception {
    
    private static String message = "";
    
    {
        message += "A cryptography exception occured.\n";
        message += "  nested exception:\n";
    }
    
    /**
     * @param nestedException the exception that threw a CryptographyException
     */
    public CryptographyException(Exception nestedException) {
        super(message + nestedException.getMessage());
    }
    
}
