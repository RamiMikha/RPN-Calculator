package RPNCalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class LinkedListRPN implements MyStack{
	
    
	
	//creating the linked list
    private class Node {
        String value;
        Node next; 
        
        Node(String value) {
        	this.value = value;
        	this.next = null;
        	}
        }
    private Node head;
    
   	public String top() {
		if (empty()) {
			String isEmpty = "The List is Empty";
			return isEmpty;
		}
		else return head.value;
	}
	public String pop() {
		String topNum = top();
		head = head.next;
		return topNum;
		
	}
	public void push(String value) {
		Node newNode = new Node(value);
		newNode = head.next;
		head = newNode;
		
	}
	public boolean empty() {
		return head == null;
		
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

//Sources 
// https://www.simplilearn.com/tutorials/java-tutorial/linked-list-in-java for creating Node in linked list

