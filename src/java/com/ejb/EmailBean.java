package com.ejb;



import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class EmailBean {


    @Resource(name = "mail/mmixco")
    private Session mailSession;

    
    /**
    *sendMessage
    * Proceso de Negocio que permite el envie de email, para notificar a los usurios
    * de algun proceso
    * @author       Daniel Romero
    * @version      1.0
    */
    public void sendMessage(String email, String subject, String bodyMessage) throws MessagingException {

        Message message = new MimeMessage(mailSession);
        try {
            message.setSubject(subject);
            message.setRecipient(RecipientType.TO, new InternetAddress(email));
            message.setContent(bodyMessage, "text/html; charset=utf-8");
            message.setHeader("X-Mailer", "MINIpay mailer www.minipay.eu");
            Date timeStamp = new Date();
            message.setSentDate(timeStamp);
            Transport.send(message);
        } catch (MessagingException ex) {
            throw ex;
        }
    }
} 