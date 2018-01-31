import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

class CustomException extends Exception
{
	public CustomException()
	{
		super("Some super duper customs screw up happened");
	}
}

public class Day3Exceptions
{
	
	public static void doSomething() throws Error
	{
		//throw new CustomException();
	}

	public static void process() throws Exception
	{
		//do something
		//throw new Exception();
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner uin = new Scanner(System.in);
		
		doSomething();
		
		
		try {
			process();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TRY/CATCH RULES
		//1) Try blocks MUST be accompanied by at least a catch block or finally
		//2) catch blocks MUST be arranged from most specific to least specific
		//3) No code in between blocks
		//4) Finally blocks are always guaranteed to run
		
		
		try
		{
			System.out.println("Enter a number:");
			int x = Integer.parseInt(uin.nextLine());
			System.out.println("Enter another number:");
			int y = Integer.parseInt(uin.nextLine());
			
			int z = x / y;
			System.out.println("Result is: " + z);
		}
		//System.out.println("Doing someting here..");
		catch(NumberFormatException err)
		{
			System.out.println("I said number ding-dong!");
			try
			{
				throw new CustomException();
			}
			catch(Exception mess)
			{
				System.out.println(mess);
			}
		}
		catch(ArithmeticException err)
		{
			System.out.println("Apparently your maych skills are lacking");
		}
		catch(Throwable err)
		{
			System.out.println("Something happened. We're not sure what");
			System.out.println("Message: " + err.getMessage());
		}
		finally
		{
			System.out.println("Will run whether there is an exception or not");
			uin.close();
		}
		
		System.out.println("Continuing app....");
		
		
	}

}








