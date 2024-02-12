package com.charitra.DemoHib;

import java.util.*;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	private int rollno;
	private String name;
	private int marks;
	
	// Here we will give the relation of student table with the laptop table
	
//	@OneToOne // It shows that one student will have only one laptop;
//	private Laptop laptop;
//	public Laptop getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
	
//	@OneToMany(mappedBy="student") // It shows that one student can have multiple laptops;
//	/* Here we are mappedBy to tell the table that it is mapped by another table so it do
//	not need to make any other table */
//	private List<Laptop> laptop = new ArrayList<>();
//	
//	public List<Laptop> getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(List<Laptop> laptop) {
//		this.laptop = laptop;
//	}
	
//	@ManyToMany(mappedBy="student") // It shows that one student can have multiple laptops;
	/* Here we are mappedBy to tell the table that it is mapped by another table so it do
	not need to make any other table */
//	private List<Laptop> laptop = new ArrayList<>();
//	
//	public List<Laptop> getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(List<Laptop> laptop) {
//		this.laptop = laptop;
//	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}

}
