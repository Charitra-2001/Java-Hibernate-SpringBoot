package com.charitra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.charitra.model.Alien;
import com.charitra.repo.AlienRepo;

@SpringBootApplication
public class SpringJdbCdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbCdemoApplication.class, args);
		Alien a = context.getBean(Alien.class);
		a.setId(100);
		a.setName("Charitra");
		a.setTech("Java");
		
		AlienRepo ar = context.getBean(AlienRepo.class);
		ar.save(a);
		
		System.out.println(ar.findAll());
		
	}

}
