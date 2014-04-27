package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.draft;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface DraftMediatorInterface {
    public void send();
    public void draft();
    public void cancel();
    
    public void registerSendButton(ButtonSend send);
    public void registerDraftButton(ButtonDraft draft);
    public void registerCancelButton(ButtonCancel cancel);
    public void registerToField(JTextField toField);
    public void registerCcField(JTextField ccField);
    public void registerBccField(JTextField bccField);
    public void registerSubjectField(JTextField subjectField);
    public void registerBodyField(JTextArea bodyField);
}
