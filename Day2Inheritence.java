import com.lazada.assets.Child;
import com.lazada.assets.GChild;
import com.lazada.assets.OtherChild;
import com.lazada.assets.Parent;

public class Day2Inheritence {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Child obj = new Child();
		System.out.println("--------------------------------------");
		obj.doSomething(2);
		
		Parent obj2 = new Child();
		obj2 = new OtherChild();
		
//		Parent[] objArr = {new Child(),new OtherChild(),new Child()};
//		
//		if(objArr[0] instanceof Child)
//		{	
//			Child current = (Child)objArr[0];
//			objArr[0].doSomething();
//		}
		
		System.out.println("--------------------------------");
		
		GChild gObj = new GChild();
		gObj.doSomething();
		
		//System.out.println(obj.info);
	}

}





