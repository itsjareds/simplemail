package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.Serializable;

/**
 * Contact class maintains information about a single email contact.
 * implements Serializable
 * 
 * @author shiz
 * @since 04-28-14
 */

public class Contact implements Serializable {
    /**
     * Automatically generated serial ID
     */
    private static final long serialVersionUID = 261744957588450320L;
    private String name;
    private String address;
    private String phone;
    private String email;
    
    /**
     * @param name of the new contact
     * @param address of the new contact
     * @param phone of the new contact
     * @param email of the new contact
     */
    public Contact(String name, String address, String phone, String email) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    /**
     * @return contact name
     */
    public String getName() {
        return name;
    }

    /**
     * @param contact name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return contact address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param contact address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return contact phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param contact phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return contact email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param contact email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
