package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import javax.swing.JTextField;

public interface EditMediatorInterface {

	    public void save();
	    public void cancel();
	    
	    public void registerSaveButton(ButtonSave save);
	    public void registerCancelButton(ButtonCancel cancel);
	    public void registerNameField(JTextField nameField);
	    public void registerEmailField(JTextField emailField);
	    public void registerPhoneField(JTextField phoneField);
	    public void registerAddressField(JTextField addressField);
	}
