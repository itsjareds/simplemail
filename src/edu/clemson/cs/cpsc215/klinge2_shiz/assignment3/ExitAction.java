package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitAction implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		DataStore.getInstance().storeConfig();
		DataStore.getInstance().storeContacts();
		System.exit(0);
	}

}
