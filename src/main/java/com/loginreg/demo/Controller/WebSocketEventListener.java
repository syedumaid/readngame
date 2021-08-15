package com.loginreg.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.loginreg.demo.model.ChatMessage;
import com.loginreg.demo.model.MessageType;

@Component
public class WebSocketEventListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations sendingOperations;
	
	@EventListener
	public void handleWebSocketConnectListener(final SessionConnectedEvent event)
	{
		LOGGER.info("We have a new user connected to the socket");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		final String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		final ChatMessage chatMessage = ChatMessage.builder()
				.type(MessageType.DISCONNET)
				.sender(username)
				.build();
		
		sendingOperations.convertAndSend("/topic/public",chatMessage);
		
	}
	
}
