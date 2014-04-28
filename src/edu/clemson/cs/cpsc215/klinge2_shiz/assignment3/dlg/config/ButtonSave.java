package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Save button for ConfigurationDlg
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public class ButtonSave extends AbstractButton {
	private ConfigMediator med = null;

	/**
	 * @param med Mediator to register as a colleague with
	 */
	public ButtonSave(ConfigMediator med) {
		super("Save");
		this.med = med;
		this.med.registerSaveButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.save();
	}

}
