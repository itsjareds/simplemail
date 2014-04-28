package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemClearContacts extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemClearContacts(MainFrameMediator med) {
        super("Contacts");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.clearContacts();
    }

}
