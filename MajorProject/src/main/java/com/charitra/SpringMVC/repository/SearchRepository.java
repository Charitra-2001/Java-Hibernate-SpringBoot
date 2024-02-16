package com.charitra.SpringMVC.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.charitra.SpringMVC.Model.Post;

@Component
public interface SearchRepository {
	List<Post>findBySearch(String name);
}
