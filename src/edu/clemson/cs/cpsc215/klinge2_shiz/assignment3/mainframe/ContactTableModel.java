package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;


/**
 * Contact table model. Set up contact table.
 * extends AbstractTableModel
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ContactTableModel extends AbstractTableModel {
	//column names
	private String[] columnNames = {"Name",
							"Email",
							"Phone",
							"Address"};
	
	//get data from Datastore
	private ArrayList<Contact> data = DataStore.getInstance().getContacts(); 
	

	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}
	

	public int getColumnCount() {
		return columnNames.length;
	}


	@Override
	public int getRowCount() {
		return data.size();
	}
	
	/**
	 * get content from a row
	 * @param index
	 * @return row contents
	 */
	public Contact getRow(int index) {
	    Contact c = null;
	    if (index >= 0 && index < data.size())
	        c = data.get(index);
	    return c;
	}


	@Override
	public Object getValueAt(int row, int column) {
	    Object value = null;
	    Contact contact = getRow(row);
	    
	    if (contact != null) {
	        switch (column) {
	        case 0:
	            value = contact.getName();
	            break;
	        case 1:
	            value = contact.getEmail();
	            break;
	        case 2:
	            value = contact.getPhone();
	            break;
	        case 3:
	            value = contact.getAddress();
	            break;
	        }
	    }
	    
	    return value;
	}

}
