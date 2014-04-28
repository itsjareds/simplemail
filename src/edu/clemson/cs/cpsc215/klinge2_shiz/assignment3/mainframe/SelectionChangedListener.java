package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionChangedListener implements ListSelectionListener {
	private JButton button = null;
	
	public SelectionChangedListener(JButton button) {
		this.button = button;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectionModel = (ListSelectionModel)e.getSource();
		button.setEnabled(!selectionModel.isSelectionEmpty());
	}
}
