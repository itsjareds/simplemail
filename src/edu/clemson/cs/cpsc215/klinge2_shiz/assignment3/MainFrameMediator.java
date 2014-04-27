package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import java.awt.Frame;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config.ConfigurationDlg;

public class MainFrameMediator implements MainFrameMediatorInterface {
    private Frame frame = null;
    
    @Override
    public void exit() {
        DataStore.getInstance().storeConf();
        DataStore.getInstance().storeContacts();
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
    public void registerFrame(Frame frame) {
        this.frame = frame;
    }

}
