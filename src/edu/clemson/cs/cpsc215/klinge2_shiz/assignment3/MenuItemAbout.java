package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class MenuItemAbout extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemAbout(ClickableActionListener listener,
            MainFrameMediator med) {
        super("About", listener);
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.about();
    }

}
