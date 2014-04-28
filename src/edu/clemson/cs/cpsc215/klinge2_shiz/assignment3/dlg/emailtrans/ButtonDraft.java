package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Draft button for EmailTransmissionDlg
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public class ButtonDraft extends AbstractButton {
    private EmailTransmissionMediator med = null;

    /**
     * @param med Mediator to register as a colleague with
     */
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
