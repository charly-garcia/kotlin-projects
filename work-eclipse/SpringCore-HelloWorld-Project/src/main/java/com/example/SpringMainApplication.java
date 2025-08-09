package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.beans.HelloWorld;

public class SpringMainApplication {
	
	public static void main(String[] args) {
		//System.out.println("Hello");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj.getMessage());
	}

}
