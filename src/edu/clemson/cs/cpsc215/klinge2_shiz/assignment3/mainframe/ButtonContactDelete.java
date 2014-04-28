package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonContactDelete extends AbstractButton{
	private MainFrameMediator med = null;
		
	public ButtonContactDelete(MainFrameMediator med){
		super("Delete");
		this.med = med;
	}
		
	public void triggerEvent(){
		med.deleteContact();
	}
}
		