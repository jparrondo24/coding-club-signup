import java.util.Properties;
import java.io.Console;
import java.util.Scanner;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;
import javax.mail.Message;
import javax.mail.Transport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daper
 */
public class Emailer {
    public static final String HOST = "smtp.gmail.com";
    public String email;
    public Session session; 
    
    
    public Emailer() {
        
    }
    
    public void initialize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter email(you need to enable insecure apps for gmail): ");
        email = scanner.nextLine();
        System.out.println("Please enter password for \"" + email + "\"");
        Console cons;
        char[] passwd;
        if ((cons = System.console()) != null &&
                (passwd = cons.readPassword("[%s]", "Password:")) != null) {
            //System.out.println("Password-" + new String(passwd));
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //System.out.println("Password-" + new String(passwd));
                    //int x = 1/0;
                    return new PasswordAuthentication(email, new String(passwd));
                }
            });
            //java.util.Arrays.fill(passwd, ' ');
        }
    }

    
    public void sendMessage(String to, String subject, String content) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);  
            message.setText(content);
            Transport.send(message);
            System.out.println("message sent successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public void sendThankYouMsg(String email, String name) {
        String subject = "Thank you for joining Coding Club";
        String msg = "Hello %s,\nThank you for joining Coding Club.\n\n"
                + "Our first meeting will be Thursday after school in M27.\n"
                + "We hope to see you there\n\n"
                + "Justin Parrondo\n"
                + "President\n\n"
                + "David Perez\n"
                + "Vice President";
        msg = String.format(msg, name);
        sendMessage(email, subject, msg);
    }
}
