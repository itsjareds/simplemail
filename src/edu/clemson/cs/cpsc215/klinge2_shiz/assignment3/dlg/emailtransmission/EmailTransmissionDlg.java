package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtransmission;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.mail.internet.InternetAddress;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Email;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.AbstractDlg;

@SuppressWarnings("serial")
public class EmailTransmissionDlg extends AbstractDlg {
    private Email draft = new Email();

    public EmailTransmissionDlg(Frame owner) {
        super(owner, "Compose a message");
        addComponents();
    }
    
    public EmailTransmissionDlg(Frame owner, Email draft) {
        super(owner, "Compose a message");
        this.draft = draft;
        addComponents();
    }

    @Override
    protected void addComponents() {
        JPanel containerPanel = new JPanel();
        containerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        containerPanel.setLayout(new BorderLayout());
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints c;
        
        EmailTransmissionMediator med = new EmailTransmissionMediator(this);
        
        JLabel label;
        JTextField txt;
        JTextArea txtArea;
        JScrollPane scrollPane;
        JButton button;
        
        int row = 0, col = 0;
        
        // Labels
        
        label = new JLabel("TO:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("CC:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("BCC:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        label = new JLabel("Subject:");
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        innerPanel.add(label, c);
        
        col++;
        row = 0;
        
        // Textfields
        
        txt = new JTextField();
        if (draft.getToField() != null) {
            String contents = "";
            InternetAddress[] toField = draft.getToField();
            for (int i = 0; i < toField.length; i++) {
                if (i != 0)
                    contents += ", ";
                contents += toField[i].getAddress();
            }
            txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerToField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        if (draft.getCcField() != null) {
            String contents = "";
            InternetAddress[] ccField = draft.getCcField();
            for (int i = 0; i < ccField.length; i++) {
                if (i != 0)
                    contents += ", ";
                contents += ccField[i].getAddress();
            }
            txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerCcField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        if (draft.getBccField() != null) {
            String contents = "";
            InternetAddress[] bccField = draft.getBccField();
            for (int i = 0; i < bccField.length; i++) {
                if (i != 0)
                    contents += ", ";
                contents += bccField[i].getAddress();
            }
            txt.setText(contents);
        }
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerBccField(txt);
        innerPanel.add(txt, c);
        
        txt = new JTextField();
        txt.setText(draft.getSubject());
        txt.setColumns(40);
        c = new GridBagConstraints();
        c.gridx = col;
        c.gridy = row++;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        med.registerSubjectField(txt);
        innerPanel.add(txt, c);
        
        txtArea = new JTextArea(8, 40);
        txtArea.setText(draft.getMessage());
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = row++;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        med.registerBodyField(txtArea);
        scrollPane = new JScrollPane(txtArea);
        innerPanel.add(scrollPane, c);
        
        // Buttons
        
        button = new ButtonCancel(med);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHWEST;
        med.registerCancelButton((ButtonCancel)button);
        innerPanel.add(button, c);
        
        button = new ButtonDraft(med);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = row;
        c.gridwidth = 1;
        c.weightx = 2;
        c.anchor = GridBagConstraints.CENTER;
        med.registerDraftButton((ButtonDraft)button);
        innerPanel.add(button, c);
        
        button = new ButtonSend(med);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = row;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.SOUTHEAST;
        med.registerSendButton((ButtonSend)button);
        innerPanel.add(button, c);
        
        containerPanel.add(innerPanel, BorderLayout.CENTER);
        this.getContentPane().add(containerPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationByPlatform(true);
    }

}
