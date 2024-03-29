package com.charitra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResouces {
	
	@Autowired // With this we dont have to use new to create object of class this keyword automatically find
	// the class and do the action
	AlienRepository repo;
	@GetMapping("/aliens")
	public List<Aliens> getAliens()
	{
		// Jackson dependency is used to convert List into JSON object
		
		List<Aliens> ans = (List<Aliens>)repo.findAll(); // This findAll is an internal function which will
		// find all the query and typecast it in form of list and then return
		return ans;
	}
}
