package ru.pavel2107.socketclient.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.context.event.EventListener;
import ru.pavel2107.socketclient.model.Conversation;
import ru.pavel2107.socketclient.service.ConversationService;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConversationEventListener {

    private ConversationService service;

    public ConversationEventListener( ConversationService service){
        this.service = service;
    }

    private String getSessionId( Message message){
        StompHeaderAccessor sha = StompHeaderAccessor.wrap( message);
        MessageHeaders headers = sha.getMessageHeaders();
        Map<String, String> map = (Map<String, String>)headers.get( "simpSessionAttributes");
        String sessionId = null;
        if( map != null) {
            sessionId = map.get("sessionId");
            if( sessionId != null) {
                Conversation conversation = service.findBySessionId(sessionId);
                if (conversation.getSessionId() != null) {
                    conversation.setDisconnected(LocalDateTime.now());
                    service.save(conversation);
                }
            }
        }
        return sessionId;
    }

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        String sessionId = getSessionId( event.getMessage());
        System.out.println( "handleSessionConnected.sessionId : " + sessionId);
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        String sessionId = getSessionId( event.getMessage());
        System.out.println( "handleSessionDisconnect.sessionId : " + sessionId);
        if( sessionId != null) {
            Conversation conversation = service.findBySessionId(sessionId);
           if ( conversation.getSessionId() != null) {
                conversation.setDisconnected(LocalDateTime.now());
                service.save(conversation);
           }
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(ConversationEventListener.class);
    private List<String> connectedClientId = new ArrayList<String>();

    @EventListener
    public void connectionEstablished(SessionConnectedEvent sce)
    {
        MessageHeaders msgHeaders = sce.getMessage().getHeaders();
        Principal princ = (Principal) msgHeaders.get("simpUser");
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sce.getMessage());
        List<String> nativeHeaders = sha.getNativeHeader("userId");
        if( nativeHeaders != null )
        {
            String userId = nativeHeaders.get(0);
            connectedClientId.add(userId);
            if( logger.isDebugEnabled() )
            {
                logger.debug("Connessione websocket stabilita. ID Utente "+userId);
            }
        }
        else
        {
            String userId = princ.getName();
            connectedClientId.add(userId);
            if( logger.isDebugEnabled() )
            {
                logger.debug("Connessione websocket stabilita. ID Utente "+userId);
            }
        }
    }

    @EventListener
    public void webSockectDisconnect(SessionDisconnectEvent sde)
    {
        MessageHeaders msgHeaders = sde.getMessage().getHeaders();
        Principal princ = (Principal) msgHeaders.get("simpUser");
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sde.getMessage());
        List<String> nativeHeaders = sha.getNativeHeader("userId");
        if( nativeHeaders != null )
        {
            String userId = nativeHeaders.get(0);
            connectedClientId.remove(userId);
            if( logger.isDebugEnabled() )
            {
                logger.debug("Connessione websocket stabilita. ID Utente "+userId);
            }
        }
        else
        {
            String userId = princ.getName();
            connectedClientId.remove(userId);
            if( logger.isDebugEnabled() )
            {
                logger.debug("Connessione websocket stabilita. ID Utente "+userId);
            }
        }
    }

    public List<String> getConnectedClientId()
    {
        return connectedClientId;
    }
    public void setConnectedClientId(List<String> connectedClientId)
    {
        this.connectedClientId = connectedClientId;
    }

}
