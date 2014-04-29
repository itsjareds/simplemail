package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DataStoreTest {
	DataStore storage = null;

	@Before
	public void setUp() throws Exception {
		storage = DataStore.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertSame("getInstance() does not return identical results try #1",
				storage, DataStore.getInstance());
		
		assertSame("getInstance() does not return identical results try #2",
				storage, DataStore.getInstance());
		
		assertSame("getInstance() does not return identical results try #3",
				storage, DataStore.getInstance());
	}

	@Test
	public void testLoadConf() {
		Configuration before = storage.getConf();
		try {
			storage.loadConf();
		} catch (Exception e) {
			fail("Error occurred during loadConf()");
			e.printStackTrace();
		}
		assertEquals("Names not equal", before.getName(),
				storage.getConf().getName());
		
		assertEquals("Emails not equal", before.getEmail(),
				storage.getConf().getEmail());
		
		assertEquals("Ports not equal", before.getSmtpPort(),
				storage.getConf().getSmtpPort());
	}

	@Test
	public void testLoadContacts() {
		List<Contact> before = storage.getContacts();
		try {
			storage.storeContacts();
			storage.loadContacts();
		} catch (Exception e) {
			fail("Error occurred during loadContacts() or storeContacts()");
			e.printStackTrace();
		}
		assertEquals("Sizes not equal", before.size(),
				storage.getContacts().size());
		for (int i = 0; i < storage.getContacts().size(); i++) {
			assertEquals("Addresses not equal", before.get(i).getName(),
					storage.getContacts().get(i).getName());
			assertEquals("Emails not equal", before.get(i).getEmail(),
					storage.getContacts().get(i).getEmail());
			assertEquals("Phones not equal", before.get(i).getPhone(),
					storage.getContacts().get(i).getPhone());
		}
	}

	@Test
	public void testLoadDrafts() {
		List<Draft> before = storage.getDrafts();
		try {
			storage.storeDrafts();
			storage.loadDrafts();
		} catch (Exception e) {
			fail("Error occurred during loadDrafts() or storeDrafts()");
			e.printStackTrace();
		}
		assertEquals("Sizes not equal", before.size(),
				storage.getDrafts().size());
		for (int i = 0; i < storage.getDrafts().size(); i++) {
			assertEquals("Dates not equal", before.get(i).getDate(),
					storage.getDrafts().get(i).getDate());
			assertEquals("Bodies not equal", before.get(i).getMessage(),
					storage.getDrafts().get(i).getMessage());
			assertEquals("Subjects not equal", before.get(i).getSubject(),
					storage.getDrafts().get(i).getSubject());
		}
	}

	@Test
	public void testStoreConf() {
		Configuration before = storage.getConf();
		try {
			storage.storeConf();
			storage.loadConf();
		} catch (Exception e) {
			fail("Error occurred during loadConf() or storeConf()");
			e.printStackTrace();
		}
		assertEquals("Names not equal", before.getName(),
				storage.getConf().getName());
		
		assertEquals("Emails not equal", before.getEmail(),
				storage.getConf().getEmail());
		
		assertEquals("Ports not equal", before.getSmtpPort(),
				storage.getConf().getSmtpPort());
	}

	@Test
	public void testStoreContacts() {
		List<Contact> before = storage.getContacts();
		try {
			storage.storeContacts();
			storage.loadContacts();
		} catch (Exception e) {
			fail("Error occurred during loadContacts() or storeContacts()");
			e.printStackTrace();
		}
		assertEquals("Sizes not equal", before.size(),
				storage.getContacts().size());
		for (int i = 0; i < storage.getContacts().size(); i++) {
			assertEquals("Addresses not equal", before.get(i).getName(),
					storage.getContacts().get(i).getName());
			assertEquals("Emails not equal", before.get(i).getEmail(),
					storage.getContacts().get(i).getEmail());
			assertEquals("Phones not equal", before.get(i).getPhone(),
					storage.getContacts().get(i).getPhone());
		}
	}

	@Test
	public void testStoreDrafts() {
		List<Draft> before = storage.getDrafts();
		try {
			storage.storeDrafts();
			storage.loadDrafts();
		} catch (Exception e) {
			fail("Error occurred during loadDrafts() or storeDrafts()");
			e.printStackTrace();
		}
		assertEquals("Sizes not equal", before.size(),
				storage.getDrafts().size());
		for (int i = 0; i < storage.getDrafts().size(); i++) {
			assertEquals("Dates not equal", before.get(i).getDate(),
					storage.getDrafts().get(i).getDate());
			assertEquals("Bodies not equal", before.get(i).getMessage(),
					storage.getDrafts().get(i).getMessage());
			assertEquals("Subjects not equal", before.get(i).getSubject(),
					storage.getDrafts().get(i).getSubject());
		}
	}

	@Test
	public void testGetConf() {
		Configuration before = storage.getConf();
		try {
			storage.loadConf();
		} catch (Exception e) {
			fail("Error occurred during loadConf()");
			e.printStackTrace();
		}
		assertEquals("Names not equal", before.getName(),
				storage.getConf().getName());
		
		assertEquals("Emails not equal", before.getEmail(),
				storage.getConf().getEmail());
		
		assertEquals("Ports not equal", before.getSmtpPort(),
				storage.getConf().getSmtpPort());
	}

	@Test
	public void testGetContacts() {
		List<Contact> before = storage.getContacts();
		try {
			storage.storeContacts();
			storage.loadContacts();
		} catch (Exception e) {
			fail("Error occurred during loadContacts() or storeContacts()");
			e.printStackTrace();
		}
		assertEquals("Sizes not equal", before.size(),
				storage.getContacts().size());
		for (int i = 0; i < storage.getContacts().size(); i++) {
			assertEquals("Addresses not equal", before.get(i).getName(),
					storage.getContacts().get(i).getName());
			assertEquals("Emails not equal", before.get(i).getEmail(),
					storage.getContacts().get(i).getEmail());
			assertEquals("Phones not equal", before.get(i).getPhone(),
					storage.getContacts().get(i).getPhone());
		}
	}

	@Test
	public void testGetDrafts() {
		List<Draft> before = storage.getDrafts();
		try {
			storage.storeDrafts();
			storage.loadDrafts();
		} catch (Exception e) {
			fail("Error occurred during loadDrafts() or storeDrafts()");
			e.printStackTrace();
		}
		assertEquals("Sizes not equal", before.size(),
				storage.getDrafts().size());
		for (int i = 0; i < storage.getDrafts().size(); i++) {
			assertEquals("Dates not equal", before.get(i).getDate(),
					storage.getDrafts().get(i).getDate());
			assertEquals("Bodies not equal", before.get(i).getMessage(),
					storage.getDrafts().get(i).getMessage());
			assertEquals("Subjects not equal", before.get(i).getSubject(),
					storage.getDrafts().get(i).getSubject());
		}
	}

}
