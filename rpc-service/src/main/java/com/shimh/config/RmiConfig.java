package com.shimh.config;

import java.rmi.registry.Registry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.shimh.common.service.UserService;

@Configuration
@ComponentScan(basePackages = "com.shimh.rmi")
public class RmiConfig {
	
	@Bean
	public RmiServiceExporter rmiServiceExporter(UserService userServiceImpl, Registry registry){
		
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		
		rmiServiceExporter.setService(userServiceImpl);
		rmiServiceExporter.setServiceName("UserService");
		rmiServiceExporter.setServiceInterface(UserService.class);
		
		//Spring RMI 有两个端口，一个是注册端口（默认为1099），还有一个是数据传输端口，如果不指定，数据传输端口是随机分配的。
		rmiServiceExporter.setRegistry(registry);
		rmiServiceExporter.setServicePort(1199);
		
		
		return rmiServiceExporter;
		
	}
	
	@Bean 
	public RmiRegistryFactoryBean RmiRegistryFactoryBean(){
		
		RmiRegistryFactoryBean factoryBean = new RmiRegistryFactoryBean();
		//factoryBean.setHost("localhost");
		factoryBean.setPort(1099);
		return factoryBean;
	}
	
}
