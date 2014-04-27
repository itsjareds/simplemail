package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemExit extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemExit(MainFrameMediator med) {
        super("Exit");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.exit();
    }

}
