package hasasiki;

import javax.jms.*;

public class Listener implements MessageListener {
	public void onMessage(Message message) {
		try {
			System.out.println("消息订阅者一收到的消息："+((TextMessage) message).getText());
			
		}catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
