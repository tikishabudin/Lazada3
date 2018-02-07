package com.lazada.assets;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CheckingAccountTestParametrized {

	private Account testAcc;
	private double startingBalance;
	private double testAmount;
	private String testName;
	
	public CheckingAccountTestParametrized(double startBalance, 
											double testAmount, 
											String testName) 
	{
		this.startingBalance = startBalance;
		this.testAmount = testAmount;
		this.testName = testName;
	}
	
	@Before
	public void setup()
	{
		this.testAcc = new CheckingAccount(this.testName, this.startingBalance);
	}
	
	@Test
	public void test() {
		testAcc.withdraw(testAmount);
		assertTrue(testAmount > 0);
	}
	
	@Test
	public void testNameNotEmpty()
	{
		//assertNotEquals("", testAcc.getHolderName());
		try
		{
			if(this.testAcc.getHolderName().equals(""))
			{
				throw new Exception();
			}	
		}
		catch(Exception err)
		{
			assertTrue(false);
		}
	}

	@Parameterized.Parameters
	public static Collection<Object[]> scenarios()
	{
		return Arrays.asList(new Object[][] {
			{125,100,"Peron a"},
			{1000,1500,"Person B"},
			{450,100,"Someone"},
			{22,197,""},
			{2,29,"However you love"},
			{100000,1,"Tiki"}
		});
	}
	
}





