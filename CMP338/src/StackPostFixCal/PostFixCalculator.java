package StackPostFixCal;

import java.util.Stack;

public class PostFixCalculator 
{

	public static int evalPostFix(String s){
		int result =0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<s.length(); i++){
		
				char ch = s.charAt(i);
				if(Character.isDigit(ch)){//operand...
				System.out.println("push" + stack.push(Character.getNumericValue(ch)));//print if you like
			}
			else if(isOperator(ch)){//operator pop pop calculate push result
				
					int op2 = stack.pop();//print if you like
					System.out.println("pop" + op2);
					
					int op1 = stack.pop();//print if you like
					System.out.println("pop" + op1);
					System.out.println(isOperator(ch));
					
					result =  getResult(op1, ch, op2);
					
					stack.push(result);//print if you like
					System.out.println("push" + result);
				}
		}
			return result;
	}
	public static int getResult(int op1, char ch, int op2){
		
		int result = 0;
		
		switch(ch){
			case '+':
				result = (op1 + op2);
				break;
			case '-':
				result = (op1 - op2);
				break;
			case '*':
				result = (op1 * op2);
				break;
			case '/':
				result = (op1 / op2);//dividing by zero.. would be a problem
				break;
		}
		return result;
	}
	
	public static boolean isOperator(char ch){
		switch(ch){
			
			case '+':
			case '-':
			case '*':
			case '/':
				return true;
				
			default:
				return false;
		}
	}

	public static boolean lowerPrec(char ch1, char nextCh){
		switch(ch1){
			
			case '+':
			case '-':
				return ( (nextCh == '*') ||  (nextCh == '/'));
			case '*':
			case '/':	
				if(  (nextCh == '*') ||  (nextCh == '/') || (nextCh == '+') ||  (nextCh == '-')){
					return false;
				}
			default:
				return false;
		}
	}
	public static String getPostFixFromInfix(String s){
		
		
		Stack<Character> stack = new Stack<Character>();
		String postfix = "";
		
		for(int i=0; i<s.length(); i++){  
			char ch = s.charAt(i);
			
			if(Character.isDigit(ch)){//if operand append ch to postfix
				postfix += ch;
				
			}
			else if(ch == '('){//if '(' push the '('
				stack.push(ch); 
				
			}
			else if(ch == ')' ){// ')'
				//while stack is not empty and while it is not '(' 
				while( (!stack.isEmpty())  && (stack.peek() != '(') ){
					postfix += stack.pop(); // pop from the stack and append to postfix
					
				}
				stack.pop();//pop one more time to discard the '('
				
			}
			else if(isOperator(ch)){//else if operator
				while((!stack.isEmpty())  && (stack.peek() != '(') && lowerPrec(ch, stack.peek() ) ){//while stack is not empty and while it is not (  and while lower preced than next char
				      postfix += stack.pop();// pop from the stack and append to postfix
				}
				stack.push(ch);//after the while push the operator onto the stack
			}	
			else{
				System.out.print("DUNNO what "+ch+ " is");
				//not so great of an expression... 
			}
		}
		// afterward... pop everything from the stack and append to postfix as we go...
		while(!stack.isEmpty()){
			postfix += stack.pop();
		}
		return postfix;
	}
}



