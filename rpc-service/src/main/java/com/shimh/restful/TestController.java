package com.shimh.restful;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shimh.common.model.User;

@RestController
public class TestController {
	
	@RequestMapping("/testMap")
	public Map testMap(@RequestBody Map map){
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println(map);
		
		result.put("string", "test1");
		result.put("user", new User("t1","test",40));
		return result;
	}
	
	
}
