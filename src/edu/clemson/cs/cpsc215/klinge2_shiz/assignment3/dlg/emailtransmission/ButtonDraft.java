package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtransmission;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonDraft extends AbstractButton {
    private EmailTransmissionMediator med = null;

    public ButtonDraft(EmailTransmissionMediator med) {
        super("Save as draft");
        this.med = med;
        this.med.registerDraftButton(this);
    }
    
    @Override
    public void triggerEvent() {
        med.draft();
    }

}
