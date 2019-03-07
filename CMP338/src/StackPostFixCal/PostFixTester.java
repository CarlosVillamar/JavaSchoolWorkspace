package StackPostFixCal;

public class PostFixTester {

	public static void main(String[] args)
	{
		String s = "56*8-";
		String c = "a/b+c";
		System.out.println("RESULT of" + s+ "is " + PostFixCalculator.evalPostFix(s));
		System.out.println("RESULT of" + c+ "is " + PostFixCalculator.getPostFixFromInfix(c));
		
	}
}
