package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonDraftDelete extends AbstractButton{
	private MainFrameMediator med = null;
		
	public ButtonDraftDelete(MainFrameMediator med){
		super("Delete");
		this.med = med;
	}
		
	public void triggerEvent(){
		med.deleteDraft();
	}
}
		