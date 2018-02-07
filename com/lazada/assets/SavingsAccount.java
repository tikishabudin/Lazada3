package com.lazada.assets;

import java.io.Serializable;

//class SuperSavingsAccount extends SavingsAccount
//{
//	
//}

public final class SavingsAccount extends Account implements Serializable
{
	private static final long serialVersionUID = 3L;

	public SavingsAccount(String name, double startingBalance)
	{
		super(name,startingBalance);
	}
	
	public boolean withdraw(double amount)
	{
		//int x = -50;
		
		if(this.getBalance() - amount >= 0)
		{
			this.updateBalance(0-amount);
			return true;
		}
		return false;
	}
	
	public boolean deposit(double amount)
	{
		if(amount >= 1)
		{
			this.updateBalance(amount + 0.5);
		}
		else
		{
			this.updateBalance(amount);
		}
		return true;
	}
}












