package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractCheckBox;

public class CheckBoxAuthSmtp extends AbstractCheckBox {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -4053024966168122309L;
	private ConfigMediator med = null;
	
	public CheckBoxAuthSmtp(ConfigMediator med) {
		super("Authenticate for SMTP");
		this.med = med;
		this.med.registerAuthSmtpCheckbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authSmtp(selected);
	}

}
