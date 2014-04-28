package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.delete;

public interface DeleteMediatorInterface {
	public void yes();
	public void no();
	
	public void registerYesButton(ButtonYes yes);
	public void registerNoButton(ButtonNo no);

}
