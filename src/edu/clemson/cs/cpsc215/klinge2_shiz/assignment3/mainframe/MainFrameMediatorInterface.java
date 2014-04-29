package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

/**
 * Main frame mediator interface.
 * 
 * @author shiz
 * @author klinge2
 * @since 4-28-14
 */
public interface MainFrameMediatorInterface {
	// Menu actions
	
	/**
	 * action for compose menu item
	 */
	public void compose();
	
	/**
	 * action for exit menu item
	 */
    public void exit();
    
    /**
	 * action for clear contacts menu item
	 */
    public void clearContacts();
    
    /**
	 * action for clear drafts menu item
	 */
    public void clearDrafts();
    
    /**
	 * action for config menu item
	 */
    public void config();
    
    /**
	 * action for about menu item
	 */
    public void about();
    
    
    // Button actions
    
    
    /**
     * action for add button in contact table
     */
    public void addContact();
    
    /**
     * action for edit button in contact table
     */
    public void editContact();
    
    /**
     * action for delete button in contact table
     */
    public void deleteContact();
    
    /**
     * action for edit button in draft table
     */
    public void editDraft();
    
    /**
     * action for delete button in draft table
     */
    public void deleteDraft();
    
    /**
     * action for double click in contact table
     */
    public void contactTableClicked(int num);
    
    /**
     * action for double click in draft table
     */
    public void draftTableClicked(int num);
    
    //register
    
    /**
     * frame register
     * @param frame 
     */
    public void registerFrame(Frame frame);
    
    /**
     * contact table register
     * @param table
     */
    public void registerContactTable(ContactTable table);
    
    /**
     * draft table register
     * @param table
     */
    public void registerDraftTable(DraftTable table);
    
}
