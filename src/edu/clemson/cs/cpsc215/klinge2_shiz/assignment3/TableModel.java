package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	
	private String[] columnNames = {"Name",
							"Email",
							"Phone",
							"Address"};
	
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
