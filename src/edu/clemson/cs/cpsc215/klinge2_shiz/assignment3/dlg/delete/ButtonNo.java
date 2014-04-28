package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonNo extends AbstractButton {
	private DeleteMediator med = null;
	
	public ButtonNo(DeleteMediator med){
		super("No");
		this.med = med;
		this.med.registerNoButton(this);
	}
	
	public void triggerEvent(){
		med.no();
	}

}
