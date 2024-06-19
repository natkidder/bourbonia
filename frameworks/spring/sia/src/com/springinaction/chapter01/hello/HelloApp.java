package com.springinaction.chapter01.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp  {
	public static void main(String[] args)  {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("hello.xml"));

		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");

		greetingService.sayGreeting();
	}
}
