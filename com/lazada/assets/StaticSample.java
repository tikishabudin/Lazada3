package com.lazada.assets;

public class StaticSample 
{
	public static int num = 0;
	private static int numObj = 0;
	
	private String id;
	private int data;
	
	public StaticSample()
	{
		numObj++;
	}
	
	public static void showNum()
	{
		System.out.println("Objects currently alive: " + numObj);
		//System.out.println(this.id);
	}
	
	public static class Builder
	{
		public StaticSample create()
		{
			System.out.println("Do whatever");
			StaticSample temp = new StaticSample();
			temp.id = "007";
			temp.data = 0b101010101011110100100101010;
			return temp;
		}
	}
}
