package com.shimh.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shimh.common.model.User;
import com.shimh.common.service.UserService;
import com.shimh.config.RmiConfig;
import com.shimh.config.WebserviceConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebserviceConfig.class)
public class WebserviceTest {
	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void test1(){
		User user = new User("1","a",20);
		
		userService.addUser(user);
		
		User user1 = userService.getUser("1");
		
		System.out.println(user1);
		
		
	}
	
	
}
