package hasasiki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;  

public class JMSProducer {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL;
	//link to default user name,password and broker bind url

	private static int num;
	//Number of message
	private static String fileName = "D:\\workarea\\menu.txt";
	//file name
	static List<String> list = new ArrayList<String>();
	//private static String[] List;
	
	public static void main(String[] args) throws IOException {
		ConnectionFactory connectionFactory;
		//get a connection to factory
		Connection connection = null;
		//connect
		Session session;
		//process of conversation, send or receive message
		Destination destination;
		//destination of message
		MessageProducer messageProducer;
		//message producer
		
		// --> Instantiation connection factory to ActiveMQ
		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);
		
		try {
			connection = connectionFactory.createConnection();
			//obtain connect by connection factory
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			//boolean transacted, auto acknowledge
			destination = session.createTopic("FirstTopic");
			//create message list
			messageProducer = session.createProducer(destination);
			//create message producer
			sendMessage(session,messageProducer);
			session.commit();
			//the way to start a transaction is session.commit
			
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
	
	public static void sendMessage(Session session, MessageProducer messageProducer) throws IOException {
		JMSProducer.readFileByLines(fileName);
		for(int i =0; i <num ; i++ ) {
			try {
				TextMessage message = session.createTextMessage(list.get(i));
				//stored message
				Test.savechatlog(list.get(i));
				System.out.println("publish message: Active MQ Send Message");
				messageProducer.send(message);
			}
	    catch(JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            //System.out.println("read line");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;
            // read a line one time, till null
            while ((tempString = reader.readLine()) != null) {
                //System.out.println(tempString);
            	list.add(tempString);
                line++;
            }
            num = line;
            // back the number to loop
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e1) {
                }
            }
        }
    }
}
//http://localhost:8161/admin

