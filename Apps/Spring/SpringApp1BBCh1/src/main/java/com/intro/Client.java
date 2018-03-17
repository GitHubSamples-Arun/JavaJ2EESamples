package com.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		Door door =  context.getBean("doorBeanWithSoundAlarm",Door.class);
		door.open();
		door.close();
		
		door =  context.getBean("doorBeanWithVisualAlarm",Door.class);
		door.open();
		door.close();
	}
}
