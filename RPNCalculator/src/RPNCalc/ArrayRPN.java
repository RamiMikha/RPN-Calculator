package RPNCalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayRPN implements MyStack {
	
	//Creating an empty formulaStackay of strings with a default capacity 
	private static final int DEFAULT_CAPACITY = 10;
	private String[] formulaStack = new String[DEFAULT_CAPACITY] ;
	private int top = -1;
	
		public String top() {
		if(empty()) {
			return  "The formulaStack is Empty";
		}
		else {
			return formulaStack[top];
			
		}
		
	}
		
	public String pop() {
			String topNum = top();
			top--;
			return topNum;
		}
		
		
	
	public void push(String value) {
		
		//checking if the formulaStackay is full and creating one double the size
		if (top == formulaStack.length - 1) {
			
			String[] newStack = new String[formulaStack.length * 2];
			for (int i = 0; i < formulaStack.length; i++)
	            newStack[i] = formulaStack[i];
			
			formulaStack = newStack;
			}
		
		formulaStack[++top] = value;
		
	}
	
	public boolean empty() {
		return top == -1;
			
		}
	
	public static void main(String[] args) {
		String fileName = "myPostFix.txt";
		//creating an instance of ArrayRPN
		ArrayRPN rpn = new ArrayRPN();
		int result = 0;
		int linecount = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String formula;
			while ((formula = br.readLine())!= null) {
				
				//adding a new num to the list
				String[] formulaStack = formula.split(" ");
				for ( int i = 0; i < formulaStack.length; i++) {
					
						//checking if a character in the string a number
						// "-?" checks for negatives, "\\d+" checks for ints, 
						if(formulaStack[i].matches("-?\\d+")) {
						rpn.push(formulaStack[i]);	
						
						}
						else {
							//if it is not a int we get the top two numbers and perform the operationg
							int number2 = Integer.parseInt(rpn.pop());
							int number1 = Integer.parseInt(rpn.pop());
							
							switch(formulaStack[i]) {
							case "+":
								result = number1 + number2;
								
								break;
							case "-":
								result = number1 - number2;
			
								break;
							case "*":
								result = number1 * number2;
								break;
								
							case "/":
								result = number1 / number2;
								break;
							
							}
							rpn.push(Integer.toString(result));
						
					}
						
						
					
				}
				
				if (!rpn.empty()) {
						System.out.println("Answer to line " + ++linecount + " is: " + rpn.top());
					}
			}
            
			
	

		}catch(IOException e) {
			System.out.println("The File can not be read");
		}
		
		
		
	}
}
	
		



	


