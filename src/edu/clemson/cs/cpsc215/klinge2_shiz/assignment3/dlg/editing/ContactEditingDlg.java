package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe.ContactTable;

/**
 * Contact editing dialog. Interface for add and edit
 * extends AbstractDlg
 * @author shiz
 * @author klinge2
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ContactEditingDlg extends AbstractDlg {
	private Contact contact = new Contact("","","","");
	protected ContactTable table = null;
	protected int index = -1;
	protected boolean modify = false;

	/**
	 * @param owner
	 * @param table
	 * @param modify
	 */
	public ContactEditingDlg(Frame owner, ContactTable table, boolean modify) {
		super(owner, "Contact details");
		this.modify = modify;
		this.table = table;
		if (table != null && modify) {
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
        
        EditMediator med = new EditMediator(this);
        
        JLabel label;
        JTextField txt;
        JButton button;
        
        int row = 0, col = 0;
        
        // Labels
        
        label = new JLabel("Name");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Email");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Phone");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Address");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        col++;
        row = 0;
        
        // Textfields
        
        txt = new JTextField();
        txt.setText(contact.getName());
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerNameField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        txt.setText(contact.getEmail());
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerEmailField(txt);
        innerPanel.add(txt, c);
        	
        txt = new JTextField();
        txt.setText(contact.getPhone());
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerPhoneField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        txt.setText(contact.getAddress());
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerAddressField(txt);
        innerPanel.add(txt, c);
        
        // Buttons
        
        button = new ButtonCancel(med);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHWEST;
        med.registerCancelButton((ButtonCancel)button);
        innerPanel.add(button, c);
        
        button = new ButtonSave(med);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        med.registerSaveButton((ButtonSave)button);
        innerPanel.add(button, c);
        
        containerPanel.add(innerPanel, BorderLayout.CENTER);
        this.getContentPane().add(containerPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationByPlatform(true);
	}
	
}
