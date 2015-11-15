package edu.uns.sgsi.ejb;

public interface MailServiceLocal {
    
    public void send(String email,String subject, String emailBody);
    
}