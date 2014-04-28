package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonAdd extends AbstractButton{
	private MainFrameMediator med = null;
	
	public ButtonAdd(MainFrameMediator med){
		super("Add");
		this.med = med;
	}
	
	public void triggerEvent(){
		med.add();
	}
	

}
