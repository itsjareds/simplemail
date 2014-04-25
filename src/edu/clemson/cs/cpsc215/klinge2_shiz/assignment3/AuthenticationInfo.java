package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

public class AuthenticationInfo {
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
