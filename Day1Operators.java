import java.util.Scanner;

public class Day1Operators
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Math Operators
		// () Brackets
		// / Divide
		// * Multiply
		// + Add
		// - Subtract
		// % Modulus 25%3 = 1
		// ++ / --
		
		int celsius = ((212-32)*5)/9;
		System.out.println(celsius++); //Add 1 after
		System.out.println(++celsius); //Add 1 before
		System.out.println(celsius *= 2);// celsius = celsius * 2
		
		double result = 1 * 9 % 4;
		System.out.println(result);
		System.out.println("========================================");
		
		//RELATIONAL OPERATORS
		// == Same as, != Not same as, > More than, < Less Than, >= More than or equal to, <= less than or equal to
		
		//LOGICAL Operators
		// && And
		// || Or
		// ! Not
		
		
		Scanner uin = new Scanner(System.in);
		
		int x = 5, y = 11;
		
		x = Integer.parseInt(uin.nextLine());
		y = Integer.parseInt(uin.nextLine());
		
		if(x != y && (y > 100 || x < 10))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
			
	}

}




