package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonYes extends AbstractButton {
	private DeleteMediator med = null;
	
	public ButtonYes(DeleteMediator med){
		super("Yes");
		this.med = med;
		this.med.registerYesButton(this);
	}
	
	public void triggerEvent(){
		med.yes();
	}


}
