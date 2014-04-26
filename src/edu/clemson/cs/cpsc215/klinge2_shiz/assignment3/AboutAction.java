package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutAction implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		SystemInformationDlg dialog = new SystemInformationDlg();
		dialog.setModal(true);
		dialog.setVisible(true);
	}
}
