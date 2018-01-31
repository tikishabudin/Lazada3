
public class Day1Flow {

	enum Choices{me,you;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int x = 0;
//		char alpha = 'a';
//		Choices mychoice = Choices.me;
		String lang = "vietnamese";
		
		switch(lang)
		{
		case "english": System.out.println("Hello");
		break;
		case "french": System.out.println("Bonjour");
		break;
		case "vietnamese": System.out.println("Xin Chao");
		break;
		case "singhala": System.out.println("Ayubowan");
		break;
		case "urdu": System.out.println("Hi");
		break;
		case "mandarin": System.out.println("Ni Hao");
		break;
		case "malaysia": System.out.println("Apa Khabar");
		break;
		case "hindi": System.out.println("Namaste");
		break;
		case "swahili": System.out.println("Jumbo");
		break;
		case "tagalog": System.out.println("Kumusta ka");
		break;
		default:System.out.println("I'm sorry. I don't understand");
		break;
		}
		
		int counter = 0;
		//while
//		while(counter < 5)
//		{
//			System.out.println("Hello");
//			counter++;
//		}
		
		//do...while
//		do
//		{
//			System.out.println("Anyeong haseyo");
//			counter++;
//		}while(counter < 5);
		
		//for
//		for(int i = 0; i < 5; i++,System.out.println("Whatever"))
//		{
//			System.out.println("This will run first...");
//		}
		
		while(counter < 5)
		{
			counter++;
			System.out.println("Before if....");
			if(counter == 3)
				continue;
			System.out.println("After if...");
			
		}
		
		System.out.println("----------------------------------");
		
		int x = 5;
		int y = 10;
		
		String result = x != y? "True":"False";
		System.out.println(result);
	}

}






