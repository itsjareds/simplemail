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
	private static final long serialVersionUID = 8567872862487853526L;
	private InternetAddress email = null;
	private InetAddress smtpServer = null;
	private String name = null;
	
	// sensitive variables (encrypted when serialized)
	private boolean sslUsedSmtp = false;
	private boolean sslUsedPop3 = false;
	private AuthenticationInfo authSmtp = null;
	private AuthenticationInfo authPop3 = null;
	
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
	public boolean isSslUsedSmtp() {
		return sslUsedSmtp;
	}
	public void setSslUsedSmtp(boolean sslUsedSmtp) {
		this.sslUsedSmtp = sslUsedSmtp;
	}
	public boolean isSslUsedPop3() {
		return sslUsedPop3;
	}
	public void setSslUsedPop3(boolean sslUsedPop3) {
		this.sslUsedPop3 = sslUsedPop3;
	}
	public AuthenticationInfo getAuthSmtp() {
		return authSmtp;
	}
	public void setAuthSmtp(AuthenticationInfo authSmtp) {
		this.authSmtp = authSmtp;
	}
	public AuthenticationInfo getAuthPop3() {
		return authPop3;
	}
	public void setAuthPop3(AuthenticationInfo authPop3) {
		this.authPop3 = authPop3;
	}
	
	public String toString() {
		String s = "";
		s += "[{email:" + email + "},{smtpServer:" + smtpServer + "}," +
				"{sslUsedSmtp:" + sslUsedSmtp + "},{sslUsedPop3:" + 
				sslUsedPop3 + "}]";
		return s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}