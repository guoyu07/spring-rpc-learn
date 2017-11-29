package com.shimh.common.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.shimh.common.model.User;

public  class UserServiceAdapter implements UserService{

	private static List<User> users = new CopyOnWriteArrayList<User>();
	
	
	public void addUser(User user) {
		users.add(user);
	}

	public void deleteUser(String id) {
		for(User u:users){
			if(u.getId().equals(id)){
				users.remove(u);
				break;
			}
		}
		
	}

	public User getUser(String id) {
		for(User u:users){
			if(u.getId().equals(id)){
				return u;
			}
		}
		return null;
	}

	public List<User> listAllUsers() {
		
		return users;
	}
	
	
	
}
