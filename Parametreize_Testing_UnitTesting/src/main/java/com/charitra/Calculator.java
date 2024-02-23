package com.charitra;

public class Calculator {
	private int satScore;
	
	public void calculateScore(int a,int b)
	{
		if(a<0||b<0||a>100||b>100)
		{
			satScore = -1;
		}
		else {
			satScore = a*b;
		}
	}
	
	public int getSatScore() {
		return satScore;
	}
}
