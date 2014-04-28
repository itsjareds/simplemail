package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * A custom listener for all AbstractCheckBoxes.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class CheckableItemListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkable c = (Checkable)e.getSource();
		c.triggerEvent(e.getStateChange());
	}

}