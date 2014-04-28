package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemNewContact extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemNewContact(MainFrameMediator med) {
        super("Contact");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.add();
    }

}
