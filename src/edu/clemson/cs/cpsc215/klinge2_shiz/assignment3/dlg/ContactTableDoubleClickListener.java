package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.ContactTable;

public class ContactTableDoubleClickListener extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
        ContactTable table = (ContactTable)e.getSource();
        int row = table.getSelectedRow();
        if (e.getClickCount() == 2) {
            table.triggerEvent(row);
        }
    }
    
}
