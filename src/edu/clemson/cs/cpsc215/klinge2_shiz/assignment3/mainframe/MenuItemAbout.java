package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;

@SuppressWarnings("serial")
public class MenuItemAbout extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemAbout(MainFrameMediator med) {
        super("About");
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.about();
    }

}
