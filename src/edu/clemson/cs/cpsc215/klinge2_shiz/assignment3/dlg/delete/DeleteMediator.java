package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class DeleteMediator implements DeleteMediatorInterface{
	
	ButtonYes buttonYes = null;
	ButtonNo buttonNo = null;
	DeleteDlg deleteDlg = null;
	
	public DeleteMediator(DeleteDlg deleteDlg){
		this.deleteDlg = deleteDlg;
	}


	@Override
	public void yes() {

	}

	@Override
	public void no() {
		deleteDlg.setVisible(false);
		deleteDlg.dispose();
		
	}

	@Override
	public void registerYesButton(ButtonYes yes) {
		this.buttonYes = yes;
		
	}

	@Override
	public void registerNoButton(ButtonNo no) {
		this.buttonNo = no;
		
	}
	
	

}
