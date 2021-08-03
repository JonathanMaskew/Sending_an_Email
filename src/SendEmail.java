import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.*;

public class SendEmail {
    public static void main(String[] args) throws MessagingException {
        //using Gmail
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jmaskew1.compsci@gmail.com", "compSci@PU");
            }
        });

        Message message = new MimeMessage(session);
        message.setText("**EMERGENCY ALERT**\nSusan Todd did NOT check in today. Please check in with her.");

        Address addressTo = new InternetAddress("3176060246@vtext.com");
        message.setRecipient(Message.RecipientType.TO, addressTo);

        Address addressFrom = new InternetAddress("jmaskew1.compsci@gmail.com");
        message.setFrom(addressFrom);

        Transport.send(message);
        System.out.println("Message sent successfully.");
    }
}
