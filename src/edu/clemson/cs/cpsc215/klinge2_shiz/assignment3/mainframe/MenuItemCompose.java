package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemCompose extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemCompose(MainFrameMediator med) {
        super("Message");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.compose();
    }

}
