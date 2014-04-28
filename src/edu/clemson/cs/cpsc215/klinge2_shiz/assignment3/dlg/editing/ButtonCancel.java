package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing.EditMediator;

@SuppressWarnings("serial")
public class ButtonCancel extends AbstractButton {
	private EditMediator med = null;

	public ButtonCancel(EditMediator med) {
		super("Cancel");
		this.med = med;
		this.med.registerCancelButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.cancel();
	}

}
