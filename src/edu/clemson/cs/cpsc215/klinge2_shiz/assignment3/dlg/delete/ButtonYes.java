package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Button class for Yes button in Delete dialog
 * extends AbstractButton
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ButtonYes extends AbstractButton {
	private DeleteMediator med = null;
	
	/**
	 * @param med
	 */
	public ButtonYes(DeleteMediator med){
		super("Yes");
		this.med = med;
	}
	
	public void triggerEvent(){
		med.yes();
	}


}
