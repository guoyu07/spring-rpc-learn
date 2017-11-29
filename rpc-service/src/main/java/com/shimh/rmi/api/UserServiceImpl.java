package com.shimh.rmi.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shimh.common.model.User;
import com.shimh.common.service.UserServiceAdapter;

@Service("userServiceImpl")
public class UserServiceImpl extends UserServiceAdapter{

	@Override
	public void addUser(User user) {
		System.out.println("����rmi����addUser()");
		super.addUser(user);
	}

	@Override
	public void deleteUser(String id) {
		System.out.println("����rmi����deleteUser()");
		super.deleteUser(id);
	}

	@Override
	public User getUser(String id) {
		System.out.println("����rmi����getUser()");
		return super.getUser(id);
	}

	@Override
	public List<User> listAllUsers() {
		System.out.println("����rmi����listAllUsers()");
		return super.listAllUsers();
	}
	
	
}
	