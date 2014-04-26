package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JButton;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.Clickable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.ClickableActionListener;

public class ButtonCancel extends JButton implements Clickable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -2535112987711806565L;
	private ConfigMediatorInterface med = null;

	public ButtonCancel(ClickableActionListener cal, ConfigMediatorInterface cmi) {
		super("Cancel");
		this.med = cmi;
		this.addActionListener(cal);
		this.med.registerCancelButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.cancel();
	}

}
