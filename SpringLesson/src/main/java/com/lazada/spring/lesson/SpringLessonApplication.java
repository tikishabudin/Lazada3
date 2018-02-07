package com.lazada.spring.lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLessonApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(SpringLessonApplication.class, args);
		PlayerCharacter myChar = app.getBean(PlayerCharacter.class);
		//PlayerCharacter yourChar = app.getBean(PlayerCharacter.class);
		//app.getBean(arg0, arg1);
		//myChar.speak();
		
		System.out.println("MyChar: " + myChar);
		System.out.println("MyChar type:" + myChar.playerMajor);
		myChar = app.getBean(PlayerCharacter.class); 
		System.out.println("MyChar minor: " + myChar.playerMajor);
		
//		System.out.println("YourChar: " + yourChar);
//		System.out.println("YourChar type:" + yourChar.playerMajor);
	}
}
