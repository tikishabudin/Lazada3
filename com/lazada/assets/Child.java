package com.lazada.assets;

public class Child extends Parent
{
	public Child()
	{
		this(5);
		System.out.println("Default Child Constructor");
	}
	
	public Child(int x)
	{
		super(5);
		System.out.println("Overloaded Child Constructor");
	}
	
	public void doSomething()
	{
		System.out.println("Child Doing Something");
		super.doSomething();
	}
	
	public void play()
	{
		System.out.println(this.info);
	}
}
