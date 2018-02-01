import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;

//class NameSorter implements Comparator<Person>
//{
//
//	@Override
//	public int compare(Person arg0, Person arg1) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//}

class Sample implements Comparable<Sample>
{

	@Override
	public int compareTo(Sample arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class Person implements Comparable<Person>
{
	public int id;
	public String name;
	public int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object o)//Person
	{
		System.out.println("Calling equals...");
		return this.name.equals(((Person)o).name);
	}
	
	public boolean equals(Person o)
	{
		System.out.println("Calling Person equals...");
		return this.name.equals(o.name);
	}
	
	@Override
	public int hashCode()
	{
		System.out.println("Callling hashcode...");
		return this.age;
	}

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return this.age - arg0.age;
	}
}

public class Day3Collections {

	//private static int value;
	
	public static void setValue(int param)
	{
		//value = param;
		System.out.println("Value received: " + param);
	}
	
	public static void main(String[] args) 
	{
		int value;
		List<Integer> sampleSet = new ArrayList<>();//new TreeSet<>();
		sampleSet.add(10);
		sampleSet.add(20);
		sampleSet.add(30);
		sampleSet.add(40);
		
		Optional<List<Integer>> optList = Optional.ofNullable(sampleSet);
		
		optList.ifPresent((x)->{
			Collections.sort(x);
			//System.out.println(x.get(0).toString());
			setValue(x.get(0));
		});
		
		//sampleSet.add(new Sample());
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Freyja", 2));
		people.add(new Person("Freyr", 0));
		people.add(new Person("Tiki", 45));
		people.add(new Person("Michelle", 36));
		
		//Collections.sort(people);
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		});
		
		for(Person current : people)
		{
			System.out.println(current.name + " - " + current.age + " years old");
		}
		
//		Map<String, String> countries = new TreeMap<>();
//		countries.put("my", "Malaysia");
//		countries.put("vn", "Vietnam");
//		countries.put("fr", "France");
//		countries.put("in", "India");
//		countries.put("pk", "Pakistan");
//		countries.put("lk", "Sri Lanka");
//		countries.put("ke", "Kenya");
//		countries.put("cn", "China");
//		countries.put("ph", "Phillipines");
//		
//		//System.out.println(countries.get("my"));
//		List<String> countryVals = new ArrayList<>();
//		countryVals.addAll(countries.values());
//		
//		Collections.sort(countryVals);
//		
//		for(String val: countryVals)
//		{
//			System.out.println(val);
//		}
		
//		Stack<String> stacker = new Stack<>();
//		stacker.push("Item 1");
//		stacker.push("Item 2");
//		stacker.push("Item 3");
//		stacker.push("Item 4");
//		stacker.push("Item 5");
//		stacker.push("Item 6");
//		
//		System.out.println(stacker.pop());
//		
//		System.out.println("Stacker----------------------------");
//		
//		for(String item:stacker)
//		{
//			System.out.println(item);
//		}
//		
//		System.out.println("Stacker----------------------------");
//		
//		Queue<Account> accounts = new LinkedList<Account>();
//		Account temp = new CheckingAccount("John Doe", 109);
//		accounts.add(temp);
//		accounts.remove(temp);
//		
//		//Queue<String> q = new LinkedList<>();
//		Deque<String> q = new LinkedList<>();
//		
//		q.add("Item 1");
//		q.add("Item 2");
//		q.add("Item 3");
//		q.add("Item 4");
//		q.add("Item 5");
//		q.addFirst("Item 0");
//		
////		q.remove();
////		System.out.println(q.poll());
//		System.out.println(q.peekLast());
//		
//		System.out.println("---------------------------------");
//		
//		for(String item: q)
//		{
//			System.out.println(item);
//		}
		
		// TODO Auto-generated method stub
//		List<String> fruits = new ArrayList<>();
//		fruits.add("Apples");
//		fruits.add("Oranges");
//		fruits.add("Pears");
//		fruits.add("Bananas");
//		fruits.add("Durians");
//		
//		fruits.add(3, "Rambutans");
//		fruits.remove(5);
//		
//		fruits.addAll(Arrays.asList("Peaches","Guavas","Grapes"));
//		//-------------------------------------------------------------
//		
//		Set<String> participants = new HashSet<>();
//		participants.add("Tiki");
//		participants.add("Dhara");
//		participants.add("Jean");
//		participants.add("Mehdi");
//		participants.add("Danny");
//		participants.add("Dat");		
//		participants.add("Alex");
//		participants.add("Nguyen");
//		participants.add("Nguyen");
//		participants.add("Nguyen");
//		participants.add("Nguyen");
//		participants.add("Nguyen");
//		participants.add("Nguyen");
//		participants.add("Nguyen");
//		
//		List<String> sortedP = new ArrayList<>();
//		sortedP.addAll(participants);
//		sortedP.get(5);
//		
//		//-----------------------------------------------
//		Set<Person> people = new HashSet<Person>();
//		people.add(new Person("Tiki", 45));
//		people.add(new Person("Tiki", 45));
//		people.add(new Person("Tikriti", 55));
//		people.add(new Person("Johanne", 55));
//		people.add(new Person("Shamoon", 52));
//		people.add(new Person("Michelle", 36));
//		
//		
//		Person tiki = new Person("Tiki",45);
//		if(tiki.equals(new Person("Tiki",46)))
//		{
//			System.out.println("Yup, same person");
//		}
//		else
//		{
//			System.out.println("Nope, not the same");
//		}
//		
//		Iterator<Person> iterPerson = people.iterator();
//		
//		Iterable<String> iterObj = new Iterable<String>() {
//			
//			@Override
//			public Iterator<String> iterator() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
//		Iterator<String> sampelIter = new Iterator<String>() {
//
//			@Override
//			public boolean hasNext() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public String next() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
//		while(iterPerson.hasNext())
//		{
//			System.out.println(iterPerson.next().name);
//		}
		
//		for(Person member : people)
//		{
//			System.out.println(member.hashCode());
//		}
	}

}







