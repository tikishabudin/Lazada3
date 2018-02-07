import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

//Locked up class
class SpecimentField
{
	public String info;
}

class MySpecimentField extends SpecimentField implements Serializable
{
}

class Specimen implements Serializable
{
	private static final long serialVersionUID = -3393526644846741042L;
	public int id;
	public String name;
	public MySpecimentField obj;
	
	public Specimen(int id, String name)
	{
		this.id = id;
		this.name = name;
		this.obj = new MySpecimentField();
		this.obj.info = "Sample Info";
	}
}

public class Day5IO 
{
	
	public static void main(String[] args) 
	{
		String filePath = "./objectData.spec";
		// TODO Auto-generated method stub
		try(
				FileInputStream fis = new FileInputStream(filePath);
				ObjectInputStream ois = new ObjectInputStream(fis);
//				Scanner reader = new Scanner(fis);
				
//				MemoryCacheImageOutputStream memout = new MemoryCacheImageOutputStream());
				
//				FileOutputStream fos = new FileOutputStream(filePath);
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
//				PrintWriter pw = new PrintWriter(fos);
			)
		{
			Object temp = ois.readObject();
			if(temp instanceof Specimen)
			{
				Specimen actual = (Specimen)temp;
				System.out.println(actual.name);
				System.out.println(actual.obj.info);
			}
			
//			oos.writeObject(new Specimen(1,"Speciment 1"));
//			pw.println("The quick brown fox jumps over the lazy dog");
//			List<String> fileContents = new ArrayList<>();
//			
//			while(reader.hasNextLine())
//			{
//				fileContents.add(reader.nextLine());
//			}
//			
//			for(String line:fileContents)
//			{
//				System.out.println(line);
//			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
