package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.AuthenticationInfo;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Configuration;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.DataStore;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;

@SuppressWarnings("serial")
public class ConfigurationDlg extends AbstractDlg {
	public ConfigurationDlg(Frame owner) {
        super(owner, "Preferences");
        addComponents();
    }

	protected void addComponents() {
		JPanel containerPanel = new JPanel();
		containerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		containerPanel.setLayout(new BorderLayout());
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c;
		
		ConfigMediator med = new ConfigMediator(this);
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
		
		// SMTP labels
		
		label = new JLabel("SMTP server:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.insets = new Insets(10, 0, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("SMTP port:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		row++;
		
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
		
        // POP3 labels
        
		label = new JLabel("POP server:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.insets = new Insets(10, 0, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		label = new JLabel("POP port:");
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		innerPanel.add(label, c);
		
		row++;
		
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
		
		col++;
		row = 0;
		
		// User info textfields
		
		txt = new JTextField();
		txt.setText(conf.getName());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerNameLabel(txt);
		innerPanel.add(txt, c);
		
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
		
		// SMTP textfields
		
		txt = new JTextField();
		if (conf.getSmtpServer() != null)
		    txt.setText(conf.getSmtpServer().getHostName());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.insets = new Insets(10, 0, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerSmtpServerLabel(txt);
		innerPanel.add(txt, c);

		txt = new JTextField();
		txt.setText(conf.getSmtpPort());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerSmtpPortLabel(txt);
		innerPanel.add(txt, c);
		
        auth = conf.getAuthSmtp();
        
        checkBox = new CheckBoxAuthSmtp(med);
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
		
        // POP3 textfields
        
		txt = new JTextField();
		if (conf.getPopServer() != null)
			txt.setText(conf.getPopServer().getHostName());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.insets = new Insets(10, 0, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerPopServerLabel(txt);
		innerPanel.add(txt, c);
		
		txt = new JTextField();
		txt.setText(conf.getPopPort());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerPop3PortLabel(txt);
		innerPanel.add(txt, c);
		
		auth = conf.getAuthPop3();
		
		checkBox = new CheckBoxAuthPop3(med);
		checkBox.setSelected(conf.isSslUsedPop3());
		c = new GridBagConstraints();
		c.gridx = col;
		c.gridy = row++;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		med.registerAuthPop3Checkbox((CheckBoxAuthPop3)checkBox);
		innerPanel.add(checkBox, c);
		
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
		
		// Save and Cancel buttons
		
		button = new ButtonSave(med);
		c = new GridBagConstraints();
		c.gridx = maxColWidth - 1;
		c.gridy = row;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.SOUTHEAST;
		innerPanel.add(button, c);
		
		button = new ButtonCancel(med);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = row;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.SOUTHWEST;
		innerPanel.add(button, c);
		
		containerPanel.add(innerPanel, BorderLayout.CENTER);
		this.getContentPane().add(containerPanel, BorderLayout.CENTER);
		this.pack();
		this.setLocationByPlatform(true);
	}
}