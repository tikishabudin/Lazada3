import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.concurrent.*;

public class Day6AtomicConcurrent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger x = new AtomicInteger();
		Map<String, String> threadSafeMap = new ConcurrentHashMap<>();
		
		ExecutorService exs = Executors.newCachedThreadPool();
		
		exs.submit(()->{x.set(10);});
		exs.submit(()->{System.out.println(x.incrementAndGet());});
		exs.submit(()->{
			threadSafeMap.put("tiki", "Tikriti");
		});
		
		exs.submit(()->{
			threadSafeMap.get("tiki");
		});
		
		exs.shutdown();
		
		
	}

}
