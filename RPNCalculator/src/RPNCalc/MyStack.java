package RPNCalc;

public interface MyStack {
	public String top();
	public String pop();
	public void push(String value);
	public boolean empty();
	
}

//Sources used
//for copying arrays
//https://www.geeksforgeeks.org/arr-copy-in-java/
//for checking if a variable is an int:
//https://www.baeldung.com/java-check-string-number#:~:text=3.-,Using%20Plain%20Java,Double.parseDouble(String)
//using switch
//https://www.w3schools.com/java/java_switch.asp