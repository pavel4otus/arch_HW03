package ru.pavel2107.socketclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pavel2107.socketclient.model.ChatMessage;
import ru.pavel2107.socketclient.model.Conversation;
import ru.pavel2107.socketclient.model.InputMessage;
import ru.pavel2107.socketclient.service.ConversationService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSocketAdminController {

    private ConversationService conversationService;

    @Autowired
    public WebSocketAdminController(ConversationService conversationService){
        this.conversationService = conversationService;
    }

    @GetMapping( value = "/admin/chat/all_sessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Conversation> getSessions(){
        List<Conversation> list = conversationService.findAll();
        return list;
    }

    @GetMapping( value = "/admin/chat/avail_sessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Conversation> getAvailableSessions(){
        List<Conversation> list = conversationService.findAvailable();
        return list;
    }


}