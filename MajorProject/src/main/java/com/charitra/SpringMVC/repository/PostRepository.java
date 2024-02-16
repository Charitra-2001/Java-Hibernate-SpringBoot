package com.charitra.SpringMVC.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charitra.SpringMVC.Model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

	
	
	
}
