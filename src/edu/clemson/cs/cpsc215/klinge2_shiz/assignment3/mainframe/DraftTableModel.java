package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Draft;

/**
 * Draft table model. Set up draft table.
 * extends AbstractTableModel
 * @author klinge2 
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class DraftTableModel extends AbstractTableModel {
	
	//column names
	private String[] columnNames = {"Subject",
							"To",
							"Body",
							"Time"};
	
	//get data from DataStore
	private ArrayList<Draft> data = DataStore.getInstance().getDrafts(); 

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
	 * Get the content of the row
	 * @param index
	 * @return content of the row
	 */
	public Draft getRow(int index) {
	    Draft d = null;
	    if (index >= 0 && index < data.size())
	        d = data.get(index);
	    return d;
	}

	/**
	 * Convert array data to string
	 * @param array
	 * @param delim
	 * @return String data
	 */
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
	    Object value = "";
	    Draft draft = getRow(row);
	    
	    if (draft != null) {
	        switch (column) {
	        case 0:
	            value = draft.getSubject();
	            break;
	        case 1:
	        	value = join(draft.getToField(), ", ");
	            break;
	        case 2:
	        	value = draft.getMessage();
	        	break;
	        case 3:
	        	Date date =  draft.getDate();
	        	value = date.toString();
	        	break;
	        }
	    }
	    
	    if (value == "" || value == null)
	    	value = "<none>";
	    
	    return value;
	}

}
