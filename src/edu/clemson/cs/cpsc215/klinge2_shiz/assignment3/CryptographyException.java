package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

@SuppressWarnings("serial")
public class CryptographyException extends Exception {
    
    private static String message = "";
    
    {
        message += "A cryptography exception occured.\n";
        message += "  nested exception:\n";
    }
    
    public CryptographyException(Exception e) {
        super(message + e.getMessage());
    }
    
}
