package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.Serializable;

public class AuthenticationInfo implements Serializable {
    /**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -6588397296000495803L;
	private String username, password, authport;
    
    public AuthenticationInfo(String user, String pass, String port) {
        this.username = user;
        this.password = pass;
        this.authport = port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthport() {
        return authport;
    }
    
    
}
