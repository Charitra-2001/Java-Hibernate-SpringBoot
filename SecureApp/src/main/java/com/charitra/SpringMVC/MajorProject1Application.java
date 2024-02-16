package com.charitra.SpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages={
"com.charitra.SpringMVC"})
public class MajorProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MajorProject1Application.class, args);
	}

}
