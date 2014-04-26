package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractCheckBox;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.Checkable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.CheckableItemListener;

public class CheckBoxAuthSmtp extends AbstractCheckBox implements Checkable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -4053024966168122309L;
	private ConfigMediatorInterface med = null;
	
	public CheckBoxAuthSmtp(CheckableItemListener listener,
	        ConfigMediatorInterface med) {
		super("Authenticate for SMTP", listener);
		this.med = med;
		this.med.registerAuthSmtpCheckbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authSmtp(selected);
	}

}
