package hasasiki;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;  

public class JMSProducer {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	//link to default user name
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL;
	private static final int SENDNUM = 10;//Number of message
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory connectionFactory;//connect to factory
		Connection connection = null;//connect
		Session session;//process of conversation, send or receive message
		Destination destination;//destination of message
		MessageProducer messageProducer;//message producer
		
		// --> Instantiation(实例化) connection factory
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();
			//obtain connect by connection factory
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("FirstTopic");
			//create message list  创建消息队列
			messageProducer = session.createProducer(destination);
			//create message producer
			sendMessage(session,messageProducer);
			session.commit();
			
		}catch(JMSException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//way to send message
	public static void sendMessage(Session session, MessageProducer messageProducer) {
		// TODO Auto-generated method stub
		for(int i = 0; i < JMSProducer.SENDNUM; i++) {
			try {
				TextMessage message = session.createTextMessage("Acyive MQ Send Message" + i);
				System.out.println("publish message: Active MQ Send Message");
				messageProducer.send(message);
			}catch(JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
//https://blog.csdn.net/qq_26504875/article/details/51802316
