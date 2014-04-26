package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.AuthenticationInfo;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Configuration;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.CheckableItemListener;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.controls.ClickableActionListener;

public class ConfigurationDlg extends JDialog {
	/**
	 * Automatically generated serialVersionUID
	 */
	private static final long serialVersionUID = -1760183194108670101L;
	
	public ConfigurationDlg(JFrame owner) {
		super(owner, "Preferences");
		addComponents();
	}
	
	private void addComponents() {
		JPanel containerPanel = new JPanel();
		containerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		containerPanel.setLayout(new BorderLayout());
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c;
		
		ConfigMediatorInterface med = new ConfigMediator(this);
		Configuration conf = DataStore.getInstance().getConf();
		JLabel label;
		JCheckBox checkBox;
		JTextField txt;
		JPasswordField pass;
		JButton button;
		AuthenticationInfo auth;
		
		int row = 0, col = 0;
		final int maxColWidth = 2;
		
		// User info labels
		
		label = new JLabel("Name:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("Email:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("SMTP server:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		row += 1;
		
		// POP3 labels
		
		label = new JLabel("Username:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("Password:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("Port:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		row++;
		
		// SMTP labels
		
		label = new JLabel("Username:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("Password:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("Port:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		col++;
		row = 0;
		
		txt = new JTextField();
		if (conf.getName() != null)
			txt.setText(conf.getName());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerNameLabel(txt);
		innerPanel.add(txt, c);
		
		// User info textfields
		txt = new JTextField();
		if (conf.getEmail() != null)
			txt.setText(conf.getEmail().getAddress());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerEmailLabel(txt);
		innerPanel.add(txt, c);
		
		txt = new JTextField();
		if (conf.getSmtpServer() != null)
			txt.setText(conf.getSmtpServer().getHostName());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerSmtpServerLabel(txt);
		innerPanel.add(txt, c);
		
		// POP3 textfields
		
		auth = conf.getAuthPop3();
		
		checkBox = new CheckBoxAuthPop3(new CheckableItemListener(), med);
		checkBox.setSelected(conf.isSslUsedPop3());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerAuthPop3Checkbox((CheckBoxAuthPop3)checkBox);
		innerPanel.add(checkBox, c);
		
		row += 0;
		
		txt = new JTextField();
		if (auth != null)
			txt.setText(auth.getUsername());
		if (!conf.isSslUsedPop3())
			txt.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerPop3UserLabel(txt);
		innerPanel.add(txt, c);
		
		pass = new JPasswordField();
		if (auth != null)
			pass.setText(auth.getPassword());
		if (!conf.isSslUsedPop3())
			pass.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerPop3PassLabel(pass);
		innerPanel.add(pass, c);
		
		txt = new JTextField();
		if (auth != null)
			txt.setText(auth.getAuthport());
		if (!conf.isSslUsedPop3())
			txt.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerPop3PortLabel(txt);
		innerPanel.add(txt, c);
		
		// SMTP textfields
		
		auth = conf.getAuthSmtp();
		
		checkBox = new CheckBoxAuthSmtp(new CheckableItemListener(), med);
		checkBox.setSelected(conf.isSslUsedSmtp());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerAuthSmtpCheckbox((CheckBoxAuthSmtp)checkBox);
		innerPanel.add(checkBox, c);
		
		txt = new JTextField();
		if (auth != null)
			txt.setText(auth.getUsername());
		if (!conf.isSslUsedSmtp())
			txt.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerSmtpUserLabel(txt);
		innerPanel.add(txt, c);
		
		pass = new JPasswordField();
		if (auth != null)
			pass.setText(auth.getPassword());
		if (!conf.isSslUsedSmtp())
			pass.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerSmtpPassLabel(pass);
		innerPanel.add(pass, c);
		
		txt = new JTextField();
		if (auth != null)
			txt.setText(auth.getAuthport());
		if (!conf.isSslUsedSmtp())
			txt.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerSmtpPortLabel(txt);
		innerPanel.add(txt, c);
		
		// Save and Cancel buttons
		
		button = new ButtonSave(new ClickableActionListener(), med);
		c = new GridBagConstraints();
		c.gridx = maxColWidth - 1;
		c.gridy = row;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.SOUTHEAST;
		med.registerSaveButton((ButtonSave)button);
		innerPanel.add(button, c);
		
		button = new ButtonCancel(new ClickableActionListener(), med);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = row;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.SOUTHWEST;
		med.registerCancelButton((ButtonCancel)button);
		innerPanel.add(button, c);
		
		containerPanel.add(innerPanel, BorderLayout.CENTER);
		this.getContentPane().add(containerPanel, BorderLayout.CENTER);
		this.pack();
	}
}