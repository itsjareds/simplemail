package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JButton;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.Clickable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class ButtonSave extends JButton implements Clickable {
	private ConfigMediatorInterface med = null;
	
	public ButtonSave(ClickableActionListener listener,
	        ConfigMediatorInterface med) {
		super("Save");
		this.med = med;
		this.addActionListener(listener);
		this.med.registerSaveButton(this);
	}

	@Override
	public void triggerEvent() {
		med.save();
	}

	
}
