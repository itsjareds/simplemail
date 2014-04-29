package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Button class for Add button in Contact table
 * extends AbstractButton
 * @author klinge2
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ButtonContactAdd extends AbstractButton{
	private MainFrameMediator med = null;
	
	/**
	 * set up button
	 * @param med
	 */
	public ButtonContactAdd(MainFrameMediator med){
		super("Add");
		this.med = med;
	}

	public void triggerEvent(){
		med.addContact();
	}
	

}
