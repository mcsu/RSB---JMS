package fr.efrei.tpjms.service;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;

import org.junit.experimental.theories.Theories;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.efrei.tpjms.Listener;

@Service
public class RentService {

	public static String result = "u";

	static public String getAll()  {
		// TODO Auto-generated method stub
		return result;
		
	}
}
