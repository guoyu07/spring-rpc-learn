package com.shimh.webservice.api;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shimh.common.model.User;
import com.shimh.common.service.UserService;

@Component
@WebService(serviceName = "WebserviceUserService")
public class UserServiceEndpoint {

	@Autowired
	@Qualifier("webserviceUserServiceImpl")
	private UserService userService;
	
	@WebMethod
	public void addUser(User user) {
		userService.addUser(user);
	}
	@WebMethod
	public void deleteUser(String id) {
		userService.deleteUser(id);
	}
	@WebMethod
	public User getUser(String id) {
		return userService.getUser(id);
	}
	@WebMethod
	public List<User> listAllUsers() {
		return userService.listAllUsers();
	}
	
}
