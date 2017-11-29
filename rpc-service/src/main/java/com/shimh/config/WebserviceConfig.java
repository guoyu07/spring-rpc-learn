package com.shimh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import com.shimh.common.service.UserService;

@Configuration
@ComponentScan(basePackages = "com.shimh.webservice")
public class WebserviceConfig {
	
	@Bean("simpleJaxWsServiceExporter")
	public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
		
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		
		exporter.setBaseAddress("http://localhost:8070/services/");
		
		return exporter;
		
	}
	


	
}
