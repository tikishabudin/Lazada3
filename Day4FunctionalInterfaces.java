import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;

//@FunctionalInterface
//interface Function<T,R>
//{
//	R apply(T param);
//}

//@FunctionalInterface
//interface Predicate<T>
//{
//	boolean test(T param);
//}

//@FunctionalInterface
//interface Supplier<T>
//{
//	T get();
//}

//@FunctionalInterface
//interface Consumer<T>
//{
//	void accept(T param);
//}

public class Day4FunctionalInterfaces 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Function<String, String> fx = (x)->{
			return "You said: " + x;
		};
		
		System.out.println(fx.apply("Hahahaha"));
		System.out.println("-------------------------------");
		
		Predicate<Integer> pred = x->x>5?true:false;
		
		System.out.println(pred.test(1));
		System.out.println("-------------------------------");
		
		Supplier<Account> supp = ()->{
			return new CheckingAccount("John Doe", 0);
		};
		
		System.out.println(supp.get().getHolderName());
		System.out.println("-------------------------------");
		
		Consumer<String> cons = (x)->{
			System.out.println("Consumer executing with: " + x);
		};
		
		cons.accept("Accepted");
	}

}






