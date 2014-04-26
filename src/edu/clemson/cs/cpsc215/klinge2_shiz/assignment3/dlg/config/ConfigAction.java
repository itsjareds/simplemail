package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ConfigAction implements ActionListener {
	private JFrame owner = null;
	
	public ConfigAction(JFrame owner) {
		this.owner = owner;
	}
	
	public void actionPerformed(ActionEvent e) {
		ConfigurationDlg dialog = new ConfigurationDlg(owner);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
}
