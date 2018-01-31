import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;
import com.lazada.assets.SavingsAccount;

public class Day3AbstractsFinal {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Account obj = new Account("",100);
		Account myAccount = new CheckingAccount("Tiki Shabudin", 1000);
		myAccount.deposit(1000);
		System.out.println("Balance: $ " + myAccount.getBalance());
		myAccount.withdraw(500);
		System.out.println("Balance: $ " + myAccount.getBalance());
		myAccount.withdraw(10000);
		System.out.println("Balance: $ " + myAccount.getBalance());
		myAccount.deposit(0.2);
		System.out.println("Balance: $ " + myAccount.getBalance());
	}

}
