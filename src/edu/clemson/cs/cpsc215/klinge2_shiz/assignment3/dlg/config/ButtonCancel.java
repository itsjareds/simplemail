package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.config;

import javax.swing.JButton;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.Clickable;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.ClickableActionListener;

@SuppressWarnings("serial")
public class ButtonCancel extends JButton implements Clickable {
	private ConfigMediatorInterface med = null;

	public ButtonCancel(ClickableActionListener listener,
	        ConfigMediatorInterface med) {
		super("Cancel");
		this.med = med;
		this.addActionListener(listener);
		this.med.registerCancelButton(this);
	}
	
	@Override
	public void triggerEvent() {
		med.cancel();
	}

}
