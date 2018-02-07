import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.lazada.assets.Account;
import com.lazada.assets.CheckingAccount;

public class Tester {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Path file = Paths.get("./data.sample");
		
		try 
		{
			FileChannel channel = FileChannel.open(file, StandardOpenOption.READ,StandardOpenOption.WRITE);
			ByteBuffer buffer = ByteBuffer.allocate((int)Files.size(file));//channel.map(MapMode.READ_ONLY, 0, Files.size(file));
			
			FileLock lock = channel.lock();
			channel.read(buffer);
			byte[] result = buffer.array();
			lock.release();
			
			ByteArrayInputStream bis = new ByteArrayInputStream(result);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			System.out.println((String)ois.readObject());
			
			ois.close();
			bis.close();
			buffer.clear();
			channel.close();
			
//			if(Files.notExists(file))
//				Files.createFile(file);
//			FileChannel fChanel = FileChannel.open(file,StandardOpenOption.READ, StandardOpenOption.WRITE);
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			
//			Account obj = new CheckingAccount("Tiki", 1000);
//			String output = "The quick brown fox jumps over the lazy dog";
//			
//			oos.writeObject(output);
//			
//			byte[] rawData = bos.toByteArray();
//			
//			ByteBuffer buffer = fChanel.map(MapMode.READ_WRITE, 0, rawData.length);
//			FileLock lock = fChanel.lock();
//			buffer.put(rawData);
//			lock.release();
//			buffer.clear();
//			
//			oos.close();
//			bos.close();
//			fChanel.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
