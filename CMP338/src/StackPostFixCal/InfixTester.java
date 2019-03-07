package StackPostFixCal;

public class InfixTester {
	public static void main(String[] args) {

		String s = "3+(5*2)";
		String postExpr = PostFixCalculator.getPostFixFromInfix(s);
		System.out.println("RESULT of "+postExpr+" is " +PostFixCalculator.evalPostFix(postExpr));

	}
}
