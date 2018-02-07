import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class ClosableObject implements AutoCloseable
{

	@Override
	public void close() throws Exception 
	{
		// TODO Auto-generated method stub
		System.out.println("Object is now closing");
	}
	
}

class CustomAssertionErrorObject
{
	public String msg;
	public CustomAssertionErrorObject(String setMsg)
	{
		this.msg = setMsg;
	}
}

public class Day5TryWithResources 
{
	public static int handleAssertion(CustomAssertionErrorObject obj)
	{
		System.out.println(obj.msg);
		return 10;
	}

	public static void main(String[] args) 
	{
		
		int x = 5;
		assert x>10 : handleAssertion(new CustomAssertionErrorObject("Blah!"));
		
		
		try(
				ClosableObject co = new ClosableObject();
//				FileOutputStream fos = new FileOutputStream("./lalala.data");
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
		) 
		{
			
			throw new Exception();
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Something happened");
		}
		finally
		{
			System.out.println("We're done here!");
		}
	}

}
