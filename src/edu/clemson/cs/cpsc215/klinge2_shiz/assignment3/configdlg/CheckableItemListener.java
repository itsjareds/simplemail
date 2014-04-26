package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.configdlg;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckableItemListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkable c = (Checkable)e.getSource();
		c.triggerEvent(e.getStateChange());
	}

}