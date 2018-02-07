import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

enum EnumTester
{
	VAL1("Value 1")
	{
		@Override
		public void doSomething()
		{
			System.out.println("Val1 Doing Something");
		}
	},
	VAL2("Value 2"),
	VAL3("Value 3");
	
	private String info;
	public void doSomething(){}
	private EnumTester(String info)
	{
		this.info = info;
	}
}


public class Day7DateTimes 
{

	public static void main(String[] args) 
	{
		Object ref = new Object(){
			//String info = "";
			public String toString()
			{
				return "Lalalala";
			}
		};
		System.out.println(ref.toString());
		EnumTester.VAL1.doSomething();
		// TODO Auto-generated method stub
		Date today = new Date();
		Date bday; //= new Date(1973,5,10);
		GregorianCalendar gcal = new GregorianCalendar(1973, 5, 10, 8, 32);
		bday = new Date(gcal.getTimeInMillis());
		
		long duration = today.getTime()-bday.getTime();
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		System.out.println("I am " + (days/365) + (" years old"));
		
		//--------------------------------------------------------------------------
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nowPlus5 = now.plus(12,ChronoUnit.HOURS);
		LocalDateTime xmas = LocalDateTime.of(2018, 12, 25,0,0,0);
		LocalDateTime klTime = LocalDateTime.of(2018, 2,6,16,00,00);
		ZonedDateTime nowPlusSome = ZonedDateTime.of(klTime,ZoneId.of("Asia/Kuala_Lumpur")); 
		
		ZonedDateTime helNow = ZonedDateTime.of(now, ZoneId.of("Europe/Helsinki"));
		ZonedDateTime sgnNow = ZonedDateTime.of(now, ZoneId.of("Asia/Saigon"));
		
		Instant specificTime = helNow.toInstant();
		long milis = specificTime.toEpochMilli();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		//TimeUnit.DAYS.
		
		//System.out.println(dtf.format(now));
		
		//Duration diff =  Duration.between(sgnNow, helNow);
		//System.out.println(now.until(sgnNow,ChronoUnit.HOURS));
//		long period = now.until(xmas,ChronoUnit.MONTHS);
//		System.out.println("Months to Christmas: " + period);
	}

}







