package com.shimh.jms;


import javax.annotation.PostConstruct;

import org.springframework.jms.core.JmsOperations;

public class JMSService {
	
	private boolean quiet = true;
	
	private JmsOperations jmsOperations;
	
	public JMSService(JmsOperations jmsOperations){
		this.jmsOperations = jmsOperations;
	}
	

	public boolean isQuiet() {
		return quiet;
	}

	public void setQuiet(boolean quiet) {
		this.quiet = quiet;
	}
	
	@PostConstruct
	public void receive(){
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println("监听jms message 启动。。。。");
				while (quiet) {

					Object message = jmsOperations.receiveAndConvert();
					
					System.out.println(message);
					
				}
				
			}
		}).start();
		
	}
	
	
	
}
