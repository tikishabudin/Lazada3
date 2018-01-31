import java.util.Arrays;
import java.util.Collections;

//class Monkey implements Comparable<Monkey>
//{
//	public String name;
//	public int age;
//	
//	@Override
//	public int compareTo(Monkey o) {
//		// TODO Auto-generated method stub
//		if(this.age > o.age)
//			return 1;
//		else if(this.age < o.age)
//			return -1;
//		return 0;
//	}
//}

public class Day2Arrays 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int x = 5;
		int[] numbers = {1,2,3,4,5,65,-20};
		long[] numbers2 = new long [999];
		//numbers[10] = 15;
		//System.out.println(numbers[10]);
		
		Arrays.sort(numbers);
		
		System.out.println("----------------------------");
//		for(int i = 0; i < numbers.length; i ++)
//		{
//			System.out.println(numbers[i]);
//		}
		
		for(int temp:numbers)
		{
			System.out.println(temp);
		}
		
		int[][] tictactoe = {{1,5,3},{2,4,1,7},{1,2,3,4,5,6,7}};//new boolean[3][3];
		tictactoe[0][2] = 22;
		
		//Collections.sort(list);
		
		for(int i = 0; i < tictactoe.length; i++)
		{
			Arrays.sort(tictactoe[i]);
			for(int j = 0; j < tictactoe[i].length; j++)
			{
				System.out.format("[%d][%d] - Value: %s\n",i,j,tictactoe[i][j]);
			}
		}
		
		System.out.println("----------------------------------------------------");
		
		//Jagged arrays
		int[][] grid = new int[3][];
		grid[0] = new int[5];
		grid[1] = new int[15];
		grid[2] = new int[7];
		
	}

}









