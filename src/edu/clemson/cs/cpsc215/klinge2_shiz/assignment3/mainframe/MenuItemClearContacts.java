package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

/**
 * Menu item class for Clear Contact. 
 * extends AbstractMenuItem
 * @author klinge2
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class MenuItemClearContacts extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    /**
     * set up menu item 
     * @param med
     */
    public MenuItemClearContacts(MainFrameMediator med) {
        super("Contacts");
        this.med = med;
    }

    @Override
    public void triggerEvent() {
        med.clearContacts();
    }

}
