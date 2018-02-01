import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;
import com.lazada.assets.Child;
import com.lazada.assets.Parent;
import com.lazada.assets.SavingsAccount;

class GenericClass<T extends Parent>
{
	private T obj;
	
	public T getObj()
	{
		return this.obj;
	}
	
	public void setObj(T param)
	{
		this.obj = param;
	}
}

class Another
{
	public <T extends Long> long add(T x, T y)
	{
		System.out.println("Long version");
		long a = x;
		long b = y;
		return a+b;
	}
}

interface Iface<T>
{
	void faceProcess(T param);
}

public class Day3Generics {
	
//	public static void doSomething(GenericClass<?> param)
//	{
//		param.setObj(new Child());
//	}
	
	public static void process(List<Account> myList)
	{
		myList.add(new CheckingAccount("", 0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		doSomething(new GenericClass<Parent>());
		
		//System.out.println(obj.add(3,5));
		process(new ArrayList<Account>());
		
	}

}





