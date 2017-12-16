package fracCalc;

import java.util.Arrays;
import java.util.Scanner;
//Madeline Hain
//November 7, 2017
//This code takes in an input of a equation, and returns the second operand.
public class FracCalc {
	
	

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your equation: ");
		String equation = sc.nextLine();
		System.out.println(produceAnswer(equation));
		sc.close();
		
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
		String[] equationArray = input.split(" ");
	
		String firstOperand = equationArray[0];
		String operator = equationArray[1];
		String secondOperand = equationArray[2];
		
		return secondOperand;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
