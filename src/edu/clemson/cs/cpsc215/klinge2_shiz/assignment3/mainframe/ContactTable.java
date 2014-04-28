package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import javax.swing.JTable;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ContactTableMultiClickListener;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.MultiClickable;

@SuppressWarnings("serial")
public class ContactTable extends JTable implements MultiClickable {
    private MainFrameMediator med = null;
    
    public ContactTable(ContactTableModel model, MainFrameMediator med) {
        super(model);
        this.med = med;
        this.med.registerContactTable(this);
        
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.addMouseListener(new ContactTableMultiClickListener());
    }
    
    @Override
    public void triggerEvent(int num) {
        if (med != null)
            med.contactTableClicked(num);
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
