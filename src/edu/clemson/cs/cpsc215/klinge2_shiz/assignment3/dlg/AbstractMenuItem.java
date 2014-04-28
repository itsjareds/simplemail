package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import javax.swing.JMenuItem;

/**
 * Abstract class from which all MenuItems derive. Forces all MenuItems to 
 * implement the Clickable interface.
 * 
 * @author klinge2
 * @since 04-28-2014
 */
@SuppressWarnings("serial")
public abstract class AbstractMenuItem extends JMenuItem implements Clickable {

    public AbstractMenuItem(String label) {
        super(label);
        this.addActionListener(new ClickableActionListener());
    }

}
