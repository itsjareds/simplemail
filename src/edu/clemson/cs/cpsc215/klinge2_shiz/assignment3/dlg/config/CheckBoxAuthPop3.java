package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JCheckBox;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.Checkable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.CheckableItemListener;

public class CheckBoxAuthPop3 extends JCheckBox implements Checkable {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = 1455547957956596118L;
	private ConfigMediatorInterface med = null;
	
	public CheckBoxAuthPop3(CheckableItemListener cil, ConfigMediatorInterface cmi) {
		super("Authenticate for POP3");
		this.med = cmi;
		this.addItemListener(cil);
		this.med.registerAuthPop3Checkbox(this);
	}

	@Override
	public void triggerEvent(int selected) {
		med.authPop3(selected);
	}

}
