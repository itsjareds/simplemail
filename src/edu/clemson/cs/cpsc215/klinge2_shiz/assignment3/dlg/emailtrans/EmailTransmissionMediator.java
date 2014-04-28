package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.Email;
import edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.EmailHandler;

public class EmailTransmissionMediator implements EmailTransmissionMediatorInterface {
    ButtonSend buttonSend = null;
    ButtonDraft buttonDraft = null;
    ButtonCancel buttonCancel = null;
    EmailTransmissionDlg draftDlg = null;
    JTextField toField, ccField, bccField, subjectField;
    JTextArea bodyField;

    public EmailTransmissionMediator(EmailTransmissionDlg draftDlg) {
        this.draftDlg = draftDlg;
    }
    
    @Override
    public void send() {
        String to, cc, bcc, sub, body;
        
        to = toField.getText();
        cc = ccField.getText();
        bcc = bccField.getText();
        sub = subjectField.getText();
        body = bodyField.getText();
        
        Email draft = new Email(to, cc, bcc, sub, body);
        EmailHandler handler = new EmailHandler();
        handler.sendMail(draft);
        
        this.cancel();
    }

    @Override
    public void draft() {
        System.out.println("Draft button action unimplemented");
    }

    @Override
    public void cancel() {
        draftDlg.setVisible(false);
        draftDlg.dispose();
    }

    @Override
    public void registerSendButton(ButtonSend send) {
        this.buttonSend = send;
    }

    @Override
    public void registerDraftButton(ButtonDraft draft) {
         this.buttonDraft = draft;
    }

    @Override
    public void registerCancelButton(ButtonCancel cancel) {
        this.buttonCancel = cancel;
    }

    @Override
    public void registerToField(JTextField toField) {
        this.toField = toField;
    }

    @Override
    public void registerCcField(JTextField ccField) {
        this.ccField = ccField;
    }

    @Override
    public void registerBccField(JTextField bccField) {
        this.bccField = bccField;
    }

    @Override
    public void registerSubjectField(JTextField subjectField) {
        this.subjectField = subjectField;
    }

    @Override
    public void registerBodyField(JTextArea bodyField) {
        this.bodyField = bodyField;
    }

}
