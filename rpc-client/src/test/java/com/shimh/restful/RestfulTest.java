package com.shimh.restful;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.shimh.common.model.User;

public class RestfulTest {
	
	private RestTemplate rest;
	
	@Before
	public void init(){
		
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
		
		rest = new RestTemplate(factory);
		
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		rest.getMessageConverters().add(converter);
	}
	
	
	@Test
	public void test1(){
		
		String url = "http://localhost:8080/rpc-service/user/getUser?id=1";
		User user = rest.getForObject(url, User.class);
		System.out.println(user);
	}
	
	@Test
	public void test2(){
		
		String url = "http://localhost:8080/rpc-service/user/listUsersJSON";
		List<User> users = rest.getForObject(url, List.class);
		System.out.println(users);
	}
	
	@Test
	public void test3(){
		
		String url = "http://localhost:8080/rpc-service/testMap";
		
		 HttpHeaders requestHeaders = new HttpHeaders();   
         //requestHeaders.set("head", "password");   
         requestHeaders.setContentType(MediaType.APPLICATION_JSON);  
         //requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));  
         Map<String, Object> m=new HashMap<String, Object>();  
         m.put("param", "中文");  
         m.put("red", 3);  
         //通过HttpEntity 设置参数 head  
         HttpEntity<?> request=new HttpEntity(m, requestHeaders); 
		
		Map result = rest.postForObject(url, request, Map.class);
		
		System.out.println((User)result.get("user"));
	}
	
}
