package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {
	Configuration conf;
	
	@Before
	public void setUp() throws Exception {
		conf = new Configuration();
	}

	@Test
	public void testGetEmail() {
		conf.setEmail((String)null);
		assertSame("getEmail() should return null", null,
				conf.getEmail());
		
		InternetAddress before = conf.getEmail();
		conf.setEmail("this is an invalid address");
		assertSame("Setting an invalid address should not change email",
				before, conf.getEmail());
		
		String email = "otm.shank@aol.biz";
		conf.setEmail(email);
		assertSame("getEmail() returned invalid result", email,
				conf.getEmail().getAddress());
	}

	@Test
	public void testSetEmailString() {
		conf.setEmail((String)null);
		assertSame("getEmail() should return null", null, conf.getEmail());
		
		String email = "otm.shank@aol.biz";
		conf.setEmail(email);
		assertSame("getEmail() returned invalid result", email,
				conf.getEmail().getAddress());
		
		InternetAddress before = conf.getEmail();
		conf.setEmail("this is an invalid address");
		assertEquals("Setting an invalid address should not change email",
				before, conf.getEmail());
	}

	@Test
	public void testSetEmailInternetAddress() {
		conf.setEmail((InternetAddress)null);
		assertEquals("getEmail() should return null", null, conf.getEmail());
		
		String email = "otm.shank@aol.biz";
		InternetAddress address = null;
		try {
			address = new InternetAddress(email);
		} catch (AddressException e) {
			fail("AddressException thrown creating InternetAddress");
			e.printStackTrace();
		}
		conf.setEmail(address);
		assertSame("getEmail() returned invalid result", address,
				conf.getEmail());
		
		InternetAddress before = conf.getEmail();
		try {
			address = new InternetAddress("address");
		} catch (AddressException e) {
			fail("AddressException thrown creating InternetAddress");
			e.printStackTrace();
		}
		conf.setEmail(address);
		assertNotSame("Setting an address should change email",
				before, conf.getEmail());
	}

	@Test
	public void testGetSmtpServer() {
		conf.setSmtpServer((InetAddress)null);
		assertEquals("Smtp server should be null", null, conf.getSmtpServer());
		
		InetAddress inet = null;
		try {
			inet = InetAddress.getByName("google.com");
			conf.setSmtpServer(inet);
		} catch (UnknownHostException e) {
			fail("UnknownHostException thrown creating InetAddress");
			e.printStackTrace();
		}
		assertSame("Smtp server address is not google.com", inet, conf.getSmtpServer());
		
		inet = null;
		try {
			inet = InetAddress.getByName("");
			conf.setSmtpServer(inet);
		} catch (UnknownHostException e) {
			fail("UnknownHostException thrown creating InetAddress");
			e.printStackTrace();
		}
		assertSame("Smtp server address is not \"\"", "localhost", conf.getSmtpServer().getHostName());
	}

	@Test
	public void testSetSmtpServerString() {
		conf.setSmtpServer((String)null);
		assertEquals("Smtp server should be null", null, conf.getSmtpServer());
		
		conf.setSmtpServer("google.com");
		assertEquals("Smtp server address is not google.com", "google.com",
				conf.getSmtpServer().getHostName());
		
		InetAddress before = conf.getSmtpServer();
		conf.setSmtpServer("");
		assertEquals("Smtp server should not have changed", before,
				conf.getSmtpServer());
	}

	@Test
	public void testSetSmtpServerInetAddress() {
		conf.setSmtpServer((InetAddress)null);
		assertEquals("Smtp server should be null", null, conf.getSmtpServer());
		
		InetAddress inet = null;
		try {
			inet = InetAddress.getByName("google.com");
			conf.setSmtpServer(inet);
		} catch (UnknownHostException e) {
			fail("UnknownHostException thrown creating InetAddress");
			e.printStackTrace();
		}
		assertSame("Smtp server address is not google.com", inet, conf.getSmtpServer());
		
		inet = null;
		try {
			inet = InetAddress.getByName("");
			conf.setSmtpServer(inet);
		} catch (UnknownHostException e) {
			fail("UnknownHostException thrown creating InetAddress");
			e.printStackTrace();
		}
		assertSame("Smtp server address is not \"\"", "localhost", conf.getSmtpServer().getHostName());
	}

	@Test
	public void testIsSslUsedSmtp() {
		conf.setSslUsedSmtp(true);
		assertTrue("sslUsedSmtp is not true", conf.isSslUsedSmtp());
		
		conf.setSslUsedSmtp(false);
		assertFalse("sslUsedSmtp is not false", conf.isSslUsedSmtp());
	}

	@Test
	public void testSetSslUsedSmtp() {
		conf.setSslUsedSmtp(true);
		assertTrue("sslUsedSmtp is not true", conf.isSslUsedSmtp());
		
		conf.setSslUsedSmtp(false);
		assertFalse("sslUsedSmtp is not false", conf.isSslUsedSmtp());
	}

	@Test
	public void testIsSslUsedPop3() {
		conf.setSslUsedPop3(true);
		assertTrue("sslUsedPop3 is not true", conf.isSslUsedPop3());
		
		conf.setSslUsedPop3(false);
		assertFalse("sslUsedPop3 is not false", conf.isSslUsedPop3());
	}

	@Test
	public void testSetSslUsedPop3() {
		conf.setSslUsedPop3(true);
		assertTrue("sslUsedPop3 is not true", conf.isSslUsedPop3());
		
		conf.setSslUsedPop3(false);
		assertFalse("sslUsedPop3 is not false", conf.isSslUsedPop3());
	}

	@Test
	public void testGetAuthSmtp() {
		AuthenticationInfo auth = new AuthenticationInfo(null, null);
		conf.setAuthSmtp(auth);
		assertSame("Auth should be null, null", auth, conf.getAuthSmtp());
		
		auth = new AuthenticationInfo("user", null);
		conf.setAuthSmtp(auth);
		assertSame("Auth username should be \"user\"", "user",
				conf.getAuthSmtp().getUsername());

		auth = new AuthenticationInfo(null, "pass");
		conf.setAuthSmtp(auth);
		assertSame("Auth password should be \"pass\"", "pass",
				conf.getAuthSmtp().getPassword());
	}

	@Test
	public void testSetAuthSmtp() {
		AuthenticationInfo auth = new AuthenticationInfo(null, null);
		conf.setAuthSmtp(auth);
		assertSame("Auth should be null, null", auth, conf.getAuthSmtp());
		
		auth = new AuthenticationInfo("user", null);
		conf.setAuthSmtp(auth);
		assertSame("Auth username should be \"user\"", "user",
				conf.getAuthSmtp().getUsername());

		auth = new AuthenticationInfo(null, "pass");
		conf.setAuthSmtp(auth);
		assertSame("Auth password should be \"pass\"", "pass",
				conf.getAuthSmtp().getPassword());
	}

	@Test
	public void testGetAuthPop3() {
		AuthenticationInfo auth = new AuthenticationInfo(null, null);
		conf.setAuthPop3(auth);
		assertSame("Auth should be null, null", auth, conf.getAuthPop3());
		
		auth = new AuthenticationInfo("user", null);
		conf.setAuthPop3(auth);
		assertSame("Auth username should be \"user\"", "user",
				conf.getAuthPop3().getUsername());

		auth = new AuthenticationInfo(null, "pass");
		conf.setAuthPop3(auth);
		assertSame("Auth password should be \"pass\"", "pass",
				conf.getAuthPop3().getPassword());
	}

	@Test
	public void testSetAuthPop3() {
		AuthenticationInfo auth = new AuthenticationInfo(null, null);
		conf.setAuthPop3(auth);
		assertSame("Auth should be null, null", auth, conf.getAuthPop3());
		
		auth = new AuthenticationInfo("user", null);
		conf.setAuthPop3(auth);
		assertSame("Auth username should be \"user\"", "user",
				conf.getAuthPop3().getUsername());

		auth = new AuthenticationInfo(null, "pass");
		conf.setAuthPop3(auth);
		assertSame("Auth password should be \"pass\"", "pass",
				conf.getAuthPop3().getPassword());
	}

	@Test
	public void testGetName() {
		conf.setName("1");
		assertSame("Name is not 1", "1", conf.getName());
		
		conf.setName(null);
		assertEquals("Name is not null", null, conf.getName());
		
		conf.setName("aaaa");
		assertSame("Name is not aaaa", "aaaa", conf.getName());
	}

	@Test
	public void testSetName() {
		conf.setName("1");
		assertSame("Name is not 1", "1", conf.getName());
		
		conf.setName(null);
		assertEquals("Name is not null", null, conf.getName());
		
		conf.setName("aaaa");
		assertSame("Name is not aaaa", "aaaa", conf.getName());
	}

	@Test
	public void testGetPopServer() {
		conf.setPopServer((String)null);
		assertEquals("Pop server should be null", null, conf.getPopServer());
		
		conf.setPopServer("google.com");
		assertEquals("Pop server address is not google.com", "google.com",
				conf.getPopServer().getHostName());
		
		InetAddress before = conf.getPopServer();
		conf.setPopServer("");
		assertEquals("Pop server should not have changed", before,
				conf.getPopServer());
	}

	@Test
	public void testSetPopServerString() {
		conf.setPopServer((String)null);
		assertEquals("Pop server should be null", null, conf.getPopServer());
		
		conf.setPopServer("google.com");
		assertEquals("Pop server address is not google.com", "google.com",
				conf.getPopServer().getHostName());
		
		InetAddress before = conf.getPopServer();
		conf.setPopServer("");
		assertEquals("Pop server should not have changed", before,
				conf.getPopServer());
	}

	@Test
	public void testSetPopServerInetAddress() {
		conf.setPopServer((InetAddress)null);
		assertEquals("Pop server should be null", null, conf.getPopServer());
		
		InetAddress inet = null;
		try {
			inet = InetAddress.getByName("google.com");
			conf.setPopServer(inet);
		} catch (UnknownHostException e) {
			fail("UnknownHostException thrown creating InetAddress");
			e.printStackTrace();
		}
		assertSame("Pop server address is not google.com", inet,
				conf.getPopServer());
		
		inet = null;
		try {
			inet = InetAddress.getByName("");
			conf.setPopServer(inet);
		} catch (UnknownHostException e) {
			fail("UnknownHostException thrown creating InetAddress");
			e.printStackTrace();
		}
		assertSame("Pop server address is not \"\"", "localhost",
				conf.getPopServer().getHostName());
	}

	@Test
	public void testGetSmtpPort() {
		conf.setSmtpPort("1");
		assertSame("Port is not 1", "1", conf.getSmtpPort());
		
		conf.setSmtpPort(null);
		assertEquals("Port is not null", null, conf.getSmtpPort());
		
		conf.setSmtpPort("aaaa");
		assertSame("Port is not aaaa", "aaaa", conf.getSmtpPort());
	}

	@Test
	public void testSetSmtpPort() {
		conf.setSmtpPort("1");
		assertSame("Port is not 1", "1", conf.getSmtpPort());
		
		conf.setSmtpPort(null);
		assertEquals("Port is not null", null, conf.getSmtpPort());
		
		conf.setSmtpPort("aaaa");
		assertSame("Port is not aaaa", "aaaa", conf.getSmtpPort());
	}

	@Test
	public void testGetPopPort() {
		conf.setPopPort("1");
		assertSame("Port is not 1", "1", conf.getPopPort());
		
		conf.setPopPort(null);
		assertEquals("Port is not null", null, conf.getPopPort());
		
		conf.setPopPort("aaaa");
		assertSame("Port is not aaaa", "aaaa", conf.getPopPort());
	}

	@Test
	public void testSetPopPort() {
		conf.setPopPort("1");
		assertSame("Port is not 1", "1", conf.getPopPort());
		
		conf.setPopPort(null);
		assertEquals("Port is not null", null, conf.getPopPort());
		
		conf.setPopPort("aaaa");
		assertSame("Port is not aaaa", "aaaa", conf.getPopPort());
	}

}
