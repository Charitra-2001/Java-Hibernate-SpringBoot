package com.charitra.DemoHib;
import java.util.*;
import javax.persistence.*;

@Entity(name="Alien_Table") // This is used to tell that this class object is allowed to store in database
// If we do no use name="", It will create the table by the class name automatically
// @Table(name="Alien_Table") // Here if we do not want to change the entity name and only want to change the 
// table name, we will use @Table
@Cacheable
@org.hibernate.annotations.Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY)
// Not all classes and entities are allowed to cache so for that we need to use these annotations
// And we also have to specify the permissions we want to give to the cache
public class Alien {

	@Id // This will specify that the table is having primary key as aid
	private int aid;
	//@Column(name="Name")// Here by using this we can make the column name as the Name rather than aname
	private AlienName aname;
	
	// @Transient ( If we use this we will not get this column in the table )
	private String acolor;
	
//	@OneToMany(mappedBy="alien", fetch = FetchType.EAGER) // Here we are writing eager so that the collection will also be included rather then its calling function
//	private Collection<Laptop>laptop = new ArrayList<>();
//
//	public Collection<Laptop> getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(Collection<Laptop> laptop) {
//		this.laptop = laptop;
//	}
//
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

//	public String getAname() {  // We used this when we only take one part of the name
//		return aname;
//	}
//
//	public void setAname(String aname) {
//		this.aname = aname;
//	}
	
	
	public String getAcolor() {
		return acolor;
	}

	public AlienName getAname() {
		return aname;
	}

	public void setAname(AlienName aname) {
		this.aname = aname;
	}

	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", acolor=" + acolor + "]";
	}
	
}
