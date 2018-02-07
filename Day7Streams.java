import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Day7Streams 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("item 2");
		list.add("item 3");
		list.add("item 4");
		list.add("item 5");
		list.add("item 1");
		
		Stream<String> strStream = list.stream();
		//strStream = Stream.of("Hello","bye","array");
		
		Stream<Integer> nums = Stream.of(1,2,3,4,5,6);
		int sum = nums.parallel().reduce(1, (a,b)->a+b);
		System.out.println("Total: " + sum);
		
		IntStream intStream = IntStream.of(1,2,3,4,5,6);
		System.out.println(intStream.average());
		
		LongStream longStream = LongStream.range(1, 10);
		
		List<String> processedList = strStream.map(String::toUpperCase)
		.parallel()
		.filter((x)->{return x.contains("ITEM");})
		.collect(Collectors.toList());
		
		strStream = list.stream();
		list.add("Whatever");
		String result = strStream.map(String::toUpperCase)
				.parallel()
				.filter((x)->{return x.contains("ITEM");})
				.sorted()
				.reduce("Result: ",(a,b)->a.concat(b));
		System.out.println(result);
		
		strStream = list.stream();
		IntSummaryStatistics summary = strStream.collect(Collectors.summarizingInt(String::length));
		System.out.println(summary);
		
		
		for(String item:list)
		{
			System.out.println(item);
		}
		
		System.out.println("-----------------------------------");
		
		for(String item: processedList)
		{
			System.out.println(item);
		}
	}

}








