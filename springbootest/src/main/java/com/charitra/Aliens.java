package com.charitra;

import jakarta.persistence.*;
import jakarta.persistence.Id;

// Here we have to tell that the object will be converted in XML format

@Entity
@Table(name="alien")
public class Aliens {
	
	@Id
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private int points;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Aliens [id=" + id + ", name=" + name + ", points=" + points + "]";
	}
}
