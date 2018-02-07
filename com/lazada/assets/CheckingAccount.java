package com.lazada.assets;

import java.io.Serializable;

public class CheckingAccount extends Account implements Serializable
{
	private static final long serialVersionUID = 2L;
	private static final double TRANSACTION_FEE = 0.5;
	
	public CheckingAccount(String name, double startingBalance)
	{
		//TRANSACTION_FEE = 25;
		super(name,startingBalance);
	}
	
	public boolean withdraw(double amount)
	{
		if(this.getBalance() - (amount + TRANSACTION_FEE) >= 0)
		{
			this.updateBalance(0-(amount + TRANSACTION_FEE));
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deposit(double amount)
	{
		if(this.getBalance()+(amount - TRANSACTION_FEE) >= 0)
		{
			this.updateBalance(amount - TRANSACTION_FEE);
			return true;
		}
		return false;
	}
	
//	public void updateBalance(double amount)
//	{
//		//Own implementation
//	}
	
}








