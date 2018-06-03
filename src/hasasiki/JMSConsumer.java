package hasasiki;

import java.io.IOException;
import javax.jms.*;
import org.apache.activemq.*;

public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws IOException {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageConsumer messageConsumer;
		
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			//Create session
			destination = session.createTopic("FirstTopic");
			//Consumer get message from Topic
			messageConsumer = session.createConsumer(destination);
			//Test.savechatlog(session.toString());
			messageConsumer.setMessageListener(new Listener());
		}
		catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
