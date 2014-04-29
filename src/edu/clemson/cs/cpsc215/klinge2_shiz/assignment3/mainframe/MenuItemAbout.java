package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

/**
 * Menu item class for About. 
 * extends AbstractMenuItem
 * @author klinge2
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class MenuItemAbout extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    /**
     * set up menu item 
     * @param med
     */
    public MenuItemAbout(MainFrameMediator med) {
        super("About");
        this.med = med;
    }

    @Override
    public void triggerEvent() {
        med.about();
    }

}
