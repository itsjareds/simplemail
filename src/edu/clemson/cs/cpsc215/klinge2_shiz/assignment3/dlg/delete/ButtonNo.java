package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Button class for No button in Delete dialog
 * extends AbstractButton
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ButtonNo extends AbstractButton {
	private DeleteMediator med = null;
	
	/**
	 * @param med
	 */
	public ButtonNo(DeleteMediator med){
		super("No");
		this.med = med;
	}
	
	public void triggerEvent(){
		med.no();
	}

}
