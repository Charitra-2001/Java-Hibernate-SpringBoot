package com.charitra.SpringMVC;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.charitra.model.Alien;

// Here the JPARepository needs two parameter one is the class and other is the
// Datatype of the primary key
@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer> {

	// List<Alien> findByAname(String name);
	//List<Alien> findByAnameOrderByAidDesc(String name); // By this the outputs wil be sorted based on Aid Desc
	
	@Query("from Alien where aname=:aname")
	List<Alien> find(@Param("aname") String name);
	
}