package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JButton;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.Clickable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.ClickableActionListener;

public class ButtonSave extends JButton implements Clickable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = 8237427795279327399L;
	private ConfigMediatorInterface med = null;
	
	public ButtonSave(ClickableActionListener cal, ConfigMediatorInterface cmi) {
		super("Save");
		this.med = cmi;
		this.addActionListener(cal);
		this.med.registerSaveButton(this);
	}

	@Override
	public void triggerEvent() {
		med.save();
	}

	
}
