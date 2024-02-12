package com.charitra.SpringDemo;

public class Alien {
	private Laptop laptop;
	public Laptop getLap() {
		return laptop;
	}
	public void setLap(Laptop lap) {
		this.laptop = lap;
	}
	public void code() {
		laptop.compile();
	}
}
