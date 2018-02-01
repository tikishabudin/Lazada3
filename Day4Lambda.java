

interface IFunc
{
	int doSomething(int param,int param2);
}

interface Hyvaa<R extends String,U,V>
{
	R paivaa (U param1, V param2);
}

public class Day4Lambda 
{
	public IFunc process()
	{
		IFunc refer = (x,y)->x+y;
		return refer;
	}
	
	public static String SomethingElse (int x, float y)
	{
		System.out.println("Function successfully called.....");
		return "returned";
	}
	
	public static void main(String[] args) 
	{
		Hyvaa<String,Integer,Float> referhyvaa = Day4Lambda::SomethingElse;
		referhyvaa.paivaa(2, 2.5f);
		System.out.println("Hyvaa is inside: " + referhyvaa.getClass().getSimpleName());
		
		IFunc external = new Day4Lambda().process();
		//external.doSomething(5);
		System.out.println(external.getClass().getSimpleName());
		
	}

}






