package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing.EditMediator;

/**
 * Button class for Cancel button in Contact editing dialog
 * extends AbstractButton
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ButtonCancel extends AbstractButton {
	private EditMediator med = null;

	/**
	 * @param med
	 */
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
