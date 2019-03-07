package Stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackExamples {
	public static boolean hasBalanacedBraces(String s) throws StackException
	{
		Stack <Character> bracesStack = new Stack<Character>();
		for(int i =0; i<s.length();i++)
		{
			if(s.charAt(i)=='{')
			{
				bracesStack.push(s.charAt(i));
			}
			else if(s.charAt(i) == '}')
			{
				bracesStack.pop();
			}
		}
		if(bracesStack.isEmpty())
		{
			return true;
			
		}
		else
		{
			System.out.println("NOT Balanced..");
			return false;
		}
	}
	public static boolean isReversibleAroundMidChar(String s, char midChar)
	{
		Stack <Character> cStack = new Stack <Character>();
		int index = 0;
		 char ch = s.charAt(0);
		 while((ch != midChar ) && (index < s.length()/2))
		{
			 cStack.push(ch);
			 index++;
			 ch= s.charAt(index);
		 }
		 try{
			 while(index < s.length())
			 {
				 ch =s.charAt(index);
				 index++;
				if(ch!=cStack.pop())
				{
					System.out.println("mismatch");
					return false;
				}
			 }
		 }
		 catch(EmptyStackException e)
		 {//first half shorter
			 return false;
		 }
		 if(cStack.isEmpty())
		 {
			 return true;
		 }
		 else{
			 //last half shorter
			 return true;
			 
		 }
	}
	public static void main(String[] args) throws StackException
	{
		String blah = "{a{b'{}}}}";
		System.out.println("is or is not balanced" + hasBalanacedBraces(blah));
	}

}
