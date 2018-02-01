import java.util.ArrayList;
import java.util.List;

import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;
import com.lazada.assets.SavingsAccount;


//tikishabudin@gmail.com

interface MyFace
{
	
}

interface SomeFace extends MyFace
{
	
}

class MyFaceImpl implements MyFace
{
	
}

class FaceImpl1 implements SomeFace
{
	void doSomething() {}
}

class FaceImpl2 implements SomeFace
{
	int somethingElse() {return 0;}
}

class FaceImpl3 implements SomeFace
{
	void whatever() {}
}

public class Day4Generics 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<? super Account> listofstuff = new ArrayList<>();
		listofstuff.add(new CheckingAccount("", 0));
		
		List<? super MyFace> objs = new ArrayList<>();
		objs.add(new FaceImpl1());
		objs.add(new FaceImpl2());
		objs.add(new FaceImpl3());
		objs.add(new MyFaceImpl());
		
//		List<Account> accountList = new ArrayList<>();
//		List<SavingsAccount> savingsList = accountList;
//		List<CheckingAccount> checkList = accountList;
		
		//List<SavingsAccount> list = new ArrayList<CheckingAccount>();
		listofstuff.add(new CheckingAccount("", 0));
		listofstuff.add(new SavingsAccount("", 0));
		
	}

}
