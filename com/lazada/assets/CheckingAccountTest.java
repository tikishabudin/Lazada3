package com.lazada.assets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckingAccountTest {

	private Account testAcc;
	
	@BeforeClass
	public static void globalSetup()
	{
		System.out.println("Happens before anything");
	}
	
	@Before
	public void setup()
	{
		testAcc = new CheckingAccount("Tiki", 160);
	}
	
	@Test
	public void ifAccountiscreatable() {
		
		org.junit.Assert.assertNotNull(testAcc);
	}

	@Test
	public void testtoseeifthisworks()
	{
		Double x = 5.4;
		org.junit.Assert.assertEquals((Double)5.0, x, 0.9);
		//assertNotEquals(5, x);
	}
	
	@Test
	public void testbalanceismorethan0()
	{
		testAcc.withdraw(19);
		assertTrue(testAcc.getBalance() > 0);
	}
	
	@Test
	public void anotherTest()
	{
//		try {
//			throw new Exception();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		assertThat(testAcc.getBalance(), is(100.0));
	}
	
	@After
	public void cleanUp()
	{
		System.out.println("Test completed");
	}
	
	@AfterClass
	public static void globalCleanUp()
	{
		System.out.println("After everything has been done");
	}
}





