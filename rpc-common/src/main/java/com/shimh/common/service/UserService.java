package com.shimh.common.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.shimh.common.model.User;
@WebService
public interface UserService {
	
	@WebMethod
	void addUser(User user);
	@WebMethod
	void deleteUser(String id);
	@WebMethod
	User getUser(String id);
	@WebMethod
	List<User> listAllUsers();
	
	
}
