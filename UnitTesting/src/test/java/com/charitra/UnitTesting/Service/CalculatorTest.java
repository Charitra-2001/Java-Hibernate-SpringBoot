package com.charitra.UnitTesting.Service;
//
//import org.junit.jupiter.api.Test;
//
//import org.junit.*;
//
//
//public class CalculatorTest {
//	
//	@Test
//	public void addTest()
//	{
//		int sum = Calculator.add(2, 4);
//		int exp = 1;
//		Assert.assertEquals(exp,sum);
//	}
//	
//	@Test 
//	public void mulTest()
//	{
//		int mul = Calculator.mul(1,2);
//		int exp = 2;
//		Assert.assertEquals(exp, mul);
//	}
//}

		/* The code written Above is for Junit 4*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest
{
	@Test
	public void addTest() {
		int a = Calculator.add(12, 12);
		int b = 2;
		Assertions.assertEquals(b,a,"Test NNN");
	}
}
