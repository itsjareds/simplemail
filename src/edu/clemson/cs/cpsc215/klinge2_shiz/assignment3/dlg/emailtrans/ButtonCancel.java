package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Cancel button for EmailTransmissionDlg
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public class ButtonCancel extends AbstractButton {
    private EmailTransmissionMediator med = null;

    /**
     * @param med Mediator to register as a colleague with
     */
    public ButtonCancel(EmailTransmissionMediator med) {
        super("Cancel");
        this.med = med;
        this.med.registerCancelButton(this);
    }
    
    @Override
    public void triggerEvent() {
        med.cancel();
    }

}
