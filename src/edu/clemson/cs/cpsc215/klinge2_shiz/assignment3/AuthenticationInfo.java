package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.Serializable;

/**
 * Class which stores authentication information.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class AuthenticationInfo implements Serializable {
	/**
     * Automatically generated serialVersionUID
     */
    private static final long serialVersionUID = -8189755001479947856L;
    private String username, password;
    
    public AuthenticationInfo(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
