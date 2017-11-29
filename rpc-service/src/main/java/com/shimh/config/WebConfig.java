package com.shimh.config;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.shimh.restful")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/template");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/WEB-INF/resource/");
		registry.addResourceHandler("/template/**").addResourceLocations("/WEB-INF/template/");
		
		super.addResourceHandlers(registry);
	}

	@Bean
	public HandlerMapping handlerMapping(){
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setOrder(0);
		Properties p = new Properties();
		p.setProperty("/UserService.service", "hessianServiceExporter");
		p.setProperty("/httpInvokerUserService.service", "httpInvokerServiceExporter");
		mapping.setMappings(p);
		
		return mapping;
	}

/*	
 * restful的方案 1 内容协商
 * 
 * @Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		//默认的内容类型
		configurer.defaultContentType(MediaType.TEXT_HTML);
		
	}
	
	@Bean 
	public ViewResolver cnViewResolver(ContentNegotiationManager manager){
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(manager);
		
		return viewResolver;
	}*/
	
	/*
	 * 
	 * restful的方案 2 Http消息转换器
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
		
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
		
		converter.setFastJsonConfig(fastJsonConfig);
		
		converters.add(converter);
	}
	
}
