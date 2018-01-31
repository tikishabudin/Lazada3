package com.lazada.assets;

public class GChild extends Child 
{
	public GChild()
	{
		System.out.println("Grand Child Default Constructor");
	}
	
	@Override
	public void doSomething()
	{
		super.doSomething();
		System.out.println("Grand child doing something");
	}
}
