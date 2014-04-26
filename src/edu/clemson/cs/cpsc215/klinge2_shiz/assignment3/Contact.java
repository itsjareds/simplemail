package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.Serializable;
/**
 * Contact class maintains information about a single email contact.
 * 
 * @author shiz
 * @since 4/24/14
 *
 */
public class Contact implements Serializable {
	private static final long serialVersionUID = 261744957588450320L;
	private String name;
	private String address;
	private String phone;
	private String email;
	
	public Contact(String name, String address, String phone, String email) {
		this.address = address;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
