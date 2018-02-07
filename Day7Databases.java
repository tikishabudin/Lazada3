import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

class DBUser
{
	int id;
	String name;
	String email;
	String password;
	
	public DBUser(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
}

public class Day7Databases {

	public static void main(String[] args) 
	{
		Driver dbDriver;
		
		try {
			dbDriver = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(dbDriver);
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lazada3", "root", "");
				Statement stmt = conn.createStatement();
		)
		{
			//Oracle JDK
			//Class.forName("com.mysql.jdbc.Driver");
			
//			Properties props = new Properties();
//			props.setProperty("timezone", "");
//			props.setProperty("username", "root");
//			DriverManager.getConnection("", props);
			
			
			String q = String.format("INSERT INTO users (name,email,password) VALUES ('%s','%s',SHA1('%s'))","Tiki","tikishabudin@gmail.com","abc123");
			//stmt.executeUpdate(q);
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			List<DBUser> users = new ArrayList<>();
			
			while(rs.next())
			{
				users.add(new DBUser(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
			
			Stream<DBUser> userSteam = users.stream();
			
//			if(stmt.execute("SELECT * FROM users"))
//			{
//				List<ResultSet> rList = new ArrayList<>();
//				rList.add(stmt.getResultSet());
//				
//				while(stmt.getMoreResults())
//				{
//					rList.add(stmt.getResultSet());
//				}
//				//ResultSet rs2 = stmt.getResultSet();
//				for(ResultSet rSet:rList)
//				{
//					while(rSet.next())
//					{
//						System.out.print(rSet.getInt("id") + " - ");
//						System.out.println(rSet.getString("name"));
//					}
//					
//					System.out.println("---------------------------------------");
//				}
//			}
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
