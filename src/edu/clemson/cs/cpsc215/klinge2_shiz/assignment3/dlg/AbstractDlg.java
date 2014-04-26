package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.Frame;

import javax.swing.JDialog;

public abstract class AbstractDlg extends JDialog {
    /**
     * 
     */
    private static final long serialVersionUID = 3042741743527126565L;

    public AbstractDlg(Frame owner) {
        super(owner, "Untitled Dialog", true);
        addComponents();
    }
    
    public AbstractDlg(Frame owner, String title) {
        super(owner, title, true);
        addComponents();
    }
    
    protected abstract void addComponents();
}
