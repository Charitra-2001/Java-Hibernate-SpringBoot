package com.charitra.SpringMVC.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.charitra.SpringMVC.Model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepositoryImp implements SearchRepository{
	
	@Autowired
	MongoClient client;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public List<Post>findBySearch(String name)
	{
		final List<Post> posts = new ArrayList<Post>();
		MongoDatabase database = client.getDatabase("Charitra");
		MongoCollection<org.bson.Document> collection = database.getCollection("JobPost");
		AggregateIterable<org.bson.Document> result = collection.aggregate(Arrays.asList(new org.bson.Document("$search", 
		    new org.bson.Document("index", "default")
		            .append("text", 
		    new org.bson.Document("query", name)
		                .append("path", Arrays.asList("techs", "desc", "profile")))), 
		    new org.bson.Document("$sort", 
		    new org.bson.Document("exp", 1L)), 
		    new org.bson.Document("$limit", 5L)));
		
		
		result.forEach(doc->posts.add(converter.read(Post.class,doc)));
		return posts;
	}
}
