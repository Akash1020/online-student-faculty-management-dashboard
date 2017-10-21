/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaurav Sehar
 */
public class GMail {
    private static final String USERNAME = "gscollegemail";
    private static final String PASSWORD = ;
    
    public static boolean SendMail(String recipients, String subject, String messageBody) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");

        Session emailSession = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try{
            Message message = new MimeMessage(emailSession);
            message.setFrom(new InternetAddress(USERNAME + "@gmail.com"));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(recipients));
            message.setSubject(subject);
            message.setText(messageBody
            + "\n this mail has been dispathced from javamail-API using GMail SSL login (App made by Gaurav Sehar for college submission.)");
            Transport.send(message);
            return true;
        }catch(MessagingException ex){
            JOptionPane.showMessageDialog(null, "MessagingException Occur in SendMail member function of GMail.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
