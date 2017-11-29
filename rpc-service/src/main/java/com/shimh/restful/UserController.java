package com.shimh.restful;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shimh.common.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private static List<User> users = new CopyOnWriteArrayList<User>();
	
	static{
		User u = new User("1", "a", 30);
		users.add(u);
	}
	
	/*
	 * consumes 鍏虫敞璇锋眰鐨凜ontent-Type 澶撮儴淇℃伅 鏄惁鏄� "application/json" 
	 */
	@RequestMapping(value="/addUser",consumes="application/json")
	public void addUser(@RequestBody User user) {
		users.add(user);
	}
	
	@RequestMapping("/deleteUser")
	public void deleteUser(String id) {
		for(User u:users){
			if(u.getId().equals(id)){
				users.remove(u);
				break;
			}
		}
		
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(String id) {
		for(User u:users){
			if(u.getId().equals(id)){
				return u;
			}
		}
		return null;
	}
	
	@RequestMapping("/listUsers")
	public String listAllUsers(Model model) {
		model.addAttribute("users", users);
		
		return "/listUsers";
	}
	
	/*
	 * produces 鍙鐞嗚緭鍑轰负JSON鐨勮姹傦紝Accept
	 */
	@RequestMapping(value = "/listUsersJSON",produces = "application/json")
	@ResponseBody
	public List<User> listAllUsersJSON() {
		
		return users;
	}
	
	@RequestMapping("/websocket")
	public String webSocket(Model model) {
		
		return "/websocket";
	}
}
