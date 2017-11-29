package com.shimh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.shimh.websocket.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		registry.addHandler(webSocketHandler(), "/websocket");
		
	}

	
	@Bean
	public MyWebSocketHandler webSocketHandler(){
		
		MyWebSocketHandler WebSocketHandler = new MyWebSocketHandler();
		return WebSocketHandler;
	}
	
}
