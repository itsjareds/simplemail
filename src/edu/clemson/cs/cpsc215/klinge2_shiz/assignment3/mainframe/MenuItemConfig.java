package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

/**
 * Menu item class for Config. 
 * extends AbstractMenuItem
 * @author klinge2
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class MenuItemConfig extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    /**
     * set up menu item
     * @param med
     */
    public MenuItemConfig(MainFrameMediator med) {
        super("Configuration");
        this.med = med;
    }
    

    @Override
    public void triggerEvent() {
        med.config();
    }

}
