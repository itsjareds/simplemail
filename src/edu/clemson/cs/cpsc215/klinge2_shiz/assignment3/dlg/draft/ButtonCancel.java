package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.draft;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractButton;

@SuppressWarnings("serial")
public class ButtonCancel extends AbstractButton {
    private DraftMediator med = null;

    public ButtonCancel(DraftMediator med) {
        super("Cancel");
        this.med = med;
        this.med.registerCancelButton(this);
    }
    
    @Override
    public void triggerEvent() {
        med.cancel();
    }

}
