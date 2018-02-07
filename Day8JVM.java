import java.util.Scanner;

class GarbageDemo
{
	public GarbageDemo()
	{
		System.out.println("Object Created");
	}
	
	@Override
	public void finalize()
	{
		System.out.println("Object Destroyed");
		try 
		{
			super.finalize();
		} 
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Day8JVM 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GarbageDemo obj = new GarbageDemo();
		obj = null;
		System.gc();
		Scanner uin = new Scanner(System.in);
		uin.nextLine();
		uin.close();
	}

}






