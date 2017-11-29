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
		
		//Spring RMI �������˿ڣ�һ����ע��˿ڣ�Ĭ��Ϊ1099��������һ�������ݴ���˿ڣ������ָ�������ݴ���˿����������ġ�
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
