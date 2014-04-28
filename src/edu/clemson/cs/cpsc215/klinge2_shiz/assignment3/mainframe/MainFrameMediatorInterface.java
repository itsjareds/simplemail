package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

public interface MainFrameMediatorInterface {
	// Menu actions
	
	public void compose();
    public void exit();
    
    public void clearContacts();
    public void clearDrafts();
    public void config();
    
    public void about();
    
    // Button actions
    
    public void addContact();
    public void editContact();
    public void deleteContact();
    
    public void editDraft();
    public void deleteDraft();
    
    public void contactTableClicked(int num);
    public void draftTableClicked(int num);
    
    public void registerFrame(Frame frame);
    public void registerContactTable(ContactTable table);
    public void registerDraftTable(DraftTable table);
}
