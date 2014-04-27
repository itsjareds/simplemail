package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public abstract class AbstractMenuItem extends JMenuItem implements Clickable {

    public AbstractMenuItem(String label, ClickableActionListener listener) {
        super(label);
        this.addActionListener(listener);
    }

}
