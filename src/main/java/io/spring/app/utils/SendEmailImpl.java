package io.spring.app.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Log4j2
@Component
public class SendEmailImpl implements SendEmail {

    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    @Override
    public void send(String email, String title, String content) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(prop);
        Message message = new MimeMessage(session);

        try {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(title);
            message.setText(content);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            log.info("Send email to [" + email + "] success!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String email, String content) {
        String title = "[Hệ thống đóng học phí]";
        this.send(email, title, content);
    }
}
