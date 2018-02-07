import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class CallDemo implements Callable<String>
{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Thread is done";
	}
	
}

class MyFactory implements ThreadFactory
{
	private static int count = 0;
	
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		return new Thread(r,"Thread#" + count++);
	}	
}

public class Day6Concurrency {

	final static Scanner uin = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Parallelism
		//ExecutorService exs = Executors.newWorkStealingPool();
		//ExecutorService exs = Executors.newScheduledThreadPool(4);
		
		// TODO Auto-generated method stub
		//Thread job1 = new Thread(new CallDemo());
		//ExecutorService exs = Executors.newSingleThreadExecutor();
		//ExecutorService exs = Executors.newCachedThreadPool();
		
		ExecutorService exs = Executors.newFixedThreadPool(10,new MyFactory());
		
//		Thread tObj = new Thread(()->{},"Job1");
//		tObj.start();
//		tObj.stop();
		
		exs.submit(()->{
			System.out.println("Doing something");
			System.out.println("Press enter to continue");
			uin.nextLine();
			throw new InterruptedException();
		});
		exs.submit(()->{
			System.out.println("Doing something");
			System.out.println("Press enter to continue");
			uin.nextLine();
		});
		exs.submit(()->{
			System.out.println("Doing something");
			System.out.println("Press enter to continue");
			uin.nextLine();
		});
		
		for(int i = 0; i < 5; i++)
		{
			Future<String> result = exs.submit(new CallDemo());
			
			exs.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Running a runnable");
					
				}
			});
			
			Future<Integer> intresult = exs.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, 10);
			
			try 
			{
				System.out.println(intresult.get(3, TimeUnit.SECONDS));
				System.out.println(result.get());
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		exs.shutdown();
		//exs.submit(()->{});
		
		try 
		{
			if(!exs.awaitTermination(30, TimeUnit.SECONDS))
			{
				exs.shutdownNow();
			}
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}






