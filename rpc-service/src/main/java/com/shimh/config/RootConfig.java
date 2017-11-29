package com.shimh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RmiConfig.class,HessianConfig.class,HttpInvokerConfig.class,WebserviceConfig.class,JMSConfig.class,WebSocketConfig.class})
public class RootConfig {

}
