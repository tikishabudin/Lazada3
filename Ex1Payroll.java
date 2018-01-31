import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Ex1Payroll 
{
 
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		double hours,gross,tax,nett;
		double basic = 6.5;
		double otRate = 1.5;
		double taxRate = 0.48;
		double regHours = 40;
		boolean quit = false;
		
		Scanner uin = new Scanner(System.in);
		
		while(!quit)
		{
			System.out.println("Enter # of Hours worked:");
			hours = Double.parseDouble(uin.nextLine());
			
			if(hours > regHours)
			{
				gross = ((hours - regHours) * basic * otRate) + (basic * regHours);
			}
			else
			{
				gross = basic * hours;
			}
			
			tax = gross * taxRate;
			nett = gross - tax;
			
			System.out.format("Gross Pay:\t$ %7.2f\n",gross);
			System.out.format("(-) Tax:\t$ %7.2f\n",tax);
			System.out.format("Nett Pay:\t$ %7.2f\n",nett);
			
			System.out.println("Another Calculation? y/n");
			
			switch(uin.nextLine().toLowerCase())
			{
			case "y":
			case "yes":
				quit = false;
				break;
			case "n":
			case "no":
				quit = true;
				System.gc();
				break;
			default:
				System.out.println("Invalid entry....");
				break;
			}
		}
	}

}









