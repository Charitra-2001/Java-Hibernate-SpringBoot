package com.charitra.SpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charitra.SpringMVC.Model.Post;
import com.charitra.SpringMVC.repository.PostRepository;
import com.charitra.SpringMVC.repository.SearchRepository;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PostController {
	
	@Autowired
	PostRepository pr;
	
	@Autowired
	SearchRepository sr;
	
	@GetMapping("/allPosts")
	@CrossOrigin
	public List<Post> getAllJobs()
	{
		List<Post> ans = pr.findAll();
		
		System.out.println(ans.size());
		return ans;
	}
	
	
	@GetMapping("/posts/{name}")
	@CrossOrigin
	public List<Post> search(@PathVariable("name")String name){
		return sr.findBySearch(name);
	}
	
	
	
	@PostMapping("/post")
	@CrossOrigin
	public void postdata(@RequestBody Post p){
		pr.save(p);
	}
}
