package com.tech.hispania.websocket.server.application.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

	private final static Logger logger = LogManager.getLogger(MyWebSocketHandler.class);

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Connection with client '{}' is stablished", session.getId());
		session.sendMessage(new TextMessage("Connection established successfully"));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("Message received from client '{}': {}", session.getId(), message.getPayload());
		session.sendMessage(new TextMessage("Echo: " + message.getPayload()));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("Connection with client '{}' is closed", session.getId());
	}
}
