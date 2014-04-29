package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Selection change listener class. Disable/enable button base on row selection
 * implements ListSelectionListener
 * @author shiz
 * @since 4-27-14
 *
 */
public class SelectionChangedListener implements ListSelectionListener {
	private JButton button = null;
	
	/**
	 * set up button
	 * @param button to be set up
	 */
	public SelectionChangedListener(JButton button) {
		this.button = button;
	}
	

	public void valueChanged(ListSelectionEvent e) {
		//enable/disable button
		ListSelectionModel selectionModel = (ListSelectionModel)e.getSource();
		button.setEnabled(!selectionModel.isSelectionEmpty());
	}
}
