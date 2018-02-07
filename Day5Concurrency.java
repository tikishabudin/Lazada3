
class OtherExec implements Runnable
{

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		System.out.println("This will run on a separate thread");
		
		//this.notify();
	}
	
}

public class Day5Concurrency 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Thread job1 = new Thread(new OtherExec());
		Thread job2 = new Thread(()->{
			for(int i = 0; i < 5; i++)
			{
				System.out.println("in a new Thread");
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		job1.start();
		job2.start();
		System.out.println("Requesting that job2 join after this...");
		try {
			job2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println("In the main thread");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}




