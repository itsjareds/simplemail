package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

/**
 * An interface for elements which perform different functions based on the
 * number of times they are clicked in rapid succession.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public interface MultiClickable {
    /**
     * @param num Number of times the mouse clicked the component
     */
    public void triggerEvent(int num);
}
