package com.lazada.assets;

public class SampleUtility 
{
	private SampleUtility single;
	
	private SampleUtility()
	{
		this.single = new SampleUtility();
	}
	
	public SampleUtility getInstance()
	{
		return this.single;
	}
	
	public static void dothis() {}
	
	public static void dothat() {}
}
