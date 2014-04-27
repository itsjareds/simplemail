package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.draft;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonSend extends AbstractButton {
    private DraftMediator med = null;

    public ButtonSend(DraftMediator med) {
        super("Send");
        this.med = med;
        this.med.registerSendButton(this);
    }
    
    @Override
    public void triggerEvent() {
        med.send();
    }

}
