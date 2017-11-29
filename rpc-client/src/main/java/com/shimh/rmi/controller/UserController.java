package com.shimh.rmi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shimh.common.model.User;
import com.shimh.common.service.UserService;

@Controller
@RequestMapping("rmi/user")
public class UserController {
	
	//暴露的rmi服务
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public void addUser(User user){
		userService.addUser(user);
	}
	
	
	@GetMapping("/addUser")
	public void getUser(String id){
		userService.getUser(id);
	}
	
}
