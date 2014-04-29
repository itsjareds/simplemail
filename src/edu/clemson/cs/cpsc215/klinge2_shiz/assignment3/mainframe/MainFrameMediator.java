package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

import javax.swing.JOptionPane;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Draft;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Email;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config.ConfigurationDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete.DeleteDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.editing.ContactEditingDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans.EmailTransmissionDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.sysinf.SystemInformationDlg;

/**
 * Mediator pattern for main frame.
 * implements MainFrameMediatorInterface
 * @author shiz
 * @author klinge2
 * @since 4-28-14
 *
 */
public class MainFrameMediator implements MainFrameMediatorInterface {
    private Frame frame = null;
    private ContactTable contactTable = null;
    private DraftTable draftTable = null;

    @Override
    public void compose() {
    	//bring up email transmission dialog
    	if (frame != null && draftTable != null) {
    		AbstractDlg dialog = new EmailTransmissionDlg(frame, draftTable);
    		dialog.setModal(true);
    		dialog.setVisible(true);
    	}
    }
    

    @Override
    public void exit() {
        System.exit(0);
    }
    

    @Override
    public void clearContacts() {
    	//confirm then clear contact table and contacts in Datastore, update table
    	if (contactTable != null) {
    		int result = JOptionPane.showConfirmDialog(null,
    				"Are you sure you want to delete ALL drafts?",
    				"Confirm delete",
    				JOptionPane.YES_NO_OPTION);
    		
    		if (result == JOptionPane.YES_OPTION) {
    			DataStore.getInstance().getContacts().clear();
    			((ContactTableModel)contactTable.getModel()).fireTableDataChanged();
    		}
    	}
    }
    

    @Override
    public void clearDrafts() {
    	//clear draft, update table
    	if (draftTable != null) {
    		DataStore.getInstance().getDrafts().clear();
    		((DraftTableModel)draftTable.getModel()).fireTableDataChanged();
    	}
    }
    

    @Override
    public void config() {
    	//bring up configuration dialog
        if (frame != null) {
            AbstractDlg dialog = new ConfigurationDlg(frame);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
    }


    @Override
    public void about() {
    	//bring up system information dialog
        if (frame != null) {
            AbstractDlg dialog = new SystemInformationDlg(frame);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
    }
    
  
    public void addContact() {
    	//bring up contact editing dialog for adding, update table when done
    	if (frame != null && contactTable != null) {
    		AbstractDlg dialog = new ContactEditingDlg(frame, contactTable, false);
    		dialog.setModal(true);
    		dialog.setVisible(true);
        	((ContactTableModel)contactTable.getModel()).fireTableRowsInserted(
        			contactTable.getModel().getRowCount() - 1, 
        			contactTable.getModel().getRowCount() - 1);
    	}
    }

  
    @Override
    public void editContact() {
    	//bring up contact editing dialog for editing, update table when done
    	if (frame != null && contactTable != null) {
    		AbstractDlg dialog = new ContactEditingDlg(frame, contactTable, true);
    		dialog.setModal(true);
    		dialog.setVisible(true);
    		((ContactTableModel)contactTable.getModel()).fireTableDataChanged();
    	}
    }


    @Override
    public void deleteContact() {
    	//delete selected row. bring up delete dialog to confirm, update table when done
    	if (frame != null && contactTable != null) {
    		int row = contactTable.getSelectedRow();
    		
    		Contact c = ((ContactTableModel)contactTable.getModel())
    				.getRow(row);
    		if (c != null) {
    			AbstractDlg dialog = new DeleteDlg(frame, contactTable);
    			dialog.setModal(true);
    			dialog.setVisible(true);
    		}
    		
    		((ContactTableModel)contactTable.getModel())
    			.fireTableRowsInserted(row, row);
    	}
    }
    
 
    @Override
    public void editDraft() {
    	//bring up email transmission dialog
    	if (frame != null && draftTable != null) {
    		int row = draftTable.getSelectedRow();
    		Draft draft = ((DraftTableModel)draftTable.getModel())
            		.getRow(row);
            
            AbstractDlg dialog = new EmailTransmissionDlg(frame,
            		draftTable, (Email)draft);
    		dialog.setModal(true);
    		dialog.setVisible(true);
    	}
    }

 
    @Override
    public void deleteDraft() {
    	//confirm then delete draft, update table when done
    	if (frame != null && draftTable != null) {
    		int row = draftTable.getSelectedRow();
    		
    		int result = JOptionPane.showConfirmDialog(null,
    				"Are you sure you want to delete this draft?",
    				"Confirm delete",
    				JOptionPane.YES_NO_OPTION);
    		
    		if (result == JOptionPane.YES_OPTION) {
    			DataStore.getInstance().getDrafts().remove(row);
    			((DraftTableModel)draftTable.getModel())
    				.fireTableRowsDeleted(row, row);
    		}
    	}
    	
    }
    

    @Override
    public void contactTableClicked(int num) {
    	//if double click in contact table, bring up email transmission dialog
    	if (num == 2) {
	    	int row = contactTable.getSelectedRow();
	        if (frame != null && contactTable != null && draftTable != null) {
	            Contact c = ((ContactTableModel)contactTable.getModel())
	            		.getRow(row);
	            if (c != null) {
	                Email email = new Email();
	                email.setToField(Email.parseAddressList(c.getEmail()));
	                
	                AbstractDlg dialog = new EmailTransmissionDlg(frame,
	                		draftTable, email);
	                dialog.setModal(true);
	                dialog.setVisible(true);
	            }
	        }
    	}
    }
    

    @Override
    public void draftTableClicked(int num) {
    	//if double click in drafttable, bring up email transmission dialog
    	if (num == 2) {
	    	int row = draftTable.getSelectedRow();
	        if (frame != null && draftTable != null) {
	            Email d = ((DraftTableModel)draftTable.getModel()).getRow(row);
	            if (d != null) {
	                AbstractDlg dialog = new EmailTransmissionDlg(frame,
	                		draftTable, d);
	                dialog.setModal(true);
	                dialog.setVisible(true);
	            }
	        }
    	}
    }

    @Override
    public void registerFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void registerContactTable(ContactTable table) {
        this.contactTable = table;
    }


    @Override
    public void registerDraftTable(DraftTable table) {
    	this.draftTable = table;
    }
    
}
