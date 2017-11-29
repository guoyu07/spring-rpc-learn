package com.shimh.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return  new Class[]{WebConfig.class};
	}
	
	/*
	 * .service 访问hessian服务
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/", "*.service"};
	}

}
