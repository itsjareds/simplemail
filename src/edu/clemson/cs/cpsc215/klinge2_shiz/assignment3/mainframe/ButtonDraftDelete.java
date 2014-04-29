package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Button class for Delete button in Draft table
 * extends AbstractButton
 * @author klinge2
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ButtonDraftDelete extends AbstractButton{
	private MainFrameMediator med = null;
		
	/**
	 * set up button
	 * @param med
	 */
	public ButtonDraftDelete(MainFrameMediator med){
		super("Delete");
		this.med = med;
	}
		

	public void triggerEvent(){
		med.deleteDraft();
	}
}
		