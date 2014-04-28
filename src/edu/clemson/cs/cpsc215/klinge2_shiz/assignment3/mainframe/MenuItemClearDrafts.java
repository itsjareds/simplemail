package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemClearDrafts extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemClearDrafts(MainFrameMediator med) {
        super("Drafts");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.clearDrafts();
    }

}
