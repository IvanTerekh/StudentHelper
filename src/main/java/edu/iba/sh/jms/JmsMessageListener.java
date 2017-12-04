package edu.iba.sh.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.ibm.jms.JMSTextMessage;

public class JmsMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(((JMSTextMessage)message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
