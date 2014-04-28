package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonDraftEdit extends AbstractButton{
	private MainFrameMediator med = null;
			
	public ButtonDraftEdit(MainFrameMediator med){
		super("Edit");
		this.med = med;
	}
			
	public void triggerEvent(){
		med.editDraft();
	}
}
			