import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileLock;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day5NIO 
{

	public static void main(String[] args) 
	{
//		try {
//			ServerSocketChannel servChannel = ServerSocketChannel.open();
//			
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
//		
//		
//		try {
//			Socket socket = new Socket("127.0.0.1",8080);
//			SocketAddress addr = socket.getRemoteSocketAddress();
//			
//			SocketChannel sock = SocketChannel.open(addr);
//			//CharBuffer
//			socket.close();
//			sock.close();
//			
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		// TODO Auto-generated method stub
		Path file = Paths.get("./newFile.data");
		Path target = Paths.get("./result.data");
		
		Set<PosixFilePermission> perm = new HashSet<>();
		perm.add(PosixFilePermission.OWNER_READ);
		perm.add(PosixFilePermission.OWNER_WRITE);
		perm.add(PosixFilePermission.GROUP_READ);
		perm.add(PosixFilePermission.OTHERS_READ);
		
		FileAttribute<Set<PosixFilePermission>> fa = PosixFilePermissions.asFileAttribute(perm);
		
		try {
			FileChannel channel = FileChannel.open(file, 
					StandardOpenOption.WRITE,
					StandardOpenOption.READ);
			ByteBuffer buffer = ByteBuffer.allocate((int)channel.size());
			
			FileLock lock = channel.lock();
			channel.read(buffer);
			lock.release();
			
			byte[] result = buffer.array();
			
			ByteArrayInputStream bis = new ByteArrayInputStream(result);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			List<Specimen> specList = (List<Specimen>)ois.readObject();
			
			for(Specimen obj: specList)
			{
				System.out.println(obj.name);
			}
			
			ois.close();
			bis.close();
			buffer.clear();
			channel.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(Files.notExists(file))
//		{
//			try 
//			{
//				Files.createFile(file);
//				//Files.setAttribute(file, "user:charset", "utf-8");
//				
//				FileChannel channel = FileChannel.open(file, 
//						StandardOpenOption.READ,
//						StandardOpenOption.WRITE);
//				
//				List<Specimen> names = Arrays.asList(
//						new Specimen(1, "Whatever"),
//						new Specimen(2, "Cool Joe"),
//						new Specimen(3, "Lalala"));
//				
//				ByteArrayOutputStream bos = new ByteArrayOutputStream();
//				ObjectOutputStream oos = new ObjectOutputStream(bos);
//				
//				oos.writeObject(names);
//				
//				byte[] source = bos.toByteArray();
//				
//				ByteBuffer buffer = channel.map(MapMode.READ_WRITE, 0, source.length);
//				
//				FileLock lock = channel.lock();
//				buffer.put(source);
//				lock.release();
//				
//				oos.close();
//				bos.close();
//				buffer.clear();
//				channel.close();
//			} 
//			catch (IOException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		try {
//			Files.move(file, target);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}










