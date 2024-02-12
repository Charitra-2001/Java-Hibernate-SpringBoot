package com.charitra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // By adding this now the spring knows that it is responsible for making the object of this class;
public class Alien {

	@Autowired
	Laptop lap;
	public void code()
	{
		lap.compile();
	}
}
