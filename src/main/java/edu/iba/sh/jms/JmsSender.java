package edu.iba.sh.jms;

import javax.jms.Session;

import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class JmsSender {

	public static void send(String messageText) throws JmsException {
		MQQueueSender sender;
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
			
			sender = session.createSender(queue);

			JMSTextMessage textMessage = session.createTextMessage();

			textMessage.setText(messageText);

			textMessage.send();

		} catch (Exception e) {
			throw new JmsException(e);
		} finally {
			if (sender != null) {
				sender.close();
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
