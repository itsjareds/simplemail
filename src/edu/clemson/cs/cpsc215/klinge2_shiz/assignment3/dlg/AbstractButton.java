package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import javax.swing.JButton;

/**
 * Abstract class from which all buttons derive. Forces all buttons to 
 * implement the Clickable interface.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public abstract class AbstractButton extends JButton implements Clickable {

    public AbstractButton(String label) {
        super(label);
        this.addActionListener(new ClickableActionListener());
    }

}
