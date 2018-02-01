import java.util.Optional;

import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;
import com.lazada.assets.User;

class OptionalDemo
{
	public String data = "Some Data";
	public static String staticReturnString(OptionalDemo obj)
	{
		return obj.data;
	}
	
	public int someCalc()
	{
		return 10;
	}
	
	public Optional<OptionalDemo> getOptObj()
	{
		//Do some processing
		if(this.data.equals("New"))
			return Optional.of(new OptionalDemo());
		
		return Optional.of(this);
	}
	
	public void otherFx(int x, int y, int z)
	{
		
	}
	
	public void voidReturn()
	{
		
	}
}

public class Day4Optional 
{

	public static void main(String[] args) 
	{
		OptionalDemo obj = new OptionalDemo();
		obj.data = "Hello";
		Optional<OptionalDemo> optDemo = Optional.of(obj);
		
		if(optDemo
		.flatMap(OptionalDemo::getOptObj)
		.filter(x->x.data.equals("Hello"))
		.isPresent())
//		{
//			
//		}
//		else
//		{
//			
//		}
		
		
		
//		.ifPresent(x->{
//			System.out.println(x.getClass().getSimpleName() + " obj exists!");
//			x.otherFx(1, 2, 3);
//		});
			
		optDemo.map(OptionalDemo::staticReturnString).ifPresent((String x)->{});
		optDemo.map(OptionalDemo::getOptObj).ifPresent((x)->{
			System.out.println(x.getClass().getSimpleName());
		});
		
		optDemo.flatMap(OptionalDemo::getOptObj).ifPresent((OptionalDemo x)->{});
			
		System.out.println(optDemo.map(OptionalDemo::staticReturnString).get());
		
		System.out.println(optDemo.map(OptionalDemo::someCalc).get());
		
//		Account acc = null;//new CheckingAccount("Tiki", 100);
//		User someUser = null;//new User("John Doe", "jd@unknown.com", new CheckingAccount("John Doe", 100));
//		
//		Optional<User> optAcc = Optional.ofNullable(someUser);
//		
//		optAcc = Optional.of(new User("", "", new CheckingAccount("", 0)));
//		
//		optAcc.ifPresent((x)->{
//			System.out.println(x.getAccount().getHolderName());
//		});
		//System.out.println(optAcc.map(User::getAccount).get().getHolderName());
	}

}








