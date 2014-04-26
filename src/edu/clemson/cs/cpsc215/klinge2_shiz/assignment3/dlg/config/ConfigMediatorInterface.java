package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	public void registerEmailLabel(JTextField email);
	public void registerSmtpServerLabel(JTextField smtp);
	public void registerNameLabel(JTextField name);
}