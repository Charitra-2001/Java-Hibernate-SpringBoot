package com.charitra;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

public class CalculatorTest {

	
	public static Object[] testValues() {
		return new Object[] {
				new Object[] {50,50,2500},
				new Object[] {-10,50,1},
				new Object[] {150,150,-1}
		};
	}
	
	@ParameterizedTest
	@MethodSource("testValues")
	public void CalculatorTesting(int a,int b,int c)
	{
		Calculator C = new Calculator();
		C.calculateScore(a,b);
		assertEquals(c,C.getSatScore());
	}
}
