package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Contact class
 * @author shiz
 * @since 4-28-14
 *
 */
public class ContactTest {
    
    Contact contact = new Contact("","","","");
    
    @Before
    public void testSetup() throws Exception{
        contact.setName("Clemson");
        contact.setEmail("Clemson@tiger.edu");
        contact.setPhone("1234567890");
        contact.setAddress("Clemson University");

    }
    
    @Test
    public void testContact() {
        
        Contact contact1 = new Contact("Unit","Testing","1","01");
        assertEquals(contact1.getName(), "Unit");
        assertEquals(contact1.getAddress(), "Testing");
        assertEquals(contact1.getPhone(),"1");
        assertEquals(contact1.getEmail(),"01");
    }

    @Test
    public void testGetName() {
        //test 1
        assertEquals("Clemson", contact.getName());
        
        //test 2
        contact.setName("Tiger");
        assertEquals("Tiger", contact.getName());
        
        //test 3
        contact.setName(null);
        assertNull(contact.getName());
        
    }

    @Test
    public void testSetName() {
        //test 1
        contact.setName("Football");
        assertEquals("Football", contact.getName());
        
        //test 2
        contact.setName(null);
        assertNull(contact.getName());
        
        
    }

    @Test
    public void testGetAddress() {
        //test 1
        assertEquals("Clemson University", contact.getAddress());
        
        //test 2
        contact.setAddress("Tiger");
        assertEquals("Tiger", contact.getAddress());
        
        //test 3
        contact.setAddress(null);
        assertNull(contact.getAddress());
    }

    @Test
    public void testSetAddress() {
        //test 1
        contact.setAddress("Football");
        assertEquals("Football", contact.getAddress());
        
        //test 2
        contact.setAddress(null);
        assertNull(contact.getAddress());
        
    }

    @Test
    public void testGetPhone() {
        //test 1
        assertEquals("1234567890", contact.getPhone());
        
        //test 2
        contact.setPhone("Tiger");
        assertEquals("Tiger", contact.getPhone());
        
        //test 3
        contact.setPhone(null);
        assertNull(contact.getPhone());
    }

    @Test
    public void testSetPhone() {
        //test 1
        contact.setPhone("Football");
        assertEquals("Football", contact.getPhone());
        
        //test 2
        contact.setPhone(null);
        assertNull(contact.getPhone());
        
    }

    @Test
    public void testGetEmail() {
        //test 1
        assertEquals("Clemson@tiger.edu", contact.getEmail());
        
        //test 2
        contact.setEmail("Tiger");
        assertEquals("Tiger", contact.getEmail());
        
        //test 3
        contact.setEmail(null);
        assertNull(contact.getEmail());
    }

    @Test
    public void testSetEmail() {
        //test 1
        contact.setEmail("Football");
        assertEquals("Football", contact.getEmail());
        
        //test 2
        contact.setEmail(null);
        assertNull(contact.getEmail());
        
    }

}
