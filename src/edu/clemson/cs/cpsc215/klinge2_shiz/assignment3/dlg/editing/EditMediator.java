package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import java.util.ArrayList;

import javax.swing.JTextField;


import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;

public class EditMediator implements EditMediatorInterface {
	ButtonSave buttonSave = null;
	ButtonCancel buttonCancel = null;
	ContactEditingDlg contactEditingDlg = null;
	JTextField nameField, emailField, phoneField, addressField;
	
	public EditMediator(ContactEditingDlg contactEditingDlg) {
		this.contactEditingDlg = contactEditingDlg;
	}
	
	private Contact generateContact() {
		Contact newContact = new Contact("","","","");
		if(nameField != null)
			newContact.setName(nameField.getText());

		if(emailField != null)
			newContact.setEmail(emailField.getText());
		
		if(phoneField != null)
			newContact.setPhone(phoneField.getText());
		
		if(addressField != null)
			newContact.setAddress(addressField.getText());
		
		return newContact;
	}
	
	@Override
	public void save() {
		ArrayList<Contact> contacts = DataStore.getInstance().getContacts();
		Contact newContact = generateContact();
		
		int row = contactEditingDlg.index;
		if (row == -1)
			contacts.add(newContact);
		else
			contacts.set(row, newContact);
		
		contactEditingDlg.setVisible(false);
	}

	@Override
	public void cancel() {
		contactEditingDlg.setVisible(false);
		contactEditingDlg.dispose();
	}

	@Override
	public void registerSaveButton(ButtonSave save) {
		this.buttonSave = save;
	}

	@Override
	public void registerCancelButton(ButtonCancel cancel) {
		this.buttonCancel = cancel;
	}

	@Override
	public void registerNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	@Override
	public void registerEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	@Override
	public void registerPhoneField(JTextField phoneField) {
		this.phoneField = phoneField;
	}

	@Override
	public void registerAddressField(JTextField addressField) {
		this.addressField = addressField;
	}
	

}
