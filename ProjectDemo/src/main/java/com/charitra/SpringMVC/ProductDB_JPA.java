package com.charitra.SpringMVC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB_JPA extends JpaRepository<Product,Integer> {

	Product getByName(String name);

}
