package com.shimh.webservice.api;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.shimh.common.model.User;
import com.shimh.common.service.UserServiceAdapter;

@Service("webserviceUserServiceImpl")
@WebService
public class UserServiceImpl extends UserServiceAdapter{

	@Override
	@WebMethod
	public void addUser(User user) {
		System.out.println("访问webservice服务addUser()");
		super.addUser(user);
	}

	@Override
	@WebMethod
	public void deleteUser(String id) {
		System.out.println("访问webservice服务deleteUser()");
		super.deleteUser(id);
	}

	@Override
	@WebMethod
	public User getUser(String id) {
		System.out.println("访问webservice服务getUser()");
		return super.getUser(id);
	}

	@Override
	@WebMethod
	public List<User> listAllUsers() {
		System.out.println("访问webservice服务listAllUsers()");
		return super.listAllUsers();
	}
	
	
}
	