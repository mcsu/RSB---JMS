package fr.efrei.tpjms.web;



import javax.jms.JMSException;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.tpjms.service.RentService;

import fr.efrei.tpjms.service.ManageService;

@RestController
public class ManageController {

	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)  
	@ResponseBody
	public String AddTest() throws JMSException, JSONException{
		ManageService mService = new ManageService();
		mService.send();
		return "Success";
	}
	
	@RequestMapping(value = "/voiture/{plateNumber}", method = RequestMethod.PUT)
	 @ResponseStatus(HttpStatus.OK)
	 public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{
		 RentService rs = new RentService();
		 //rs.rent(plateNumber);
	 } 
	
	@RequestMapping(value = "/voitures", method = RequestMethod.GET)
	 @ResponseStatus(HttpStatus.OK)
	 public String showAll() {
		 return "showAll";
		 //rs.rent(plateNumber);
	 } 
}
