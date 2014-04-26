package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.ButtonCancel;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.ButtonSave;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.CheckBoxAuthPop3;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.CheckBoxAuthSmtp;

public interface ConfigMediatorInterface {
	public void authSmtp(int selected);
	public void authPop3(int selected);
	public void cancel();
	public void save();
	
	public void registerAuthSmtpCheckbox(CheckBoxAuthSmtp check);
	public void registerSmtpUserLabel(JTextField user);
	public void registerSmtpPassLabel(JPasswordField pass);
	public void registerSmtpPortLabel(JTextField port);
	
	public void registerAuthPop3Checkbox(CheckBoxAuthPop3 check);
	public void registerPop3UserLabel(JTextField user);
	public void registerPop3PassLabel(JPasswordField pass);
	public void registerPop3PortLabel(JTextField port);
	
	public void registerCancelButton(ButtonCancel cancel);
	public void registerSaveButton(ButtonSave save);
}