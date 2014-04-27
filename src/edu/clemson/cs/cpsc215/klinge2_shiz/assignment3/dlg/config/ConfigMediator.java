package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import java.awt.event.ItemEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.AuthenticationInfo;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Configuration;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;

public class ConfigMediator implements ConfigMediatorInterface {
	private ConfigurationDlg confDlg = null;
	@SuppressWarnings("unused")
	private ButtonCancel buttonCancel = null;
	@SuppressWarnings("unused")
	private ButtonSave buttonSave = null;
	private CheckBoxAuthPop3 checkBoxAuthPop3 = null;
	private CheckBoxAuthSmtp checkBoxAuthSmtp = null;
	private JTextField txtPop3User, txtPop3Pass, txtPop3Port,
					txtSmtpUser, txtSmtpPass, txtSmtpPort, txtEmail,
					txtSmtpServer, txtPopServer, txtName;
	
	public ConfigMediator(ConfigurationDlg confDlg) {
		this.confDlg = confDlg;
	}
	
	@Override
	public void authSmtp(int selected) {
		if (selected == ItemEvent.SELECTED) {
			if (txtSmtpUser != null && txtSmtpPass != null
					&& txtSmtpPort != null) {
				txtSmtpUser.setEnabled(true);
				txtSmtpPass.setEnabled(true);
				txtSmtpPort.setEnabled(true);
			}
		} else if (selected == ItemEvent.DESELECTED) {
			if (txtSmtpUser != null && txtSmtpPass != null
					&& txtSmtpPort != null) {
				txtSmtpUser.setEnabled(false);
				txtSmtpPass.setEnabled(false);
				txtSmtpPort.setEnabled(false);
			}
		}
	}

	@Override
	public void authPop3(int selected) {
		if (selected == ItemEvent.SELECTED) {
			if (txtPop3User != null && txtPop3Pass != null
					&& txtPop3Port != null) {
				txtPop3User.setEnabled(true);
				txtPop3Pass.setEnabled(true);
				txtPop3Port.setEnabled(true);
			}
		} else if (selected == ItemEvent.DESELECTED) {
			if (txtPop3User != null && txtPop3Pass != null
					&& txtPop3Port != null) {
				txtPop3User.setEnabled(false);
				txtPop3Pass.setEnabled(false);
				txtPop3Port.setEnabled(false);
			}
		}
	}

	@Override
	public void cancel() {
		confDlg.setVisible(false);
	}

	@Override
	public void save() {
		DataStore storage = DataStore.getInstance();
		Configuration conf = storage.getConf();
		
		if (txtEmail != null)
			conf.setEmail(txtEmail.getText());
		
		if (txtSmtpServer != null)
			conf.setSmtpServer(txtSmtpServer.getText());
		
		if (txtPopServer != null)
			conf.setPopServer(txtPopServer.getText());
		
		if (txtName != null)
			conf.setName(txtName.getText());
		
		conf.setSslUsedPop3(checkBoxAuthPop3.isSelected());
		if (txtPop3User.getText() != null &&
				txtPop3Pass.getText() != null &&
				txtPop3Port.getText() != null) {
			conf.setAuthPop3(new AuthenticationInfo(txtPop3User.getText(),
					txtPop3Pass.getText(), txtPop3Port.getText()));
		}
		
		conf.setSslUsedSmtp(checkBoxAuthSmtp.isSelected());
		if (txtSmtpUser.getText() != null &&
				txtSmtpPass.getText() != null &&
				txtSmtpPort.getText() != null) {
			conf.setAuthSmtp(new AuthenticationInfo(txtSmtpUser.getText(),
					txtSmtpPass.getText(), txtSmtpPort.getText()));
		}
		
		try {
		    storage.storeConf();
		} catch (Exception e) {
		    System.out.println("Error while saving config file.");
		    e.printStackTrace();
		}
		confDlg.setVisible(false);
	}

	@Override
	public void registerAuthSmtpCheckbox(CheckBoxAuthSmtp check) {
		this.checkBoxAuthSmtp = check;
	}

	@Override
	public void registerAuthPop3Checkbox(CheckBoxAuthPop3 check) {
		this.checkBoxAuthPop3 = check;
	}

	@Override
	public void registerCancelButton(ButtonCancel cancel) {
		this.buttonCancel = cancel;
	}

	@Override
	public void registerSaveButton(ButtonSave save) {
		this.buttonSave = save;
	}

	@Override
	public void registerSmtpUserLabel(JTextField user) {
		this.txtSmtpUser = user;
	}

	@Override
	public void registerSmtpPassLabel(JPasswordField pass) {
		this.txtSmtpPass = pass;
	}

	@Override
	public void registerSmtpPortLabel(JTextField port) {
		this.txtSmtpPort = port;
	}

	@Override
	public void registerPop3UserLabel(JTextField user) {
		this.txtPop3User = user;
	}

	@Override
	public void registerPop3PassLabel(JPasswordField pass) {
		this.txtPop3Pass = pass;
	}

	@Override
	public void registerPop3PortLabel(JTextField port) {
		this.txtPop3Port = port;
	}

	@Override
	public void registerEmailLabel(JTextField email) {
		this.txtEmail = email;
	}

	@Override
	public void registerSmtpServerLabel(JTextField smtp) {
		this.txtSmtpServer = smtp;
	}

	@Override
	public void registerNameLabel(JTextField name) {
		this.txtName = name;
	}

	@Override
	public void registerPopServerLabel(JTextField pop) {
		this.txtPopServer = pop;
	}

}