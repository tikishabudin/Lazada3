package com.lazada.assets;

//ABSTRACT RULES
//1) A class with even 1 abstract method MUST be declared abstract
//2) Abstract classes CANNOT be instantiated
//3) All child classes of an abstract class MUST override ALL abstract methods

public abstract class Account 
{
	private static int runningNumbers = 1;
	
	private int id;
	private String holderName;
	private double balance;
	
	public Account(String holderName, double balance) 
	{
		this.id = runningNumbers++;
		this.holderName = holderName;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}
	
	protected final void updateBalance(double amount)
	{
		this.balance += amount;
	}
	
	public abstract boolean deposit(double amount);
	public abstract boolean withdraw(double amount);
	
}






