package com.charitra;

import java.util.Arrays;
import java.util.List;

public class Transaction {
	public static final List<String>acceptedCurrency = Arrays.asList("USD","Ruppee");
	
	public static double validateTransaction(String currency,double amount)
	{
		if(CurrencyIsAccepted(currency) && AmountIsValid(amount))
		{
			return amount;
		}
		return -1;
	}
	
	
	public static boolean CurrencyIsAccepted(String currency)
	{
		if(!acceptedCurrency.contains(currency))
		{
			throw new IllegalArgumentException("Currency "+currency+" Not found");
		}
		return true;
	}
	
	
	public static boolean AmountIsValid(double amount)
	{
		if(amount<0)throw new InvalidTransactionAmount("Amount is less");
		return true;
	}
}
