package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

/**
 * Interface which all checkable elements implement for unity.
 * 
 * @author klinge2
 * @since 04-28-2014
 */

public interface Checkable {
	/**
	 * @param selected enum representing whether the checkbox is checked
	 */
	public void triggerEvent(int selected);
}