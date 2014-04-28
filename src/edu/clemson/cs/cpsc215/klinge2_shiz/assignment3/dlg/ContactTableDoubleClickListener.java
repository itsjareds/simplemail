package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe.ContactTable;

public class ContactTableDoubleClickListener extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
    	if (e.getSource() instanceof DoubleClickable) {
    		DoubleClickable table = (DoubleClickable)e.getSource();
	        if (e.getClickCount() == 2)
	            table.triggerEvent();
    	}
    }
    
}
