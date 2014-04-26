package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractCheckBox;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.CheckableItemListener;

@SuppressWarnings("serial")
public class CheckBoxAuthPop3 extends AbstractCheckBox {
	private ConfigMediatorInterface med;
	
	public CheckBoxAuthPop3(CheckableItemListener listener,
	        ConfigMediatorInterface med) {
		super("Authenticate for POP3", listener);
		this.med = med;
		this.med.registerAuthPop3Checkbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authPop3(selected);
	}

}
