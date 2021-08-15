package com.loginreg.demo.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginreg.demo.model.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload final ChatMessage chatMessage) {
		
		return chatMessage;
	}
	
	@MessageMapping("/chat.newUser")
	@SendTo("/topic/public")
	public ChatMessage newUser(@Payload final ChatMessage chatMessage,
								SimpMessageHeaderAccessor headerAccessor)
	{
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	@GetMapping("/chat")
	public String viewChat() {
		return "chat.html";
	}
	
}