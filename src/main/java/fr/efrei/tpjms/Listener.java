package fr.efrei.tpjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import net.sf.json.JSONObject;

public class Listener implements MessageListener {
	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		String result = message.toString();
		System.out.println(result);
		JSONObject jObject = new JSONObject();
		jObject.put("name", "fail");
		try {
			jObject = JSONObject.fromObject(textMsg.getText());
			System.out.println("aaaa"+jObject);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     System.out.print("JMS监听-By listener");  
	    
//	        		JSONObject json_test = 
	    
		System.out.println("消息内容是："+ jObject.get("plateNumber") );
		
	}
}
