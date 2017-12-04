package edu.iba.sh.jms;

import javax.jms.QueueSender;
import javax.jms.Session;

import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class JmsReciever {

	public static String recieveMessage(){
		MQQueueReceiver receiver;
		MQQueueSession session;
		MQQueueConnection connection;
		try {
			MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
			connectionFactory.setHostName("172.20.2.116");
			connectionFactory.setPort(1416);
			connectionFactory.setQueueManager("CSQ8");

			connection = (MQQueueConnection) connectionFactory
					.createConnection();

			session = (MQQueueSession) connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			MQQueue queue = (MQQueue) session.createQueue("Queue1");
			

			receiver = (MQQueueReceiver) session.createReceiver(queue);
			
			JMSTextMessage message = (JMSTextMessage) receiver.receive("100");

			message.acknowledge();
			return message == null ? null : message.getText();
			
		} catch (Exception e) {
			throw new JmsException(e);
		} finally {
			if (receiver != null) {
				receiver.close();
			}
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public static void init() throws JmsException{
		MQQueueReceiver receiver;
		MQQueueSession session;
		MQQueueConnection connection;
		try {
			MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
			connectionFactory.setHostName("172.20.2.116");
			connectionFactory.setPort(1416);
			connectionFactory.setQueueManager("CSQ8");

			connection = (MQQueueConnection) connectionFactory
					.createConnection();

			session = (MQQueueSession) connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			MQQueue queue = (MQQueue) session.createQueue("Queue1");

			receiver = (MQQueueReceiver) session.createReceiver(queue);

			receiver.setMessageListener(new JmsMessageListener());

			connection.start();
		} catch (Exception e) {
			throw new JmsException(e);
		} finally {
			if (receiver != null) {
				receiver.close();
			}
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
