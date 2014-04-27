package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public abstract class AbstractCheckBox extends JCheckBox implements Checkable {

    public AbstractCheckBox(String label) {
        super(label);
        this.addItemListener(new CheckableItemListener());
    }
    
}
