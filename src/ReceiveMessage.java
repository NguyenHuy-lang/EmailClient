import javax.mail.*;
import java.util.Properties;

public class ReceiveMessage {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "huynguyend19ptit@gmail.com", "ofueqoeyxuystyhs");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            System.out.println(in.length);
            for (Address address : in)
                System.out.println("FROM:" + address.toString());
            Object content = msg.getContent();
            if (content instanceof String)
            {
                String body = (String)content;
                System.out.println(body);
            }
            else if (content instanceof Multipart)
            {
                Multipart mp = (Multipart)content;
                BodyPart bp = mp.getBodyPart(0);
                System.out.println("SENT DATE:" + msg.getSentDate());
                System.out.println("SUBJECT:" + msg.getSubject());
                System.out.println("CONTENT:" + bp.getContent());
            }
            Multipart mp = (Multipart) msg.getContent();

        } catch (Exception ex) { ex.printStackTrace(); }
    }

}
