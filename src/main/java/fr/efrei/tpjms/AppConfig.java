package fr.efrei.tpjms;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.efrei.tpjms.service.RentService;



public class AppConfig {

	public  AppConfig() throws JMSException {
		// TODO Auto-generated constructor stub
		System.out.println("spring容器启动初始化。。。");
		System.out.println("JMS监听器启动");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
		QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
		Queue queue = (Queue) applicationContext.getBean("queueJpa");
		QueueConnection connection = factory.createQueueConnection();
		QueueSession session = connection.createQueueSession(true, 1);
		connection.start();
		MessageConsumer messageConsumer = session.createConsumer(queue);
		messageConsumer.setMessageListener(new Listener());
		RentService rService = new RentService();
	}
}
