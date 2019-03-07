
public class Letter {
	

	public static void  main(String[] args)
	{
		char letter = 'B';
		switch (letter)
		{
		case 'A':
		case 'a':
			System.out.println("some kind of A");
		case 'B':
		case 'b':
			System.out.println("some kind of B");
			break;
		default:
			System.out.println("something else.");
			break;
		}
	}

}
