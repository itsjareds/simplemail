package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

import java.util.List;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Contact;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;

/**
 * Mediator pattern class for DeleteDlg.
 * implements DeleteMediatorInterface
 * @author shiz
 * @author klinge2
 * @since 4-28-14
 *
 */
public class DeleteMediator implements DeleteMediatorInterface{
	ButtonYes buttonYes = null;
	ButtonNo buttonNo = null;
	DeleteDlg deleteDlg = null;
	
	/**
	 * @param deleteDlg
	 */
	public DeleteMediator(DeleteDlg deleteDlg){
		this.deleteDlg = deleteDlg;
	}

	@Override
	public void yes() {
		//delete contact from contact table and DataStore
		List<Contact> contacts = DataStore.getInstance().getContacts();
		
		int row = deleteDlg.index;
		if (row != -1)
			contacts.remove(row);
		
		deleteDlg.setVisible(false);
	}

	@Override
	public void no() {
		deleteDlg.setVisible(false);
		deleteDlg.dispose();
	}
}
