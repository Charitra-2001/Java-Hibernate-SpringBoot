package com.charitra.SpringMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.charitra.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	@GetMapping("aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		
		List<Alien> aliens = repo.findAll();
		
		return aliens;
	}
	
	@GetMapping("alien/{id}")
	@ResponseBody
	public Alien getAlien(@PathVariable("id") int id) {
		
		Alien alien = repo.findById(id).orElse(new Alien(0,""));
		
		return alien;
	}
	
	@PostMapping("alien")
	public Alien addAlien(@RequestBody Alien a)
	{
		System.out.println(a);
		repo.save(a);
		return a;
	}
}
