package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonSave extends AbstractButton {
	private ConfigMediator med = null;

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
