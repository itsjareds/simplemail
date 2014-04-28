package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractCheckBox;

/**
 * Authorize for POP checkbox for ConfigurationDlg
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public class CheckBoxAuthPop3 extends AbstractCheckBox {
	private ConfigMediator med;
	
	/**
	 * @param med Mediator to register as a colleague with
	 */
	public CheckBoxAuthPop3(ConfigMediator med) {
		super("Authenticate for POP");
		this.med = med;
		this.med.registerAuthPop3Checkbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authPop3(selected);
	}

}
