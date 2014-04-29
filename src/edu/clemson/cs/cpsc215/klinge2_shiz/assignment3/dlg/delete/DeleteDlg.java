package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe.ContactTable;

/**
 * Delete dialog. Confirmation dialog to delete
 * extends AbstractDlg
 * @author shiz
 * @author klinge2
 * @since 4-27-14
 *
 */
@SuppressWarnings("serial")
public class DeleteDlg extends AbstractDlg{
	private Contact contact = new Contact("","","","");
	protected ContactTable table = null;
	protected int index = -1;

	/**
	 * @param owner
	 * @param table
	 */
	public DeleteDlg(Frame owner, ContactTable table) {
		super(owner, "Delete");
		this.table = table;
		if (table != null) {
			index = table.getSelectedRow();
			if (index != -1)
				contact = DataStore.getInstance().getContacts().get(index);
		}
		addComponents();
	}
	
	@Override
	protected void addComponents() {
		//declare panels and layout manager
		JPanel containerPanel = new JPanel();
        containerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        containerPanel.setLayout(new BorderLayout());
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints c;
        
		DeleteMediator med = new DeleteMediator(this);
		
		JButton button;
		JLabel label;
		
		int row = 0, col = 0;
		
		//label
		label = new JLabel("Are you sure you want to delete the following" +
				" contact?");
		containerPanel.add(label, BorderLayout.BEFORE_FIRST_LINE);
		
		
		label = new JLabel("Name:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Email:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Phone:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Address:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        col++;
        row = 0;
        
        //Contact info
        label = new JLabel();
        label.setText(contact.getName());	
        c = new GridBagConstraints();
        c.gridx = col+2;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel();
        label.setText(contact.getEmail());	
        c = new GridBagConstraints();
        c.gridx = col+2;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel();
        label.setText(contact.getPhone());	
        c = new GridBagConstraints();
        c.gridx = col+2;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel();
        label.setText(contact.getAddress());	
        c = new GridBagConstraints();
        c.gridx = col+2;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        //button
        button = new ButtonYes(med);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHWEST;
        innerPanel.add(button, c);
        
        button = new ButtonNo(med);
        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        innerPanel.add(button, c);
        
        //put everything to display
        containerPanel.add(innerPanel, BorderLayout.CENTER);
        this.getContentPane().add(containerPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationByPlatform(true);
        
	}
}
