package com.charitra.DemoHib;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	
	static void Introduction() throws Exception {
		Alien obj = new Alien();
		// As Session is an interface we can't create object of it so for that we need
		// session factory
		// As SessionFactory is also a interface we use configuration
		// After this we have to make hibernate.cj.xml file;
		// We need to change the dialect in XML will of hibernate.cfg.xml
		// Remove the name="" in session factory in XML file
		// We need to create a property in XML to provide the data to table from JDBC

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction(); // We need to follow ACID properties when we insert data in SQL for that
												// we
		// need to use and commit transaction

		// Now we have to insert the values in the database;
//		    	obj.setAid(102);
//				obj.setAname("Rahul");
//				obj.setAcolor("Blue");
//		    	s.save(obj);

		// Now we have to fetch the value from the database;

//		    	obj = (Alien)s.get(Alien.class, 102);
//		    	System.out.println(obj.getAname());

		// Now we are going to save object of object class
		// Alien class will contain the object of the AlienName class

		AlienName an = new AlienName();
		an.setFname("Vipin");
		an.setMname("Charitra");
		an.setLname("Mehlawat");

		obj.setAid(101);
		obj.setAcolor("Beige");
		obj.setAname(an);
		s.save(obj);
		tx.commit();
	}
	
	static void RelationShip_Method() throws Exception
	{
//		Laptop lp = new Laptop();  // Uncomment the method from the Laptop class to make this work
//		lp.setLid(101);
//		lp.setLname("Dell");
//		
//		Student st = new Student();
//		st.setRollno(1);
//		st.setName("Charitra");
//		st.setMarks(56);
//		st.getLaptop().add(lp); // As it will give error if we do not specify the relationship in their classes
//		// If we are not specifying the relation in all the class with whom we are making the relation
//		// Then it will create the another table which is not much required
//		
//		lp.getStudent().add(st);
//		
//		Configuration cg = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
//		SessionFactory sf = cg.buildSessionFactory();
//		Session s = sf.openSession();
//		
//		s.beginTransaction();
//		
//		
//		s.save(lp);
//		s.save(st);
//		
//		s.getTransaction().commit();
	}
	
	static void Fetch_Data_from_table() throws Exception
	{
		Configuration cg = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = cg.buildSessionFactory();
		Session s = sf.openSession();
		
//		Alien a = new Alien();
//		AlienName an = new AlienName();
//		an.setFname("Chintu");
//		an.setLname("Pintu");
//		an.setMname("Monu");
//		a.setAid(3);
//		a.setAname(an);
//		a.setAcolor("Blue");
//		
//		Laptop lp = new Laptop();
//		lp.setId(104);
//		lp.setBrand("IBall");
//		lp.setPrice(5000);
//		lp.setAlien(a);
		s.beginTransaction();
		
		
		Alien a = s.get(Alien.class, 3);
		// Here it will only give the result without the collection of laptop brands
		System.out.println(a.getAname().getMname());
		
		// If we take the Collection then only it will fire the query for collection in database this is called Lazy Mapping
		// To not make this happen we will use FetchType.Eager in the Alien Class where the collection is made
		// It will then use left outer join to fetch the data where Alien.id = Laptop.AlienID
//		Collection<Laptop>lp = a.getLaptop();
//		for(Laptop l:lp)
//		{
//			System.out.println(l);
//		}
//		s.getTransaction().commit();
	}
	
	static void Hibernate_Cache()
	{
		Configuration cg = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf = cg.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Alien x = s.get(Alien.class, 1);
		System.out.println(x);
		
		s.getTransaction().commit();
		s.close();
		// Here we are seeing that when we make two different session the same query will be fired twice
		// To solve above situation we need 2nd Level Cache 
		/* To implement 2nd level Cache we have made changes in pom.xml files by
		 * including the dependency and hibernate.xml file
		 */
		Session s1 = sf.openSession();
		s1.beginTransaction();
		Alien y = s1.get(Alien.class, 1);
		System.out.println(y);
		s1.getTransaction().commit();
		
		/*
		 * To use query in cache we need to make change in hibernate.xml file and
		 * to set the query class cacheable we will use
		 * q.setCacheable(true)
		 */
	}
	
	static void HQL() throws Exception
	{
		Configuration cg = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = cg.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
//		Random r = new Random();
//		for(int i=1;i<=50;i++)
//		{
//			Student s1 = new Student();
//			s1.setRollno(i);
//			s1.setName("Name "+i);
//			s1.setMarks(r.nextInt(100));
//			s.save(s1);
//		}
//		
		// Now we have inserted the data and we will use HQL to fetch the data
		
//		List<Student> ans = s.createQuery("from Student").getResultList(); 
//		/* 
//		 * In this the from student is written in HQL and is similar to select * from Student of SQL
//		 */
		
		
		/*
		 * By this way we can use SQL query in the hibernate 
		 */
//		List<Object[]> ans  = (List<Object[]>) s.createQuery("select rollno,name from Student where marks>60").getResultList();
//		for(Object[] x:ans)
//		{
//			System.out.println(x[0]+" "+x[1]);
//		}
		
		/*
		 *  When we know that we are going to get one object in output then we will Object
		 *  to get output or the data type in which the result will come instead of List 
		 */
		
//		Object ans = (Object)s.createQuery("Select sum(marks) from Student").uniqueResult();
//		System.out.println(ans);
//		
		/*
		 * In JDBC we worked with prepared statements so if we want to use them in HQL we will use
		 * :(name of the parametre by which you will assign the value) 
		 * 
		 * TypeQuery is used instead of query
		 */
		
//		TypedQuery ans = s.createQuery("Select sum(marks) from Student where marks > :b");
//		int b = 60;
//		ans.setParameter("b", b);
//		Object a = ans.getSingleResult();
//		System.out.println(a);
//		s.getTransaction().commit();
		
		
		/*
		 * Now we will see how to work with SQL in hibernate
		 */
		
		TypedQuery q = s.createSQLQuery("Select name,marks from Student");
		
		List<Object[]> ans = q.getResultList();
		for(Object[] a:ans)
		{
			System.out.println(a[0]+" "+a[1]);
		}
		
	}

	static void LifeCycle() throws Exception
	{
		Configuration cg = new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf = cg.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Laptop l = new Laptop();
		l.setId(51);
		l.setBrand("Sony");
		l.setPrice(700);
		
		s.save(l);
		/*
		 * As we are writing this after save it does have any effect on database
		 * but as it is now in persistent state then the value in the database will also be changed
		 */
		l.setPrice(650);
		
		s.getTransaction().commit();
		
		/*
		 * As we have evicted the object from the database it will not update the value in the database
		 */
		s.evict(l);
		l.setPrice(9000);
	}
	
	static void GetVsLoad() throws Exception
	{
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		GetVsLoad();
	}
}
