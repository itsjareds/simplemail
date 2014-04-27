package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import java.awt.Frame;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Email;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.SystemInformationDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config.ConfigurationDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.draft.DraftDlg;

public class MainFrameMediator implements MainFrameMediatorInterface {
    private Frame frame = null;
    private ContactTable table = null;
    
    @Override
    public void exit() {
        try {
            DataStore.getInstance().storeConf();
        } catch (Exception e) {
            System.out.println("Error while saving config file.");
            e.printStackTrace();
        }
        try {
            DataStore.getInstance().storeContacts();
        } catch (Exception e) {
            System.out.println("Error while saving contacts.");
            e.printStackTrace();
        }
        System.exit(0);
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
    public void tableClicks(int row) {
        if (frame != null && table != null) {
            Contact c = ((TableModel)table.getModel()).getRow(row);
            if (c != null) {
                Email email = new Email();
                email.setToField(Email.parseAddressList(c.getEmail()));
                
                AbstractDlg dialog = new DraftDlg(frame, email);
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
    public void registerTable(ContactTable table) {
        this.table = table;
    }

}
