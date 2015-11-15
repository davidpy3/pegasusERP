package edu.uns.sgsi.ejb;

import java.util.Properties;
import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class MailService implements MailServiceLocal{

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    @Override
    public void send(String destiny,String subject, String emailBody) {
        try {
//        System.getProperties().put("proxySet", "true");
//        System.getProperties().put("proxyHost", "192.168.100.1");
//        System.getProperties().put("proxyPort", "8080");
            // Step1
            System.out.println("\n 1st ===> Propiedades de Servicio de Mail");
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "25");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            System.out.println("Servidor Mail funciona ha sido instalado correctamente");

            System.out.println("\n\n 2nd ===> Inicia Sesión de mail");
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);

            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destiny));
            generateMailMessage.setSubject(subject);
            generateMailMessage.setContent(emailBody, "text/html");

            System.out.println("Sesión de Mail cerrada correctamente");
            System.out.println("\n\n 3ra ===> Recupera sesión y envia email");
            Transport transport = getMailSession.getTransport("smtp");

            // Enter your correct gmail UserID and Password 
            // if you have 2FA enabled then provide App Specific Password
            transport.connect("smtp.gmail.com","dbaseguridad2015@gmail.com", "servidor22");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            throw new RuntimeException("Mail Exception.", ex);
        }
    }
}