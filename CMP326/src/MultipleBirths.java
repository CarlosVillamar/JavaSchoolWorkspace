import java.util.Scanner;
public class MultipleBirths {
public static void main(String[] args)
{
	int NumofBabies;
	System.out.print("Enter the number of babies:");
	Scanner keyboard = new Scanner(System.in);
	NumofBabies = keyboard.nextInt();
	
	switch (NumofBabies)
	{
	case 1:
		System.out.println("Congrats");
		break;
	case 2:
		System.out.println("WOW Twins");
		break;
	case 3:
		System.out.println("WOW triples");
		break;
	case 4:
	case 5:
		System.out.print("Unbelievable:");
		System.out.println(NumofBabies + "Babies");
		break;
	default:
		System.out.println("I don't believe you");
		break;
		
	}
	keyboard.close();
	
}}
