package com.shimh.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.jms.support.JmsUtils;

public class JMSListener implements MessageListener{

	public void onMessage(Message message) {
		
		ObjectMessage om = (ObjectMessage) message;

		try {
			System.out.println("listener����  ��Ϣ�ǣ� "+ om.getObject());
		} catch (JMSException e) {
			JmsUtils.convertJmsAccessException(e);  //Spring��ת��exception
		}
		
	}

}
