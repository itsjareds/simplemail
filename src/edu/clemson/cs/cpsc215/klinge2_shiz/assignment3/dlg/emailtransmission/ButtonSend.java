package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtransmission;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonSend extends AbstractButton {
    private EmailTransmissionMediator med = null;

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
