package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

public interface MainFrameMediatorInterface {
    public void exit();
    public void config();
    public void about();
    public void tableClicks(int row);
    
    public void registerFrame(Frame frame);
    public void registerTable(ContactTable table);
}
