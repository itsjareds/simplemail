package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing.EditMediator;

@SuppressWarnings("serial")
public class ButtonSave extends AbstractButton {
	private EditMediator med = null;

	public ButtonSave(EditMediator med) {
		super("Save");
		this.med = med;
		this.med.registerSaveButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.save();
	}

}
