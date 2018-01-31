import com.lazada.assets.Monkey;
import com.lazada.assets.Monkey.Hairyfur;

public class Day2ClassBasics 
{
	
	public static void doSomething(int x)
	{
		x += 3;
	}
	
	public static void doSomething(Monkey obj, String newName)
	{
		obj.setName(newName);
	}

	public static void main(String[] args) 
	{
		Monkey newMonkey = new Monkey();
		Hairyfur fuzz = newMonkey.new Hairyfur();
		
		newMonkey = null;
		
		fuzz.color = 0xff00ff;
		System.out.println(fuzz.color);
		
		System.out.println(newMonkey.getName());
		
		Monkey.Hairyfur refer = new Monkey().new Hairyfur();
		
		// TODO Auto-generated method stub
		Monkey sample = new Monkey("Whatever");
		int original = 5;
		
		doSomething(original);
		System.out.println(original);
		
		doSomething(sample, "Helena");
		
		System.out.println(sample.getName());
		
//		Monkey tiki = new Monkey("Tiki");
//		Monkey alex = new Monkey("Alex");
//		Monkey sumith = new Monkey("Sumith");
//		
//		Monkey tikriti = tiki;
//		alex = null;
//		tiki = null;
//		tiki = new Monkey("Somebody else");
//		tiki.setName("Tiki the Great");
//		
//		System.out.println(tiki.getName());
//		System.out.println(tikriti.getName());
//		
//		//tiki.bananas = 10;
//		tiki.setName("Tiki");
//		
//		//alex.bananas = 20;
//		alex.setName("Alex");
//		
//		System.out.println(alex.getName());
//		System.out.println(tiki.getName());
//		
//		String somebody = "John Doe";
		
		//boolean result = tiki.eating("Someone else",10,true);
		//tiki.eating("hello","bye","whatever");
		//tiki.eating("hello","bye","whatever","askjdgfaskjg");
	}

}









