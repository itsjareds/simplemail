package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A custom listener for all components which implement Clickable.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public class ClickableActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Clickable c = (Clickable)e.getSource();
		c.triggerEvent();
	}

}