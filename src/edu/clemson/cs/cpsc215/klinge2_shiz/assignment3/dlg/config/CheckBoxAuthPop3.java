package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractCheckBox;

@SuppressWarnings("serial")
public class CheckBoxAuthPop3 extends AbstractCheckBox {
	private ConfigMediator med;
	
	public CheckBoxAuthPop3(ConfigMediator med) {
		super("Authenticate for POP3");
		this.med = med;
		this.med.registerAuthPop3Checkbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authPop3(selected);
	}

}
