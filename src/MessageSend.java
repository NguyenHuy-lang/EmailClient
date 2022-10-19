import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class MessageSend {
    public static void main(String[] args) throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("huynguyend19ptit@gmail.com", "ofueqoeyxuystyhs");
            }
        });

        Message message = new MimeMessage(session);
        message.setSubject("Email from my Java Program");
        message.setContent("<h1>Email from my Java Program</h1>", "text/html");

        Address addressTo = new InternetAddress("huynguyend19ptit@gmail.com");
        message.setRecipient(Message.RecipientType.TO, addressTo);

        MimeMultipart mimeMultipart = new MimeMultipart();

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File("static/img.png"));

        MimeBodyPart  messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<h1>Email from my Java Program</h1>", "text/html");
        mimeMultipart.addBodyPart(messageBodyPart);
        mimeMultipart.addBodyPart(attachment);

        message.setContent(mimeMultipart);
        Transport.send(message);
    }


}