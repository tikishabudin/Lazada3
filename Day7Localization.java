import java.nio.BufferUnderflowException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Day7Localization 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Locale finnish = new Locale("fi","FI");
		Locale vietnam = new Locale("vi","VN");
		
		ZonedDateTime now = ZonedDateTime.now();
		DateFormat vietDF = DateFormat.getDateInstance(DateFormat.FULL,vietnam);
		DateFormat finDF = DateFormat.getDateInstance(DateFormat.FULL,finnish);
		
		System.out.println(vietDF.format(new Date(now.toInstant().toEpochMilli())));
		System.out.println(finDF.format(new Date(now.toInstant().toEpochMilli())));
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(vietnam);
		System.out.println(nf.format(23.5));
		
		ResourceBundle bundle = ResourceBundle.getBundle("somefile", vietnam);
		
		System.out.println(bundle.getString("greet"));
	}

}







