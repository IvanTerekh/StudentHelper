package edu.iba.sh.jms;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Session;

import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueBrowser;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class JmsBrowser {
	
	public static Enumeration getMessages(){
		MQQueueBrowser browser;
		MQQueueSession session;
		MQQueueConnection connection;
		List<String> result = new ArrayList<String>();
		try {
			MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
			connectionFactory.setHostName("172.20.2.116");
			connectionFactory.setPort(1416);
			connectionFactory.setQueueManager("CSQ8");

			connection = (MQQueueConnection) connectionFactory
					.createConnection();

			session = (MQQueueSession) connection.createSession(false,
					Session.CLIENT_ACKNOWLEDGE);//Session.CLIENT_ACKNOWLEDGE

			MQQueue queue = (MQQueue) session.createQueue("Queue1");
			
			browser = (MQQueueBrowser) session.createBrowser(queue);
			
			return browser.getEnumeration();
		} catch (Exception e) {
			throw new JmsException(e);
		} finally {
			if (browser != null) {
				browser.close();
			}
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static List<String> getTextOfMessages(){
		Enumeration e = getMessages();
		
		while(e.hasMoreElements()){
			JMSTextMessage message = (JMSTextMessage) e.nextElement();
			result.add(message.getText());
		}
		return result;
	}
	
	public static void delete(String text) {
		Enumeration e = getMessages();
		
		while(e.hasMoreElements()){
			JMSTextMessage message = (JMSTextMessage) e.nextElement();
			if (message.getText().equals(text)){
				message.acknowledge();
				return;
			}
		}
	}
	
	
}
