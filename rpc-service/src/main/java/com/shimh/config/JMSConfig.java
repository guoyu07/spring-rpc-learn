package com.shimh.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.shimh.jms.JMSListener;
import com.shimh.jms.JMSService;

@Configuration
public class JMSConfig {

	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		//需修改activemq.xml 的uri
		factory.setBrokerURL("tcp://localhost:61616");
		
		return factory;
	}
	
	@Bean
	public ActiveMQQueue activeMQQueue(){
		
		ActiveMQQueue queue = new ActiveMQQueue("defaultQueue");
		return queue;

	}
	
	@Bean
	public ActiveMQTopic activeMQTopic(){
		
		ActiveMQTopic topic = new ActiveMQTopic("topic1");
		return topic;

	}
	
	@Bean
	public JmsTemplate jmsTemplate(ActiveMQConnectionFactory factory, ActiveMQQueue destination){
		
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(factory);
		
		template.setDefaultDestination(destination);
		
		return template;

	}
	
	
	@Bean
	public JMSService jmsService(JmsTemplate jmsTemplate){
		JMSService s = new JMSService(jmsTemplate);
		return s;
	}
	
	//---自动监听
	@Bean
	public DefaultMessageListenerContainer listenerContainer(ConnectionFactory factory, JMSListener jMSListener, ActiveMQQueue activeMQQueue){
		
		
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(factory);
		
		container.setMessageListener(jMSListener);
		
		container.setDestination(activeMQQueue);
		return container;
	}
	
	
	@Bean
	public JMSListener jMSListener(){
		JMSListener s = new JMSListener();
		return s;
	}
	
}
