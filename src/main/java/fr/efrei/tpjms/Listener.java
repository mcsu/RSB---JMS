package fr.efrei.tpjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import fr.efrei.tpjms.service.RentService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;




public class Listener implements MessageListener {
	public void onMessage(Message message) {
		
		TextMessage textMsg = (TextMessage) message;
		JSONObject jObject = new JSONObject();
		try {
			jObject = JSONObject.fromObject(textMsg.getText());
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.print("JMS监听-By listener");  
		System.out.println("消息内容是："+ jObject.get("content") );
		RentService.result = jObject.get("content").toString();
		
	}
	
}
