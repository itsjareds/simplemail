package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class MenuItemExit extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemExit(ClickableActionListener listener,
            MainFrameMediator med) {
        super("Exit", listener);
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.exit();
    }

}
