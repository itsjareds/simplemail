package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonContactAdd extends AbstractButton{
	private MainFrameMediator med = null;
	
	public ButtonContactAdd(MainFrameMediator med){
		super("Add");
		this.med = med;
	}
	
	public void triggerEvent(){
		med.addContact();
	}
	

}
