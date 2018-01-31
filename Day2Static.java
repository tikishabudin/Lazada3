import com.lazada.assets.SampleUtility;
import com.lazada.assets.StaticSample;

public class Day2Static {

	public static void main(String[] args) 
	{
		SampleUtility.dothis();
		SampleUtility.dothat();
		
		
		StaticSample.showNum();
		// TODO Auto-generated method stub
		StaticSample obj1 = new StaticSample();
		StaticSample obj2 = new StaticSample();
		StaticSample.showNum();
		
		obj1.num = 25;
		StaticSample.showNum();
		
		StaticSample obj3 = new StaticSample.Builder().create();
	}

}
