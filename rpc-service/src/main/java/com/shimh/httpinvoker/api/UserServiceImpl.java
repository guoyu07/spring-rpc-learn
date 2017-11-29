package com.shimh.httpinvoker.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shimh.common.model.User;
import com.shimh.common.service.UserServiceAdapter;

@Service("httpInvokerUserServiceImpl")
public class UserServiceImpl extends UserServiceAdapter{

	@Override
	public void addUser(User user) {
		System.out.println("����httpinvoker����addUser()");
		super.addUser(user);
	}

	@Override
	public void deleteUser(String id) {
		System.out.println("����httpinvoker����deleteUser()");
		super.deleteUser(id);
	}

	@Override
	public User getUser(String id) {
		System.out.println("����httpinvoker����getUser()");
		return super.getUser(id);
	}

	@Override
	public List<User> listAllUsers() {
		System.out.println("����httpinvoker����listAllUsers()");
		return super.listAllUsers();
	}
	
	
}
	