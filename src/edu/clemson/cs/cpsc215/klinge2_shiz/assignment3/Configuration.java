package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Configuration class which contains system information about the user.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class Configuration implements Serializable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -1512998686589319997L;
	private InternetAddress email = null;
	private InetAddress smtpHost = null;
	private String smtpPort = "";
	private InetAddress popHost = null;
	private String popPort = "";
	private String name = "";
	
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
		}
	}
	/**
	 * @param email the new user's email address
	 */
	public void setEmail(InternetAddress email) {
		this.email = email;
	}
	
	/**
	 * @return get the SMTP host
	 */
	public InetAddress getSmtpServer() {
		return smtpHost;
	}
	/**
	 * @param host String hostname which is resolved to an IP address.
	 */
	public void setSmtpServer(String host) {
		try {
		    if (host != null && host.length() > 0)
		        this.smtpHost = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			// host not resolved
		}
	}
	/**
	 * @param smtpServer set the SMTP host
	 */
	public void setSmtpServer(InetAddress smtpServer) {
		this.smtpHost = smtpServer;
	}
	/**
	 * @return boolean value indicating SSL use for SMTP
	 */
	public boolean isSslUsedSmtp() {
		return sslUsedSmtp;
	}
	/**
	 * @param sslUsedSmtp set boolean value indicating SSL use for SMTP
	 */
	public void setSslUsedSmtp(boolean sslUsedSmtp) {
		this.sslUsedSmtp = sslUsedSmtp;
	}
	/**
	 * @return boolean value indicating SSL use for POP
	 */
	public boolean isSslUsedPop3() {
		return sslUsedPop3;
	}
	/**
	 * @param sslUsedPop3 set boolean value indicating SSL use for POP
	 */
	public void setSslUsedPop3(boolean sslUsedPop3) {
		this.sslUsedPop3 = sslUsedPop3;
	}
	/**
	 * @return the authentication info for SMTP
	 */
	public AuthenticationInfo getAuthSmtp() {
		return authSmtp;
	}
	/**
	 * @param authSmtp the new authentication info for SMTP
	 */
	public void setAuthSmtp(AuthenticationInfo authSmtp) {
		this.authSmtp = authSmtp;
	}
	/**
	 * @return the authentication info for POP
	 */
	public AuthenticationInfo getAuthPop3() {
		return authPop3;
	}
	/**
	 * @param authPop3 the new authentication info for POP
	 */
	public void setAuthPop3(AuthenticationInfo authPop3) {
		this.authPop3 = authPop3;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		s += "[";
		s += "{name:" + name + "},";
		s += "{email:" + email + "},";
		s += "{smtpServer:" + smtpHost + "},";
		s += "{smtpPort:" + smtpPort + "},";
		s += "{popServer:" + popHost + "},";
		s += "{popPort:" + popPort + "},";
		s += "{sslUsedSmtp:" + sslUsedSmtp + "},";
		s += "{sslUsedPop3:" + sslUsedPop3 + "}";
		s += "]";
		return s;
	}
	/**
	 * @return the user's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the POP hostname
	 */
	public InetAddress getPopServer() {
		return popHost;
	}
	/**
	 * @param host String hostname which is resolved to an IP address.
	 */
	public void setPopServer(String host) {
		try {
		    if (host != null && host.length() > 0)
		        this.popHost = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			// host not resolved
		}
	}
	/**
	 * @param popServer the POP hostname to set
	 */
	public void setPopServer(InetAddress popServer) {
		this.popHost = popServer;
	}
    /**
     * @return the SMTP port
     */
    public String getSmtpPort() {
        return smtpPort;
    }
    /**
     * @param smtpPort the SMTP port to set
     */
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }
    /**
     * @return the POP port
     */
    public String getPopPort() {
        return popPort;
    }
    /**
     * @param popPort the new POP port to set
     */
    public void setPopPort(String popPort) {
        this.popPort = popPort;
    }
}