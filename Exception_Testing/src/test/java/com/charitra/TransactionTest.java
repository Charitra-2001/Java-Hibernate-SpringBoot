package com.charitra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {
	
	@Test
	public void ValidateTransaction()
	{
		Transaction.validateTransaction("USD", -10);
	}
}
