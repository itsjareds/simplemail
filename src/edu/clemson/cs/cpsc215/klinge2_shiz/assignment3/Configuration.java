package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Configuration class which contains system information about the user.
 * 
 * @author Jared Klingenberger
 * @since 04-24-2014
 */

public class Configuration implements Serializable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -4594924520320758448L;
	private InternetAddress email = null;
	private InetAddress smtpServer = null;
	
	public InternetAddress getEmail() {
		return email;
	}
	/**
	 * @param s String interpreted as an InternetAddress.
	 */
	public void setEmail(String s) {
		try {
			this.email = new InternetAddress(s);
		} catch (AddressException e) {
			// invalid Internet address
			e.printStackTrace();
		}
	}
	public void setEmail(InternetAddress email) {
		this.email = email;
	}
	
	public InetAddress getSmtpServer() {
		return smtpServer;
	}
	/**
	 * @param host String hostname which is resolved to an IP address.
	 */
	public void setSmtpServer(String host) {
		try {
			this.smtpServer = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			// host not resolved
			e.printStackTrace();
		}
	}
	public void setSmtpServer(InetAddress smtpServer) {
		this.smtpServer = smtpServer;
	}
	
	public String toString() {
		String s = "";
		s += "[{email:" + email + "},{smtpServer:" + smtpServer + "}]";
		return s;
	}
}
