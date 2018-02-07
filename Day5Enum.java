import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

enum Color implements Serializable,Muka
{
	RED("First color in the RGB values"),
	GREEN("Second color in the RGB values"),
	BLUE("Third color in the RGB values"),
	Orange("Also a fruit"),
	Tiki("A furry brown-ish color");
	
	private String description;
	
	private Color(String desc)
	{
		System.out.println("Constructor called");
		this.description = desc;
	}
	
	public String getDesc()
	{
		return this.description;
	}

	@Override
	public void shakeYouBody() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSomething(int param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String feedMyFace() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class Day5Enum 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Color myfav = Color.GREEN;
		System.out.println(myfav.getDesc());
		myfav = Color.Tiki;
		
		try {
			FileChannel fc = FileChannel.open(Paths.get("./somefile"), StandardOpenOption.WRITE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}





