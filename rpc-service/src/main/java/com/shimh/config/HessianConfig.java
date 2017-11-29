package com.shimh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.shimh.common.service.UserService;

@Configuration
@ComponentScan(basePackages = "com.shimh.hessian")
public class HessianConfig {
	
	@Bean("hessianServiceExporter")
	public HessianServiceExporter hessianServiceExporter(@Qualifier("hessianUserServiceImpl")UserService userServiceImpl){
		
		HessianServiceExporter exporter = new HessianServiceExporter();
		
		exporter.setService(userServiceImpl);
		exporter.setServiceInterface(UserService.class);
		return exporter;
		
	}
	


	
}
