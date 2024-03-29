package com.charitra.DemoReact.DemoReact1;

import java.sql.SQLException;
import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/*
 * Now If we want to make our own REST API
 * 1. First we want to define the path by which that API will be called
 */
@Path("aliens")
public class AlienResouces{
	
	
	/*
	 * 2.Then we have to make a function that will return the data after performing
	 * some functions
	 * 
	 * 3. Then we have to set the request type of that function GET,POST
	 * 
	 * 4. Then we have to tell that what will be the type of output it will return String,XML,JSON
	 * 
	 */
	
		AlienRepository repo = new AlienRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aliens> getAliens() throws Exception
	{
		System.out.println("Hello I am here");
		
		List<Aliens> ans =  repo.getAliens();
		if(ans.isEmpty())
		{
			return null;
		}
		return ans;
		
	}
	@GET  // This is used to get the data from the database
	@Path("alien/{id}") // Here we are {id} so that the id acts like placeholder for any id comes at that place
	public Aliens getAlien(@PathParam("id") int id) throws SQLException// Here pathparam is taking id from upward and storing it in ind id
	{
		System.out.println("Hello");
		
		return repo.getAlien(id);
		
	}
	
	@POST // This is used to create the data in the database 
	@Path("alien")
	// Here we can write @Consumes(MediaType.APPLICATION_JSON) to make the server consume the JSON type of data
	public Aliens CreateAlien(Aliens a1) throws Exception
	{
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	@PUT // Put is used for updating the existing data in the database
	@Path("alien")
	// Here we can write @Consumes(MediaType.APPLICATION_JSON) to make the server consume the JSON type of data
	public Aliens UpdateAlien(Aliens a1) throws Exception
	{
		System.out.println(a1);
		
		if(repo.getAlien(a1.getId())==null)
		{
			repo.create(a1);
		}
		else
		repo.update(a1);
		
		return a1;
	}
	
	
	@DELETE
	@Path("alien/{id}")
	public Aliens KillAlien(@PathParam("id") int id) throws Exception
	{
		Aliens a = new Aliens();
		if(repo.getAlien(id)==null)
		{}
		else
		{
			repo.delete(id);
		}
		return a;
	}
}
