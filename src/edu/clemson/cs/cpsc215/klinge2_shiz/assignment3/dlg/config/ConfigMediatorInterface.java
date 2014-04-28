package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface ConfigMediatorInterface {
	/**
	 * @param selected
	 */
	public void authSmtp(int selected);
	/**
	 * @param selected
	 */
	public void authPop3(int selected);
	public void cancel();
	public void save();
	
	/**
	 * @param check
	 */
	public void registerAuthSmtpCheckbox(CheckBoxAuthSmtp check);
	
	/**
	 * @param user
	 */
	public void registerSmtpUserLabel(JTextField user);
	
	/**
	 * @param pass
	 */
	public void registerSmtpPassLabel(JPasswordField pass);
	
	/**
	 * @param port
	 */
	public void registerSmtpPortLabel(JTextField port);
	
	/**
	 * @param check
	 */
	public void registerAuthPop3Checkbox(CheckBoxAuthPop3 check);
	
	/**
	 * @param user
	 */
	public void registerPop3UserLabel(JTextField user);
	
	/**
	 * @param pass
	 */
	public void registerPop3PassLabel(JPasswordField pass);
	
	/**
	 * @param port
	 */
	public void registerPop3PortLabel(JTextField port);
	
	/**
	 * @param cancel
	 */
	public void registerCancelButton(ButtonCancel cancel);
	
	/**
	 * @param save
	 */
	public void registerSaveButton(ButtonSave save);
	
	/**
	 * @param email
	 */
	public void registerEmailLabel(JTextField email);
	
	/**
	 * @param smtp
	 */
	public void registerSmtpServerLabel(JTextField smtp);
	
	/**
	 * @param pop
	 */
	public void registerPopServerLabel(JTextField pop);
	
	/**
	 * @param name
	 */
	public void registerNameLabel(JTextField name);
}