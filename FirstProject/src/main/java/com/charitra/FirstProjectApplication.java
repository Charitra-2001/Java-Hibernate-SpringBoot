package com.charitra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FirstProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
		/* Here the .run is extending the interface of ApplicationContext so this will give the object of 
		 * Application context to you */
		
		Alien obj = context.getBean(Alien.class);// In this the getBeans() method will be responsible for creating the object of the Alien class
		obj.code();
		
	}

}
