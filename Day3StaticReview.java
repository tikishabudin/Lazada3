
class SuperClass
{
	public static void fx()
	{
		System.out.println("Super Method");
	}
}

class SubClass extends SuperClass
{
	public static void fx()
	{
		System.out.println("Subclass Method");
		SuperClass.fx();
	}
}

public class Day3StaticReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass.fx();
	}

}
