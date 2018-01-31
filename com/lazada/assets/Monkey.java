package com.lazada.assets;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Monkey 
{
	private String name;
	int bananas; //default access
	public Monkey[] children;
	List<Hairyfur> hairColl = new ArrayList<>();
	
	public class Hairyfur
	{
		public double length;
		public int color;
		
		public String whoDoesthehairbelongto(Monkey o)
		{
			return o.name;
		}
	}
	
	public void growHair()
	{
		hairColl.add(new Hairyfur());
	}
	
	public Monkey()
	{
		System.out.println("Monkey default constructor");
		this.name = "John Doe";
	}
	
	public Monkey(String name)
	{
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int eating(String param, int x, boolean y)
	{
		System.out.println(param + " is now eating....");
		return 1;
		//Return rules
		//1) return types and return values MUST be consistent
		//2) a return statement ends the method / function
		//3) Can only return 1 value / object
	}
	
	public void eating(String...strings )
	{
		//System.out.println("Eating with no Params");
		for(String item: strings)
			System.out.println(item);
	}
	
	public void eating(int x)
	{
		System.out.println("Eating with 1 int Param");
	}
	
	public void eating(int x, int y)
	{
		System.out.println("Eating with 2 int Params");
	}
	
	public void eating(float x)
	{
		System.out.println("Eating with 1 float Params");
	}
}










