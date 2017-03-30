package com.process.PersonManager.utils.Listener;

import com.process.PersonManager.model.loginForm.User;
import com.process.PersonManager.service.userService.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

/**
 * Created by Кирилл on 14.03.2017.
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent>{

    private final UserService userService;
    private final MessageSource messages;
    private final JavaMailSender mailSender;

    private static final Logger logger = Logger.getLogger(RegistrationListener.class);
    @Autowired
    public RegistrationListener(JavaMailSender mailSender, MessageSource messages, UserService userService) {
        this.mailSender = mailSender;
        this.messages = messages;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
        try {
            this.confirmRegistration(onRegistrationCompleteEvent);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void confirmRegistration(OnRegistrationCompleteEvent onRegistrationCompleteEvent) throws MailException, MessagingException {
        User user = onRegistrationCompleteEvent.getUser();
        String token = UUID.randomUUID().toString();
        userService.Save(user,token);
        String recipientAddress = user.getEmail();
        String subject = "Подтверждение регистрации";
        String confirmationUrl = onRegistrationCompleteEvent.getAppUrl()+"/registrationConfirm?token="+token;
        logger.info(confirmationUrl);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("bulychevkery@gmail.com");
        helper.setTo(recipientAddress);
        helper.setSubject(subject);
        helper.setText("<html>" +
                "<body>" +
                "<h3>Здравствйте,"+user.getFirstName() +" "+ user.getLastName() +"</h3>"+
                "Пожалуйста перейдите по ссылке,чтобы завершить процесс регистрации"+
                "<a href=http://localhost:8080"+confirmationUrl+">http://localhost:8080"+confirmationUrl+"</a>" +
                "</body>" +
                "</html>",true);

        mailSender.send(mimeMessage);
    }
}
