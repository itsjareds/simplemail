package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContactTableMultiClickListener extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
    	if (e.getSource() instanceof MultiClickable) {
    		MultiClickable table = (MultiClickable)e.getSource();
	        if (e.getClickCount() == 2)
	            table.triggerEvent(e.getClickCount());
    	}
    }
    
}
