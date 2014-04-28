package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import javax.swing.JCheckBox;

/**
 * Abstract class from which all checkboxes derive. Forces all checkboxes to
 * implement the Checkable interface.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

@SuppressWarnings("serial")
public abstract class AbstractCheckBox extends JCheckBox implements Checkable {

    public AbstractCheckBox(String label) {
        super(label);
        this.addItemListener(new CheckableItemListener());
    }
    
}
