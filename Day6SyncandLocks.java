import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SyncUtil
{
	public static void doThis(Object lock)
	{
		synchronized (lock) 
		{
			System.out.println("Doing this");
		}
		
	}
	
	public static synchronized void doThat()
	{
		System.out.println("Doing that");
	}
}

class SyncDemo
{
	private Integer x;
	private Integer y;
	Object lockObj = new Object();
	
	public SyncDemo()
	{
		this.x = new Integer(25);
		this.y = this.x;
	}
	
	public void changeX(int changeVal)
	{
		//Do some stuff before
		
		this.x = changeVal;
		//Do some stuff after
	}
	
	public synchronized void setX(int set)
	{
		
		this.x = set;
		System.out.println("Set operation successful");
	}
	
	public synchronized int getX()
	{
		this.x += 2;
		return this.x;
	}
}

public class Day6SyncandLocks {

	public static void main(String[] args) {
		
//		List<String> words = new ArrayList<>();
//		words.add("The");
//		words.add("quick");
//		words.add("brown");
//		words.add("fox");
//		
//		words.remove(2);
//		Iterator<String> iStr = words.iterator();
//		
//		while(iStr.hasNext())
//		{
//			System.out.println(iStr.next());
//			//iStr.remove();
//		}
//		
//		words.remove(0);
		// TODO Auto-generated method stub
		ExecutorService exs = Executors.newCachedThreadPool();
		Object lock = new Object();
		Scanner uin = new Scanner(System.in);
		
		SyncDemo obj = new SyncDemo();
		
		
		exs.submit(()->{
			synchronized(lock)
			{
				SyncUtil.doThis(lock);
				System.out.println("Press enter");
				uin.nextLine();
			}
		});
		
		exs.submit(()->{
			synchronized(lock)
			{
				obj.setX(10);
			}
			
		});
		
		exs.submit(()->{
			synchronized(lock)
			{
				SyncUtil.doThat();
			}
		});
		
		
		
		exs.submit(()->{
			synchronized(lock)
			{
				System.out.println(obj.getX());
			}
		});
		
		exs.shutdown();
	}

}










