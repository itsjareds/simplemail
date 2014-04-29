package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

/**
 * Menu item class for Compose. 
 * extends AbstractMenuItem
 * @author klinge2
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class MenuItemCompose extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    /**
     * set up menu item 
     * @param med
     */
    public MenuItemCompose(MainFrameMediator med) {
        super("Message");
        this.med = med;
    }
    
  
    @Override
    public void triggerEvent() {
        med.compose();
    }

}
