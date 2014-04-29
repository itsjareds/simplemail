package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Button class for Edit button in Draft table
 * extends AbstractButton
 * @author klinge2
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ButtonDraftEdit extends AbstractButton{
	private MainFrameMediator med = null;
			
	/**
	 * set up button
	 * @param med
	 */
	public ButtonDraftEdit(MainFrameMediator med){
		super("Edit");
		this.med = med;
	}
			

	public void triggerEvent(){
		med.editDraft();
	}
}
			