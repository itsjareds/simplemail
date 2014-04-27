package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractMenuItem;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class MenuItemConfig extends AbstractMenuItem {
    MainFrameMediator med = null;
    
    public MenuItemConfig(ClickableActionListener listener,
            MainFrameMediator med) {
        super("Configure", listener);
        this.med = med;
    }
    
    @Override
    public void triggerEvent() {
        med.config();
    }

}
