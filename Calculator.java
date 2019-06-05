/*
* File Name : Calculator.java
*
* The Science of Data Structures
*
* Course : CSC172 SPRING 2015
*
* Assignment : PROJECT 2
*
* Author : Annabelle Taylor
*
* Lab Partner : n/a
*
* Lab Session : TR 4:50-6:05 pm
*
* Lab TA : Pauline Chen
*
* Last Revised : March 8, 2015
*
*/

public class Calculator
{
	String[] expression;
	public Calculator(String[] expression)
	{
		this.expression = expression;
	}
	MyQueue postfix = new MyQueue();
	MyStack operator = new MyStack();

	public MyQueue parseArray()
	{
		// go through entire expression
		for (int i = 0; i < expression.length; i++)
		{
			// if current place in array is an operand
			if (isNumber(expression[i]))
			{
				postfix.enqueue(expression[i]);
			}
			
			// arithmetic operators
			else if (expression[i].equals("+") || expression[i].equals("-") || expression[i].equals("!"))
			{
				if (operator.peek() == null)
				{
					operator.push(expression[i]);
				}
				else if (operator.peek() != null)
				{
					while (operator.peek()!=null && (operator.peek().equals("*") ||
													 operator.peek().equals("/") ||
													 operator.peek().equals("^") || 
													 operator.peek().equals("=") ||
													 operator.peek().equals("&") ||
													 operator.peek().equals("|") ||
													 operator.peek().equals("<") ||
													 operator.peek().equals(">")))
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
			
			else if (expression[i].equals("*") || expression[i].equals("/") || expression[i].equals("%"))
			{
				if (operator.peek() == null)
					operator.push(expression[i]);
				else if (operator.peek() != null)
				{
					while (operator.peek()!=null && (operator.peek().equals("^") ||
													 operator.peek().equals("=") ||
													 operator.peek().equals("&") ||
													 operator.peek().equals("|") ||
													 operator.peek().equals("<") ||
													 operator.peek().equals(">")))
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
			
			else if (expression[i].equals("^"))
			{
				if (operator.peek() == null)
					operator.push(expression[i]);
				else if (operator.peek() != null)
				{
					if (operator.peek()!=null && (operator.peek().equals("=") ||
												  operator.peek().equals("&") ||
												  operator.peek().equals("|") ||
												  operator.peek().equals("<") ||
												  operator.peek().equals(">")))
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
			
			// logical operators
			else if (expression[i].equals("="))
			{
				if (operator.peek() == null)
					operator.push(expression[i]);
			
				else if (operator.peek() != null)
				{
					while (operator.peek()!=null && (operator.peek().equals("<") ||
													 operator.peek().equals(">") ||
													 operator.peek().equals("&") ||
													 operator.peek().equals("|")))
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
					 
			else if (expression[i].equals("&"))
			{
				if (operator.peek() == null)
					operator.push(expression[i]);
			
				else if (operator.peek() != null)
				{
					while (operator.peek()!=null && (operator.peek().equals("<") ||
													 operator.peek().equals(">") ||
													 operator.peek().equals("|")))
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
			
			else if (expression[i].equals("|"))
			{
				if (operator.peek() == null)
					operator.push(expression[i]);
			
				else if (operator.peek() != null)
				{
					while (operator.peek()!=null && (operator.peek().equals("<") ||
													 operator.peek().equals(">")))
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
			
			else if (expression[i].equals("<") ||
					 expression[i].equals(">"))
			{
				if (operator.peek() == null)
					operator.push(expression[i]);
				else if (operator.peek() != null)
				{
					while (operator.peek()!=null)
					{
						postfix.enqueue(operator.pop());
					}
					operator.push(expression[i]);
				}
			}
			
			// parenthesis
			else if (expression[i].equals("("))
				operator.push(expression[i]);
			
			else if (expression[i].equals(")"))
			{
				while (operator.peek() != null && !operator.peek().equals("("))
				{
					postfix.enqueue(operator.pop());
				}
				if (operator.peek() != null && operator.peek().equals("("))
					operator.pop();
			}
		}

		// after everything is in stack or queue, pop everything from stack and enqueue to create expression
		while(operator.isEmpty() == false)
		{
			postfix.enqueue(operator.pop());
		}
		return postfix;
	}
	
	public double calculations(MyQueue postfix)
	{
		double finalAnswer = 0; // initially set
		while (postfix.isEmpty() != true)
		{	
			if (isNumber(postfix.peek())==true)
			{
				operator.push(postfix.peek());
			}
			
			// arithmetic
			else if (postfix.peek().equals("+"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				finalAnswer = a + b;
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("-"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				finalAnswer = b - a;
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("*"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				finalAnswer = a*b;
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("/"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				finalAnswer = b % a;
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("^"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				finalAnswer = Math.pow(b, a);
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("%"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				finalAnswer = b % a;
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			// logical expressions
			else if (postfix.peek().equals("<"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				if ((b < a) == true)
					finalAnswer = 1;
				else
					finalAnswer = 0;
				
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals(">"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				if ((b > a) == true)
					finalAnswer = 1;
				else
					finalAnswer = 0;
				
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("="))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				if ((b==a) == true)
					finalAnswer = 1;
				else
					finalAnswer = 0;
				
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("&"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				if ((b==a) == true)
					finalAnswer = 1;
				else
					finalAnswer = 0;
				
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("|"))
			{
				double a = Double.parseDouble(operator.pop());
				double b = Double.parseDouble(operator.pop());
				
				if (b==1 || a==1)
					finalAnswer = 1;
				else
					finalAnswer = 0;
				
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			
			else if (postfix.peek().equals("!"))
			{
				double a = Double.parseDouble(operator.pop());
				
				if (a==1)
					finalAnswer = 0;
				else
					finalAnswer = 1;
				
				String answer = "" + finalAnswer;
				operator.push(answer);
			}
			postfix.dequeue();	
		}	
		return finalAnswer;
	}
		
	// method takes a String to see if it can be parsed into a double (is a number) or cannot (is an operator)
	public boolean isNumber(String str)
	{
		try
		{
			Double.parseDouble(str);
            return true;
        }
        
		catch( Exception e )
		{
            return false;
		}
	}
}
	