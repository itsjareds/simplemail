package edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg.emailtrans;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Email transmission mediator interface
 * @author klinge2
 * @since 4-28-14
 *
 */
public interface EmailTransmissionMediatorInterface {
    public void send();
    public void draft();
    public void cancel();
    
    /**
     * @param send
     */
    public void registerSendButton(ButtonSend send);
    /**
     * @param draft
     */
    public void registerDraftButton(ButtonDraft draft);
    /**
     * @param cancel
     */
    public void registerCancelButton(ButtonCancel cancel);
    /**
     * @param toField
     */
    public void registerToField(JTextField toField);
    /**
     * @param ccField
     */
    public void registerCcField(JTextField ccField);
    /**
     * @param bccField
     */
    public void registerBccField(JTextField bccField);
    /**
     * @param subjectField
     */
    public void registerSubjectField(JTextField subjectField);
    /**
     * @param bodyField
     */
    public void registerBodyField(JTextArea bodyField);
}
