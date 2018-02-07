import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import com.lazada.assets.CheckingAccount;
import com.lazada.assets.SavingsAccount;
import com.lazada.assets.User;

public class Ex4PayMaster 
{
	private static Scanner uin = new Scanner(System.in);
	private static Map<String, User> users = new ConcurrentHashMap<>();
	private static ExecutorService exs = Executors.newFixedThreadPool(2);
	private static StampedLock lock = new StampedLock();
	
	public static void displayMenu()
	{
		System.out.println("1) Register New User");
		System.out.println("2) Calculate Pay");
		System.out.println("3) List Users");
		System.out.println("x) Exit");
		System.out.print("Enter Option: ");
	}
	
	public static void registerUser()
	{
		String name = "";
		String email = "";
		System.out.println("Enter email:");
		do
		{
			email = uin.nextLine();
			if(email == "")
			{
				return;
			}
		}while(users.get(email) != null);
		
		System.out.println("Enter Name:");
		name = uin.nextLine();
		
		System.out.println("Account Type: ");
		System.out.println("1) Savings Account");
		System.out.println("2) Checking Account");
		System.out.print("Enter Account Type: ");
		
		final String constName = name;
		final String constEmail = email;
		
		switch(uin.nextLine())
		{
		case "1": 
			exs.submit(()->{
				long id = lock.writeLock();
				users.put(constEmail, new User(constName, constEmail, new SavingsAccount(constName, 0)));
				lock.unlock(id);
			});
			break;
		case "2":
			exs.submit(()->{
				long id = lock.writeLock();
				users.put(constEmail, new User(constName, constEmail, new CheckingAccount(constName, 0)));
				lock.unlockWrite(id);
			});
			break;
		default:
			System.out.println("Invalid Entry.... User not registered");
			return;
		}
		System.out.println("User " + name + " successfully registered");
	}
	
	public static void calculatePay()
	{
		String email = "";
		System.out.println("Enter Email:");
		do
		{
			email = uin.nextLine();
			if(email == "")
			{
				return;
			}
		}while(users.get(email) == null);
		
		System.out.println("Enter # hours worked:");
		
		double hours = 0,gross,tax,nett;
		double basic = 6.5;
		double otRate = 1.5;
		double taxRate = 0.48;
		double regHours = 40;
		boolean quit = false;
		
		try
		{
			hours = Double.parseDouble(uin.nextLine());
		}
		catch(NumberFormatException err)
		{
			System.out.println("Non-number entered. Assuming 0 hours...");
		}
		
		if(hours > regHours)
		{
			gross = ((hours - regHours) * basic * otRate) + (basic * regHours);
		}
		else
		{
			gross = basic * hours;
		}
			
		tax = gross * taxRate;
		nett = gross - tax;
			
		System.out.format("Gross Pay:\t$ %7.2f\n",gross);
		System.out.format("(-) Tax:\t$ %7.2f\n",tax);
		System.out.format("Nett Pay:\t$ %7.2f\n",nett);
		
		final double finalNett = nett;
		final String finalEmail = email;
		
		exs.submit(()->{
			long id = lock.writeLock();
			users.get(finalEmail).getAccount().deposit(finalNett);
			lock.unlockWrite(id);
		});
		System.out.println("Press Enter to continue");
		uin.nextLine();
	}
	
	public static synchronized void listUsers()
	{
		final List<User> userList = new ArrayList<>();
		userList.addAll(users.values());
		
		System.out.println("List By:");
		System.out.println("1) Name");
		System.out.println("2) AccountType");
		System.out.print("Enter: ");
		
		switch(uin.nextLine())
		{
		case "1":
			Collections.sort(userList, new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			});
		case "2":
			Collections.sort(userList, new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					if(o1.getAccount() instanceof SavingsAccount)
						return -1;
					else
						return 1;
				}
			});
		}
		
		for(User user: userList)
		{
			System.out.format("%s(%s) - %s \t %10.2f\n", 
					user.getName(),
					user.getEmail(),
					user.getAccount().getClass().getSimpleName(),
					user.getAccount().getBalance());
		}
		
		System.out.println("Press Enter to continue");
		uin.nextLine();
	}
	
	public static void main(String[] args) 
	{
		boolean quit = false;
		Path fileLoc = Paths.get("userData.info");
		
		if(Files.notExists(fileLoc))
		{
			try {
				Files.createFile(fileLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try(
			ObjectInputStream ois = new ObjectInputStream(
					Files.newInputStream(fileLoc, StandardOpenOption.READ));
		)
		{
			users = (Map<String,User>)ois.readObject();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			users = new HashMap<>();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(!quit)
		{
			displayMenu();
			switch(uin.nextLine())
			{
			case "1":
				registerUser();
				break;
			case "2":
				calculatePay();
				break;
			case "3":
				listUsers();
				break;
			case "x": quit = true;
				break;
			default:
				System.out.println("Invalid Entry.....");
				break;
			}
		}
		
		try(
			ObjectOutputStream oos = new ObjectOutputStream(
					Files.newOutputStream(fileLoc, StandardOpenOption.WRITE));
		)
		{
			oos.writeObject(users);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		exs.shutdown();
	}

}
