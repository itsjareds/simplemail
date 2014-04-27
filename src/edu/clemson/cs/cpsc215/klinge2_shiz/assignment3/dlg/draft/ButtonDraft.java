package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.draft;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonDraft extends AbstractButton {
    private DraftMediator med = null;

    public ButtonDraft(DraftMediator med) {
        super("Save as draft");
        this.med = med;
        this.med.registerDraftButton(this);
    }
    
    @Override
    public void triggerEvent() {
        med.draft();
    }

}
