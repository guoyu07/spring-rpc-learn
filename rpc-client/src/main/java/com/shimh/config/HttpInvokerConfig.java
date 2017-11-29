package com.shimh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.shimh.common.service.UserService;

@Configuration
public class HttpInvokerConfig {
	
	@Bean
	public HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean(){
		
		HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();

		factoryBean.setServiceUrl("http://localhost:8080/rpc-service/httpInvokerUserService.service");
		factoryBean.setServiceInterface(UserService.class);
		return factoryBean;
	}
	
	
}
