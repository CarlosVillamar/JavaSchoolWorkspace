import java.util.Scanner;
public class SumofSsquares {
	private static int userNum = 0;
	public static void main(String[] args)
	{
		getUserInput();
		System.out.println(" The user entered" + userNum);
		System.out.println("The sum of 1 to userNum squared is: "  + SumofSqaures(userNum));
	}
	private static void getUserInput() {
		// TODO Auto-generated method stub
		System.out.println("please enter an Integer");
		Scanner keyboard = new Scanner(System.in);
		userNum=keyboard.nextInt();
		keyboard.close();
	}
	

	public static int SumofSqaures(int n)
	{
		int sum = 0;
		for( int i =1; i <=n;i++){
			sum = sum +(i+i);
		} 
		System.out.println("The sum of squares up to "+n +""+sum);
;		return sum;
	}

}
