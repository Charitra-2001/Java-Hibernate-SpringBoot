package com.charitra;

public class InvalidTransactionAmount extends RuntimeException {
	
	public InvalidTransactionAmount(String message)
	{
		super(message);
	}
}
