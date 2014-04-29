package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import javax.swing.JTextField;

/**
 * Edit Mediator Interface
 * @author shiz
 * @since 2-27-14
 *
 */
public interface EditMediatorInterface {

		//buttons
	    /**
	     * action for save button
	     */
	    public void save();
	    
	    /**
	     * action for cancel button
	     */
	    public void cancel();
	    
	    //registers
	    
	    /**
	     * @param save
	     */
	    public void registerSaveButton(ButtonSave save);
	    /**
	     * @param cancel
	     */
	    public void registerCancelButton(ButtonCancel cancel);
	    /**
	     * @param nameField
	     */
	    public void registerNameField(JTextField nameField);
	    /**
	     * @param emailField
	     */
	    public void registerEmailField(JTextField emailField);
	    /**
	     * @param phoneField
	     */
	    public void registerPhoneField(JTextField phoneField);
	    /**
	     * @param addressField
	     */
	    public void registerAddressField(JTextField addressField);
	}
