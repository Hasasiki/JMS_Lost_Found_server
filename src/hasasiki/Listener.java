package hasasiki;

import javax.jms.*;

public class Listener implements MessageListener {
	public void onMessage(Message message) {
		try {
			System.out.println("The subcriber received a message£º"+((TextMessage) message).getText());
			
		}catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
