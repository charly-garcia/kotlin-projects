package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import com.example.beans.Customer;
import com.example.beans.EmailService;
import com.example.beans.SMSService;

public class SpringMainApplication {
	
	public static void main(String[] args) {
		//System.out.println("Hello");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
		/*Customer baseCustomer = (Customer) context.getBean("baseCustomer");
		System.out.println(baseCustomer);
		
		Customer customer = (Customer) context.getBean("customer");
		System.out.println(customer);*/
		
		EmailService emailService = (EmailService) context.getBean("emailService");
		emailService.sendMessage("Hello Via Email!");
		
		SMSService smsService = (SMSService) context.getBean("smsService");
		smsService.sendMessage("Hello Via SMS!");
		
	}

}
