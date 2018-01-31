import java.io.Serializable;

interface Badan
{
	void shakeYouBody();
}

interface Muka extends Badan
{
	static final int num = 0;
	void doSomething(int param);
	String feedMyFace();
	
	String facename = "My Face";
}

class InterfaceDemo implements Muka,Serializable
{

	@Override
	public void doSomething(int param) {
		// TODO Auto-generated method stub
	}

	@Override
	public String feedMyFace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shakeYouBody() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Day3Interfaces 
{

	public static void main(String[] args) 
	{
		final int x = 6;
		final long tiki_contact = 60_12_327_1920L;
		//x++;
		// TODO Auto-generated method stub
		Muka refer = new InterfaceDemo();
		refer.doSomething(10);
		System.out.println(refer.facename);
		refer.feedMyFace();
		
		Muka refer2 = new Muka(){
			
			@Override
			public void doSomething(int param)
			{
				System.out.println(param);
			}
			
			@Override
			public String feedMyFace()
			{
				return "";
			}

			@Override
			public void shakeYouBody() {
				// TODO Auto-generated method stub
				
			}
		};
		
		refer2.doSomething(x);
		
		System.out.println("Classname is: " + refer2.getClass().getSimpleName());
	}

}







