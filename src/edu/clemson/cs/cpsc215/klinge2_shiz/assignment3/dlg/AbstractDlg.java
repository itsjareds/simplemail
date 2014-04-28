package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.Frame;

import javax.swing.JDialog;

/**
 * Abstract class from which all Dialogs derive. Forces all dialogs to 
 * separate the constructor and the component adding methods, and provides a
 * default window title if none is provided.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public abstract class AbstractDlg extends JDialog {
    /**
     * 
     */
    private static final long serialVersionUID = 3042741743527126565L;

    public AbstractDlg(Frame owner) {
        super(owner, "Untitled Dialog", true);
    }
    
    public AbstractDlg(Frame owner, String title) {
        super(owner, title, true);
    }
    
    protected abstract void addComponents();
}
