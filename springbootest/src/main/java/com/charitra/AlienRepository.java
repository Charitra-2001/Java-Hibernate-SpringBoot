package com.charitra;

import org.springframework.data.repository.CrudRepository;

public interface AlienRepository extends CrudRepository<Aliens,Integer> {
	
	// Here in crud first we have to mention that with which class we are working with and then we have to specify the primary key datatype
	

}