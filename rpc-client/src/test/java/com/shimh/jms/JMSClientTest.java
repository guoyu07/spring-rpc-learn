package com.shimh.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shimh.common.model.User;
import com.shimh.common.service.UserService;
import com.shimh.config.JMSConfig;
import com.shimh.config.RmiConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JMSConfig.class)
public class JMSClientTest {
	
	@Autowired
	private JMSClient jMSClient;
	
	@Test
	public void test1(){
		String message1 = "hello jms";
		
		jMSClient.sendMessage2Default(message1);
		
		
		User user = new User("1","v",20);
		jMSClient.sendMessage2Default(user);
		
	}
	
	
	
}
