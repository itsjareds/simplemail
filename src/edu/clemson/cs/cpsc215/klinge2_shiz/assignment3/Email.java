package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.List;
import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Email class which aggregates information about an email draft.
 * 
 * @author Jared Klingenberger
 * @since 04-24-2014
 */
public class Email {
	private InternetAddress[] toField = {};
	private InternetAddress[] ccField = {};
	private InternetAddress[] bccField = {};
	private String subject = "";
	private String message = "";
	
	public Email() { }
	
	/**
	 * Email(String to, String cc, String bcc, String subj, String msg) is a
	 * constructor for Email which takes all String parameters.
	 * 
	 * @param to String of TO email addresses separated by commas
	 * @param cc String of CC email addresses separated by commas
	 * @param bcc String of BCC email addresses separated by commas
	 * @param subj A String subject line
	 * @param msg A String message body
	 */
	public Email(String to, String cc, String bcc, String subj, String msg) {
		if (to != null)
			toField = parseAddressList(to);
		if (cc != null)
			ccField = parseAddressList(cc);
		if (bcc != null)
			bccField = parseAddressList(bcc);
		if (subject != null)
			subject = subj;
		if (msg != null)
			message = msg;
	}
	
	/**
	 * Email(List<Contact> to, List<Contact> cc, List<Contact> bcc,
	 * String subj, String msg) is a constructor for Email which takes
	 * List<Contact> parameters to represent contact lists.
	 * 
	 * @param to List<Contact> of TO email addresses separated by commas
	 * @param cc List<Contact> of CC email addresses separated by commas
	 * @param bcc List<Contact> of BCC email addresses separated by commas
	 * @param subj A String subject line
	 * @param msg A String message body
	 */
	public Email(List<Contact> to, List<Contact> cc, List<Contact> bcc,
			String subj, String msg) {
		if (to != null)
			toField = parseAddressList(to);
		if (cc != null)
			ccField = parseAddressList(cc);
		if (bcc != null)
			bccField = parseAddressList(bcc);
		if (subject != null)
			subject = subj;
		if (msg != null)
			message = msg;
	}
	
	/**
	 * parseAddressList(String list) takes a string containing email addresses
	 * separated by commas and converts it to a list of InternetAddress objects
	 * in respect to the list.
	 * @see #parseAddressList(List<Contact>)
	 * 
	 * @param list String containing email addresses separated by commas
	 * @return Array of InternetAddresses represented by the parameter.
	 */
	public static InternetAddress[] parseAddressList(String list) {
		String[] addrList = list.split("[\n\r\t ]*,[\n\r\t ]*");
		ArrayList<InternetAddress> inetList = new ArrayList<InternetAddress>();
		
		for (String address : addrList) {
			try {
				InternetAddress i = new InternetAddress(address);
				inetList.add(i);
			} catch (AddressException e) {
				// invalid syntax for the address
			}
		}
		
		return inetList.toArray(new InternetAddress[inetList.size()]);
	}
	
	/**
	 * parseAddressList(List<Contact> contacts) provides similar 
	 * functionality as #parseAddressList(String list). Intended for features
	 * such as reply-all, send-all, etc.
	 * @see #parseAddressList(String list)
	 * 
	 * @param contacts List of Contacts whose email addresses are extracted.
	 * @return Array of InternetAddresses represented by the parameter.
	 */
	public static InternetAddress[] parseAddressList(List<Contact> contacts) {
		ArrayList<InternetAddress> inetList = new ArrayList<InternetAddress>();
		
		if (contacts != null) {
    		for (Contact c : contacts) {
    			try {
    				InternetAddress i = new InternetAddress(c.getEmail());
    				inetList.add(i);
    			} catch (AddressException e) {
    				// invalid syntax for the address
    				e.printStackTrace();
    			}
    		}
		}
		
		return inetList.toArray(new InternetAddress[inetList.size()]);
	}
	
	public InternetAddress[] getToField() {
		return toField;
	}
	public void setToField(InternetAddress[] toField) {
		this.toField = toField;
	}
	public InternetAddress[] getCcField() {
		return ccField;
	}
	public void setCcField(InternetAddress[] ccField) {
		this.ccField = ccField;
	}
	public InternetAddress[] getBccField() {
		return bccField;
	}
	public void setBccField(InternetAddress[] bccField) {
		this.bccField = bccField;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
