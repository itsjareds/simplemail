package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe;

import javax.swing.JTable;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ContactTableDoubleClickListener;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.DoubleClickable;

@SuppressWarnings("serial")
public class ContactTable extends JTable implements DoubleClickable {
    private MainFrameMediator med = null;
    
    public ContactTable(TableModel model, MainFrameMediator med) {
        super(model);
        this.med = med;
        this.med.registerTable(this);
        
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.addMouseListener(new ContactTableDoubleClickListener());
    }
    
    @Override
    public void triggerEvent(int row) {
        if (med != null)
            med.tableClicks(row);
    }
    
    @Override
    public boolean getScrollableTracksViewportWidth(){
        return getPreferredSize().width < getParent().getWidth();
    }

}
