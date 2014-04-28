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

@SuppressWarnings("serial")
public class ContactEditingDlg extends AbstractDlg{
	private Contact contact = new Contact("","","","");
	private ContactTable table = null;
	private int index = -1;

	public ContactEditingDlg(Frame owner, ContactTable table){
		super(owner, "Contact details");
		this.table = table;
		if (table != null) {
			if (index != -1)
				this.contact = DataStore.getInstance().getContacts().get(index);
		}
		addComponents();
	}
	
	@Override
	protected void addComponents() {
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
        
        //Textfields
        
        txt = new JTextField();
        if(contact.getName() != null){
        	String contents = contact.getName();
        	txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerNameField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        if(contact.getEmail() != null){
        	String contents = contact.getEmail();
        	txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerEmailField(txt);
        innerPanel.add(txt, c);
        	
        txt = new JTextField();
        if(contact.getPhone() != null){
        	String contents = contact.getPhone();
        	txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerPhoneField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        if(contact.getAddress() != null){
        	String contents = contact.getAddress();
        	txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerAddressField(txt);
        innerPanel.add(txt, c);
        
        // Buttons
        
        button = new ButtonSave(med);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHWEST;
        med.registerSaveButton((ButtonSave)button);
        innerPanel.add(button, c);
        
        button = new ButtonCancel(med);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        med.registerCancelButton((ButtonCancel)button);
        innerPanel.add(button, c);
        
        containerPanel.add(innerPanel, BorderLayout.CENTER);
        this.getContentPane().add(containerPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationByPlatform(true);
	}

	public Contact getContact() {
		return contact;
	}

	public ContactTable getTable() {
		return table;
	}

	public int getIndex() {
		return index;
	}
	
}
