package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A custom multi-click listener for all MultiClickable interface users. 
 * Passes the number of clicks to triggerEvent().
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class ContactTableMultiClickListener extends MouseAdapter {

    /* (non-Javadoc)
     * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent e) {
    	if (e.getSource() instanceof MultiClickable) {
    		MultiClickable table = (MultiClickable)e.getSource();
	        if (e.getClickCount() == 2)
	            table.triggerEvent(e.getClickCount());
    	}
    }
    
}
