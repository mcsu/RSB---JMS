package fr.efrei.tpjms.service;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ManageService {

	ApplicationContext applicationContext;
	QueueConnectionFactory factory;
	Queue queue;
	QueueConnection connection;
	QueueSession session;
	public ManageService() throws JMSException {
		applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
		factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
		queue = (Queue) applicationContext.getBean("queue");
		// Create a connection. See  https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
		connection = factory.createQueueConnection();
		session = connection.createQueueSession(true, 1);
	}
	public void send() throws JMSException, JSONException {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
		  QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
		
		  Queue queue = (Queue) applicationContext.getBean("queue");
		  
		  // Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
		  QueueConnection connection = factory.createQueueConnection();
		  // Open a session
		  QueueSession session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		  // Start the connection
		  
		  connection.start();
		  // Create a sender
		  QueueSender queueSender = session.createSender(queue);
		  // Create a message
		  
		  
		  
		  String message = "hello world";
		 //JSON测试
		  JSONObject jObject = new JSONObject();
		  jObject.put("id", "2301");
		  jObject.put("plateNumber", "ASDF");
		  TextMessage textMessage = session.createTextMessage();
		  
		  textMessage.setText(jObject.toString());
		  
		  
		  // Send the message
		  queueSender.send(textMessage);
		 
		  // Close the session
		  session.close();
		  // Close the connection
		  connection.close();
		
	}
	
}
