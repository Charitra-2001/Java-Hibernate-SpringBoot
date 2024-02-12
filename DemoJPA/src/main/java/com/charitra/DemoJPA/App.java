package com.charitra.DemoJPA;

import javax.persistence.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Using JPA if you want to switch from hibernate to any other dependency you just have to change one dependency
    	// Everything else will remain same
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	// Here in JPA we make one resourc e file by which we can operate using multiple frameworks like hibernate with some common
    	// Functions so if we ever change the framework then code conversion will not be tough
    	Alien a = em.find(Alien.class, 1);
    	System.out.println(a);
    	
    	// To save the data in database using JPA
    	// To save the data in database we first start the transaction
    	Alien b = new Alien();
    	b.setId(5);
    	b.setName("Mayank");
    	b.setTech("Linux");
    	
    	em.getTransaction().begin();
    	em.persist(b);
    	em.getTransaction().commit();
    }
}
