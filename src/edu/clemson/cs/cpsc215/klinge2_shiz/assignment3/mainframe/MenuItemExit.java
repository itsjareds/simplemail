package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

/**
 * Menu item class for Exit. 
 * extends AbstractMenuItem
 * @author klinge2
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class MenuItemExit extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    /**
     * set up menu item
     * @param med
     */
    public MenuItemExit(MainFrameMediator med) {
        super("Exit");
        this.med = med;
    }
    
 
    @Override
    public void triggerEvent() {
        med.exit();
    }

}
