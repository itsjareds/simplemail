package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.util.ArrayList;

import javax.mail.internet.InternetAddress;
import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Email;

@SuppressWarnings("serial")
public class DraftTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"Time",
							"To",
							"Cc",
							"Bcc",
							"Body"};
	
	private ArrayList<Email> data = DataStore.getInstance().getDrafts(); 
	
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
	
	public Email getRow(int index) {
	    Email d = null;
	    if (index >= 0 && index < data.size())
	        d = data.get(index);
	    return d;
	}

	private String join(Object[] array, String delim) {
    	String s = "";
    	if (array != null) {
	    	for (int i = 0; i < array.length; i++) {
	    		if (i != 0)
	    			s += delim;
	    		s += array[i];
	    	}
    	}
    	return s;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
	    Object value = null;
	    Email draft = getRow(row);
	    
	    if (draft != null) {
	        switch (column) {
	        case 0:
	            value = "";
	            break;
	        case 1:
	        	value = join(draft.getToField(), ", ");
	            break;
	        case 2:
	            value = join(draft.getCcField(), ", ");
	            break;
	        case 3:
	            value = join(draft.getBccField(), ", ");
	            break;
	        case 4:
	        	value = draft.getMessage();
	        	break;
	        }
	    }
	    
	    return value;
	}

}
