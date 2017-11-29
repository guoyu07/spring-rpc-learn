package com.shimh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.shimh.common.service.UserService;

@Configuration
@ComponentScan(basePackages = "com.shimh.rmi")
public class RmiConfig {
	
	@Bean
	public RmiProxyFactoryBean rmiProxyFactoryBean(){
		
		RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();

		factoryBean.setServiceUrl("rmi://localhost:1099/UserService");
		factoryBean.setServiceInterface(UserService.class);
		
		//解决重启 rmi 的服务器后会出现拒绝连接或找不到服务对象的错误  
		factoryBean.setLookupStubOnStartup(false);//不在容器启动的时候创建与Server端的连接  
		factoryBean.setRefreshStubOnConnectFailure(true);//表示是否连接出错时自动重连  
		
		return factoryBean;
	}
	
	
}
