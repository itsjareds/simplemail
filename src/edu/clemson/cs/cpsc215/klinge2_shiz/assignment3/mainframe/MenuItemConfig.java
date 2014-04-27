package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemConfig extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemConfig(MainFrameMediator med) {
        super("Configure");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.config();
    }

}
