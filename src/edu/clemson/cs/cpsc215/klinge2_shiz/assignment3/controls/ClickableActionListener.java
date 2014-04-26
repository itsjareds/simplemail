package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickableActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Clickable c = (Clickable)e.getSource();
		c.triggerEvent();
	}

}