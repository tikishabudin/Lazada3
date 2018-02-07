import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import com.lazada.assets.Account;

class MyAction extends RecursiveAction
{

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		System.out.println("Action running");
	}
	
}

class MyTask extends RecursiveTask<String>
{

	@Override
	protected String compute() {
		// TODO Auto-generated method stub
		return "Computation done";
	}
	
}

public class Day6Parallel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ForkJoinPool fjp = ForkJoinPool.commonPool();
		
		//ExecutorService exs = Executors.newWorkStealingPool(2);
		//ForkJoinPool fjp = new ForkJoinPool(2);
		
		System.out.println(fjp.getParallelism());
		
//		ForkJoinTask<String> obj = new ForkJoinTask<String>() {
//
//			@Override
//			protected boolean exec() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public String getRawResult() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			protected void setRawResult(String value) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		
		fjp.invoke(new MyAction());
		System.out.println(fjp.invoke(new MyTask()));
		
		fjp.submit(new MyAction());
		ForkJoinTask<String> strResult = fjp.submit(new MyTask());
		fjp.submit(()->{return "";});
		
		
		try 
		{
			strResult.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Callable<String>> execList = new ArrayList<>();
		execList.add(()->{
			return "Task 1 done";
		});
		execList.add(()->{
			return "Task 2 done";
		});
		execList.add(()->{
			return "Task 3 done";
		});
		execList.add(()->{
			return "Task 4 done";
		});
		execList.add(()->{
			return "Task 5 done";
		});
		
		List<Future<String>> results =  fjp.invokeAll(execList);
		
		for(Future<String> result : results)
		{
			try {
				System.out.println(result.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		fjp.shutdown();
		
	}

}
