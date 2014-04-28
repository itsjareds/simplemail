package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

public interface MainFrameMediatorInterface {
	public void compose();
    public void exit();
    public void config();
    public void about();
    public void contactTableClicked();
    public void draftTableClicked();
    
    public void registerFrame(Frame frame);
    public void registerContactTable(ContactTable table);
    public void registerDraftTable(DraftTable table);
}
