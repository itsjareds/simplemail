package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ContactTableMultiClickListener;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.MultiClickable;

/**
 * Draft table class. Set up the table
 * extends JTable
 * implements MultiClickable
 * @author klinge2
 * @author shiz
 * @since 4-28-14
 *
 */
@SuppressWarnings("serial")
public class ContactTable extends JTable implements MultiClickable {
    private MainFrameMediator med = null;
    
    /**
     * set up draft table
     * @param model
     * @param med
     */
    public ContactTable(ContactTableModel model, MainFrameMediator med) {
        super(model);
        this.med = med;
        this.med.registerContactTable(this);
        
        //allow horizontal scroll bar to be usable 
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //allow one row selection at a time
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //listener for mouse clicks
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
