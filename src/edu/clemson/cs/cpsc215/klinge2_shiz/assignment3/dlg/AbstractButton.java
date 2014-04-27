package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class AbstractButton extends JButton implements Clickable {

    public AbstractButton(String label) {
        super(label);
        this.addActionListener(new ClickableActionListener());
    }

}
