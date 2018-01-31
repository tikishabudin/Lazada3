package com.lazada.assets;

public class Parent 
{
	protected String info = "Default Info";
	
	public Parent()
	{
		this(10);
		System.out.println("Default Parent Constructor");
	}
	
	public Parent(int x)
	{
		System.out.println("Overloaded Parent Constructor");
	}
	
	public void doSomething()
	{
		System.out.println("Parent Doing Something");
	}
	
	public void doSomething(int x)
	{
		System.out.println("Parent Doing Something Overloaded");
	}
}





