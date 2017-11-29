package com.shimh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.shimh.common.service.UserService;

@Configuration
@ComponentScan(basePackages = "com.shimh.httpinvoker")
public class HttpInvokerConfig {
	
	@Bean("httpInvokerServiceExporter")
	public HttpInvokerServiceExporter httpInvokerServiceExporter(@Qualifier("httpInvokerUserServiceImpl")UserService userServiceImpl){
		
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		
		exporter.setService(userServiceImpl);
		exporter.setServiceInterface(UserService.class);
		return exporter;
		
	}
	
}
