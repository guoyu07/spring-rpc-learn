package com.shimh.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

public class JMSClient {
	
	private JmsOperations jmsOperations;
	
	public JMSClient(JmsOperations jmsOperations){
		this.jmsOperations = jmsOperations;
	}
	
	public void sendMessage(String name, String message){
		jmsOperations.send(name, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
	public void sendMessage(String name, Serializable message){
		jmsOperations.send(name, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(message);
			}
		});
	}
	
	public void sendMessage2Default(Object message){
		
		jmsOperations.convertAndSend(message);
	}
	
}
