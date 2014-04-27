package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class ButtonCancel extends AbstractButton {
	private ConfigMediatorInterface med = null;

	public ButtonCancel(ClickableActionListener listener,
	        ConfigMediatorInterface med) {
		super("Cancel", listener);
		this.med = med;
		this.med.registerCancelButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.cancel();
	}

}
