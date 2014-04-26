package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JCheckBox;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.Checkable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.CheckableItemListener;

public class CheckBoxAuthSmtp extends JCheckBox implements Checkable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -4053024966168122309L;
	private ConfigMediatorInterface med = null;
	
	public CheckBoxAuthSmtp(CheckableItemListener cil, ConfigMediatorInterface cmi) {
		super("Authenticate for SMTP");
		this.med = cmi;
		this.addItemListener(cil);
		this.med.registerAuthSmtpCheckbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authSmtp(selected);
	}

}
