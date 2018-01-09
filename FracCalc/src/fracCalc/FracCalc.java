/* Madeline Hain
 * December 14, 2017
 * FracCalc client code
 */ 

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	Boolean keepGoing = true;
    	
    	while(keepGoing == true) {
    		String userInput = input.nextLine();
    		
    		if (userInput.equals("Quit") || userInput.equals("quit")) {
    			keepGoing = false;
    		} else {
        		System.out.println(produceAnswer(userInput));
    		}
    	}
    	
    	input.close();
    }
   
    public static String produceAnswer(String input) { 
        Fraction answer = new Fraction(input);
        String answerInString = answer.getFinalAnswer(answer);
        
        return answerInString;
    }
 
}