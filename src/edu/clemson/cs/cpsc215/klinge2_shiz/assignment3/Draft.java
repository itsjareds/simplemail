package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.Date;

/**
 * Draft class which decorates Email with time information
 * 
 * @author klinge2
 * @since 04-28-2014
 */

// Decorator of Email
public class Draft extends Email {
	private static final long serialVersionUID = -1574493737779239049L;
	private Date date;
	
	public Draft(Email email) {
		this.setToField(email.getToField());
		this.setCcField(email.getCcField());
		this.setBccField(email.getBccField());
		this.setSubject(email.getSubject());
		this.setMessage(email.getMessage());
		this.setDate(new Date());
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
