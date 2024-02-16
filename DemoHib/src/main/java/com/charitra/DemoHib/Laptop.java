package com.charitra.DemoHib;
import java.util.*;
import javax.persistence.*;

@Entity
public class Laptop {
	 @Id // This is created for Refrence Function in App
	private int lid;
	private String lname;
	
	// Here we making relations with the table of student
	
//	@ManyToOne // It means that multiple laptops can be allocated to one student
//	private Student student;
//	
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	
	@ManyToMany // It means that multiple students can have multiple laptops;
	private List<Student> student=new ArrayList<>();
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	/*@Id
	private int id;
	private int price;
	private String brand;
	
//	@ManyToOne
//	private Alien alien;
//	
//	public Alien getAlien() {
//		return alien;
//	}
//	public void setAlien(Alien alien) {
//		this.alien = alien;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", price=" + price + ", brand=" + brand + "]";
	}
	*/
}
