package ru.pavel2107.arch.notification.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class notificationServiceImpl implements NotificationService {

    private PushService  pushService;
    private EmailService emailService;

    @Autowired
    public notificationServiceImpl(PushService pushService, EmailService emailService){
        this.emailService = emailService;
        this.pushService  = pushService;
    }


    @Override
    public void send(Map<String, Object> properties) {
        String destination = (String) properties.get( "destination");
        switch ( destination){
           case "push":
               String phone      = (String) properties.get( "phone");
               String message    = (String) properties.get( "message");
               pushService.push( phone, message);
               break;
            case "email":
                String to      = (String) properties.get( "to");
                String subject = (String) properties.get( "subject");
                String text    = (String) properties.get( "text");
                emailService.send( to, subject, text);
                break;
        }
    }
}
