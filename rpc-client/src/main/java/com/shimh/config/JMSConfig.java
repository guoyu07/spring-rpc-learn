package com.shimh.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.shimh.jms.JMSClient;

@Configuration
public class JMSConfig {

	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
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
	public JMSClient jMSClient(JmsTemplate jmsTemplate){
		
		JMSClient client = new JMSClient(jmsTemplate);
		return client;

	}
	
	/*<bean id="jmsFactory" class="org.apache.activemq.pool.PooledConnectionFactory"
	          destroy-method="stop">
	        <property name="connectionFactory">
	            <bean class="org.apache.activemq.ActiveMQConnectionFactory">
	                <property name="brokerURL">
	                    <value>tcp://192.168.0.129:61616</value>
	                </property>
	            </bean>
	        </property>
	        <property name="maxConnections" value="100"></property>
	    </bean>

	    <!--使用缓存可以提升效率-->
	    <bean id="cachingConnectionFactory" class="org.springframework.jms.connection.CachingConnectionFactory">
	        <property name="targetConnectionFactory" ref="jmsFactory"/>
	        <property name="sessionCacheSize" value="1"/>
	    </bean>

	    <bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
	        <property name="connectionFactory" ref="cachingConnectionFactory"/>
	        <property name="messageConverter">
	            <bean class="org.springframework.jms.support.converter.SimpleMessageConverter"/>
	        </property>
	    </bean>

	    <!--测试Queue,队列的名字是spring-queue-->
	    <bean id="destinationQueue" class="org.apache.activemq.command.ActiveMQQueue">
	        <!--<constructor-arg index="0" value="spring-queue"/>-->
	        <constructor-arg name="name" value="spring-queue"/>
	    </bean>

	    <!--测试Topic-->
	    <bean id="destinationTopic" class="org.apache.activemq.command.ActiveMQTopic">
	        <constructor-arg index="0" value="spring-topic"/>
	    </bean>*/
	
}
