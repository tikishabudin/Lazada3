class Demo
{
	public int x;
	public double y;
}

public class Day3Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "This";
		String B = "This";//new String()
		
		StringBuilder sb = new StringBuilder(200);
		sb.append("Hello");
		sb.append(" my name is Tiki.");
		sb.append(" This is my story.");
		sb.append(" The end.");
		
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("");
		
		String result = sb.toString();
		System.out.println(result);
		
		A.toLowerCase();//{return new String();}
		B.toLowerCase();
		
		result.split("\\d\\-");
		
		if(result.contains("Tiki"))
		{
			String resultSub = result.substring(result.indexOf("Tiki"));
			System.out.println("Result: " + resultSub);
			System.out.println("Character count: " + result.length());
		}
		//A = B + " and That";
		
		String names = "";
		names += "Tiki";
		names += ",Ahad";
		names += ",Dat";
		names += ",Kevin";
		names += ",Son";
		
		Demo obj1 = new Demo();
		obj1.x = 10;
		obj1.y = 2.5;
		
		Demo obj2 = new Demo();
		obj2.x = 10;
		obj2.y = 2.5;
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		if(A.equals(B))
		{
			System.out.println("Same Object");
		}
		else
		{
			System.out.println("Not the same object");
		}
	}

}
