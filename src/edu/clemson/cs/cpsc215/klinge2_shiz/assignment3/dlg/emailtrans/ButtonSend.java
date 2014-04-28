package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

/**
 * Send button for EmailTransmissionDlg
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public class ButtonSend extends AbstractButton {
    private EmailTransmissionMediator med = null;

    /**
     * @param med Mediator to register as a colleague with
     */
    public ButtonSend(EmailTransmissionMediator med) {
        super("Send");
        this.med = med;
        this.med.registerSendButton(this);
    }
    
    @Override
    public void triggerEvent() {
        med.send();
    }

}
