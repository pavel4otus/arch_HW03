package ru.pavel2107.arch.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{


    @Autowired
    public EmailServiceImpl(){
    }


    @Override
    public void send(String to, String subject, String text) {
	System.out.println( "to: " + to + "\nsubject: " + subject + "\n" + text);
    }
}
