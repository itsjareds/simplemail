package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class ButtonSave extends AbstractButton {
	private ConfigMediatorInterface med = null;

	public ButtonSave(ClickableActionListener listener,
	        ConfigMediatorInterface med) {
		super("Save", listener);
		this.med = med;
		this.med.registerSaveButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.save();
	}

}
