package com.shimh.hessian.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shimh.common.model.User;
import com.shimh.common.service.UserServiceAdapter;

@Service("hessianUserServiceImpl")
public class UserServiceImpl extends UserServiceAdapter{

	@Override
	public void addUser(User user) {
		System.out.println("访问hessian服务addUser()");
		super.addUser(user);
	}

	@Override
	public void deleteUser(String id) {
		System.out.println("访问hessian服务deleteUser()");
		super.deleteUser(id);
	}

	@Override
	public User getUser(String id) {
		System.out.println("访问hessian服务getUser()");
		return super.getUser(id);
	}

	@Override
	public List<User> listAllUsers() {
		System.out.println("访问hessian服务listAllUsers()");
		return super.listAllUsers();
	}
	
	
}
	