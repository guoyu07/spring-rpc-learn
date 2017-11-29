package com.shimh.config;

import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.shimh.common.service.UserService;


@Configuration
public class WebserviceConfig {
	
	@Bean
	public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean() throws Exception{
		
		JaxWsPortProxyFactoryBean factoryBean = new JaxWsPortProxyFactoryBean();
		factoryBean.setWsdlDocumentUrl(new URL("http://127.0.0.1:8070/services/WebserviceUserService?wsdl"));
		factoryBean.setServiceName("WebserviceUserService");
		factoryBean.setPortName("UserServiceEndpointPort");
		factoryBean.setNamespaceUri("http://api.webservice.shimh.com/");
		factoryBean.setServiceInterface(UserService.class);
		return factoryBean;
	}
	


}
