package ru.pavel2107.arch.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pavel2107.arch.notification.service.NotificationService;

import java.util.Map;

@RestController
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public NotificationController( NotificationService notificationService){
        this.notificationService = notificationService;
    }


    @PostMapping( value = "/microservices/v1/notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public void send( Map<String, Object> properties){
        notificationService.send( properties);
    }
}
