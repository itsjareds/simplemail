package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 4069322705542354160L;

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

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
		
		 case 0:
			 return data.get(row).getName();
		 case 1:
			 return data.get(row).getEmail();
		 case 2:
			 return data.get(row).getPhone();
		 case 3:
			 return data.get(row).getAddress();
			 
		 default:
			 return null;
		
		}
	}

}
