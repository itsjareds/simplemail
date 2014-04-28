package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Email;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config.ConfigurationDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans.EmailTransmissionDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.sysinf.SystemInformationDlg;

public class MainFrameMediator implements MainFrameMediatorInterface {
    private Frame frame = null;
    private ContactTable contactTable = null;
    private DraftTable draftTable = null;
    
    @Override
    public void compose() {
    	if (frame != null) {
    		AbstractDlg dialog = new EmailTransmissionDlg(frame);
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
    	if (contactTable != null) {
    		DataStore.getInstance().getContacts().clear();
    		((ContactTableModel)contactTable.getModel()).fireTableDataChanged();
    	}
    }
    
    @Override
    public void clearDrafts() {
    	if (draftTable != null) {
    		DataStore.getInstance().getDrafts().clear();
    		((DraftTableModel)draftTable.getModel()).fireTableDataChanged();
    	}
    }
    
    @Override
    public void config() {
        if (frame != null) {
            AbstractDlg dialog = new ConfigurationDlg(frame);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
    }

    @Override
    public void about() {
        if (frame != null) {
            AbstractDlg dialog = new SystemInformationDlg(frame);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
    }
    
    @Override
    public void contactTableClicked() {
    	int row = contactTable.getSelectedRow();
        if (frame != null && contactTable != null) {
            Contact c = ((ContactTableModel)contactTable.getModel()).getRow(row);
            if (c != null) {
                Email email = new Email();
                email.setToField(Email.parseAddressList(c.getEmail()));
                
                AbstractDlg dialog = new EmailTransmissionDlg(frame, email);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        }
    }
    
    @Override
    public void draftTableClicked() {
    	int row = draftTable.getSelectedRow();
        if (frame != null && draftTable != null) {
            Email d = ((DraftTableModel)draftTable.getModel()).getRow(row);
            if (d != null) {
                AbstractDlg dialog = new EmailTransmissionDlg(frame, d);
                dialog.setModal(true);
                dialog.setVisible(true);
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
