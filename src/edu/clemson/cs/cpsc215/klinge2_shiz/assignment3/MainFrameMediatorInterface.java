package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.Frame;

public interface MainFrameMediatorInterface {
    public void exit();
    public void config();
    public void about();
    
    public void registerFrame(Frame frame);
}
