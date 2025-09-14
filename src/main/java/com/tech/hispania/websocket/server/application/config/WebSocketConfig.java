package com.tech.hispania.websocket.server.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.tech.hispania.websocket.server.application.handlers.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	private final MyWebSocketHandler myWebSocketHandler;

	public WebSocketConfig(MyWebSocketHandler myWebSocketHandler) {
		this.myWebSocketHandler = myWebSocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myWebSocketHandler, "/ws").setAllowedOrigins("*");
		
	}
}
