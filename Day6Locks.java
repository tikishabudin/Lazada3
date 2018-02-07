import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class Day6Locks {

	public static void process(StampedLock lock, long id)
	{
		//Do some processing 
		//lock.readLock().unlock();
		//lock.unlockRead(id);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner uin = new Scanner(System.in);
		ExecutorService exs = Executors.newCachedThreadPool();
		
		Semaphore sem = new Semaphore(5);
		//Semaphore writesem = new Semaphore(1);
		//sem.availablePermits();
		
		exs.submit(()->{
			try {
				sem.acquire();
				System.out.println("Submit 1");
				//sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		exs.submit(()->{
			try {
				sem.acquire();
				System.out.println("Submit 2");
				//sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		exs.submit(()->{
			try {
				sem.acquire();
				System.out.println("Submit 3");
				//sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		exs.submit(()->{
			try {
				sem.acquire();
				System.out.println("Submit 4");
				//sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		exs.submit(()->{
			try {
				sem.acquire();
				System.out.println("Submit 5");
				//sem.release();
				sem.release(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		exs.submit(()->{
			try {
				sem.acquire();
				
				System.out.println("Submit 6");
				//sem.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//ReentrantLock lock = new ReentrantLock();
		//ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
//		StampedLock lock = new StampedLock();
		
//		exs.submit(()->{
//			long lockId = lock.readLock();
//			//lock.readLock().lock();
//			System.out.println("First Submission");
//			//lock.unlockRead(lockId);
//			System.out.println("Lock is valid: " + lock.validate(lockId));
//			System.out.println("Lock ID: " + lockId);
//			
//			process(lock,lockId);
//		});
//		
//		exs.submit(()->{
//			long lockId2 = lock.readLock();
//			//lock.readLock().lock();
//			System.out.println("Second Submission");
//			long newlock = lock.tryConvertToWriteLock(lockId2);
//			System.out.println("Lock ID: " + lockId2);
//			uin.nextLine();
//			//lock.readLock().unlock();
//			if(newlock == 0)
//			{
//				lock.unlockRead(lockId2);
//			}
//			lock.unlockRead(257);
//		});
//		
//		exs.submit(()->{
//			long lockId = lock.writeLock();
//			//lock.writeLock().lock();
//			System.out.println("Third Submission");
//			System.out.println("Lock ID: " + lockId);
//			//lock.writeLock().unlock();
//			lock.unlockWrite(lockId);
//		});
	}

}
