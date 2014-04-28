package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import javax.swing.JTable;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ContactTableDoubleClickListener;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.DoubleClickable;

@SuppressWarnings("serial")
public class ContactTable extends JTable implements DoubleClickable {
    private MainFrameMediator med = null;
    
    public ContactTable(ContactTableModel model, MainFrameMediator med) {
        super(model);
        this.med = med;
        this.med.registerContactTable(this);
        
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.addMouseListener(new ContactTableDoubleClickListener());
    }
    
    @Override
    public void triggerEvent() {
        if (med != null)
            med.contactTableClicked();
    }
    
    @Override
    public boolean getScrollableTracksViewportWidth(){
        return getPreferredSize().width < getParent().getWidth();
    }
    
    @Override
    public String getName() {
    	return "Contacts";
    }

}
