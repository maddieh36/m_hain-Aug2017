/* Madeline Hain
 * December 16, 2017
 * FracCalc with objects & 3rd Checkpoint
 */

package fracCalc;

public class Fraction {
	private String sign;
	private int whole;
	private int numerator;
	private int denominator;
	
	public Fraction(String equation) {
    	// Declaring all variables needed for this method.
		String[] splitEquation = equation.split(" ");
        String firstFrac = splitEquation[0];
        String operator = splitEquation[1];
        this.sign = operator;
        String secondFrac = splitEquation[2];
        
        // Sends fractions to splitOperand to split each operand into an array.
        String[] firstFracSplit = splitOperand(firstFrac); 
        String[] secondFracSplit = splitOperand(secondFrac);
        int[] firstFracNums = new int[3]; 
        int[] secondFracNums = new int[3];
        
        // Parse the integers from a String to an int so it can be used in math.
        for (int i = 0; i < firstFracSplit.length; i++) {
        	firstFracNums[i] = Integer.parseInt(firstFracSplit[i]);
        	secondFracNums[i] = Integer.parseInt(secondFracSplit[i]);
        }
        
        // Creates array of the improper operands.
        int[] firstFracImproper = toImproperFrac(firstFracNums[0], firstFracNums[1], firstFracNums[2]);
        int[] secondFracImproper = toImproperFrac(secondFracNums[0], secondFracNums[1], secondFracNums[2]);
        int[] answer = new int[2];
        
        // Sends the equation to a method to either multiply/divide or subtract/add.
        if (sign.equals("*") || sign.equals("/")) {
        	answer = multiplicationOrDivision(firstFracImproper, secondFracImproper);
        } else if (sign.equals("-") || sign.equals("+")) {
        	answer = subtractionOrAddition(firstFracImproper, secondFracImproper);
        }
        
        this.numerator = answer[0];
        this.denominator = answer[1];
	}
	
   	private String[] splitOperand(String fraction) {
    	// Default for the fraction, String variables for now.
   		String whole = "0";
    	String denominator = "1";
    	String numerator = "0";
    	
    	// Only a whole number, no fraction.
    	if (!(fraction.contains("/")) && !(fraction.contains("_"))) {
    		whole = fraction;
    	}
    	
    	// Both a whole number and a fraction.
    	if (fraction.contains("_")) {
    		String[] splitWholeAndFrac = fraction.split("_");
    		whole = splitWholeAndFrac[0];
    		String[] fractionOfOperand = splitWholeAndFrac[1].split("/");
    		numerator = fractionOfOperand[0];
    		denominator = fractionOfOperand[1];
    	}
    	
    	// Just a fraction, no whole number.
    	if (fraction.contains("/") && !(fraction.contains("_"))) {
    		String[] splitFractionOnly = fraction.split("/");
    		numerator = splitFractionOnly[0];
    		denominator = splitFractionOnly[1];
    	}
    	
    	String[] splitOperandResult = {whole, numerator, denominator};
    	
    	return splitOperandResult;
    	
    }
   	
   	// This is toImproperFrac method from Calculate Library, turns mixed numbers to improper fractions.
	private int[] toImproperFrac(int wholeNum, int nume, int denom) {
		int improperFraction = (wholeNum * denom);
		
		if (wholeNum >= 0) {
			improperFraction += nume;
		} else {
			improperFraction -= nume;
		}
		
		int[] improperFractionArray = {improperFraction, denom};
		
		return improperFractionArray;
	}
   	
   	// Multiplies or divides fractions.
	public int[] multiplicationOrDivision(int[] firstFrac, int[] secondFrac) {
		// Initializes default variables for the answer.
		int nume = 0;
		int denom = 1;
		
		// If division, changed secondFrac to its reciprocal.
		if (sign.equals("/")) {
			int newSecondDenom = secondFrac[0];
			secondFrac[0] = secondFrac[1];
			secondFrac[1] = newSecondDenom;
		}
		
		// Multiplies fractions' numerators and denominators for final.
		nume = firstFrac[0] * secondFrac[0];
		denom = firstFrac[1] * secondFrac[1];
		
		// If both nume and denom are negative, simplify to positive.
		if (nume < 0 && denom < 0) {
			nume = -nume;
			denom = -denom;
		}
		
		int[] answer = {nume, denom};
		return answer;
	}
	
	// Adds or subtracts the fractions.
	public int[] subtractionOrAddition(int[] firstFrac, int[] secondFrac) {
		// Finds common denominator of both fractions.
		int commonDenom = firstFrac[1] * secondFrac[1];
		firstFrac[0] *= secondFrac[1];
		secondFrac[0] *= firstFrac[1];
		
		// Default numerator.
		int nume = 0;
		
		// If subtraction, change secondFrac to negative.
		if (sign.equals("-")) {
			secondFrac[0] = -secondFrac[0];
		}
		
		// Adds both fractions' numerators.
		nume = firstFrac[0] + secondFrac[0];
		
		int[] result = {nume, commonDenom};
		return result;
	}

	// From here on, the remaining methods are used to reduce the answer.
	
	// This method first changes the answer from above into a string, and gets the numerator and denominator from the fraction object.
   	public String getFinalAnswer(Fraction answer) {
   		String finalAnswer = reduceFrac(numerator, denominator);
   		return finalAnswer;
   	}
   	
   	
   	// This method is the one that reduces the fraction.
	private String reduceFrac(int num, int denom) {
		String reducedFraction = "";
		int commonFactor = gcf(num, denom);
		num = num/commonFactor;
		denom = denom/commonFactor;
		
		if (denom < 0 && num > 0) {
			denom = -denom;
			num = -num;
		}
		if ((num < 0 && num < denom) || num > denom) {
			reducedFraction = toMixedNum(num, denom);
			if (reducedFraction.charAt(0) == '0') {
				reducedFraction = num + "/" + denom;
			}
		} else {
			reducedFraction = num + "/" + denom;
		}
		if (num == 0) {
			reducedFraction = "0";
		}
		if (denom == 1) {
			reducedFraction = num + "";
		}
		return reducedFraction;
	}

	
	// Finds GCF of two numbers.
	private int gcf(int firstNum, int secondNum) {
		int result = 1;
		firstNum = absValue(firstNum);
		secondNum = absValue(secondNum);
		for (int i = 1; i <= min(firstNum, secondNum); i++) {
			if (isDivisibleBy(firstNum, i) && isDivisibleBy(secondNum, i)) {
				if (result < i) {
					result = i;
				}
			}
		}
		return result;
	}
	
	// Returns absolute value.
	private int absValue(int number) {
		if (number < 0) {
			return -number;
		} else {
			return number;
		}
	}
	
	// Checks if a value can be divided by another value.
	private boolean isDivisibleBy(int firstNum, int secondNum) {
		return firstNum % secondNum == 0;
	}
	
	// Takes two numbers and returns the smallest.
	private int min(int firstNum, int secondNum) {
		if (firstNum < secondNum) {
			return firstNum;
		} else {
			return secondNum;
		}
	}
	
	// Changes an improper fraction to a mixed number.
	private String toMixedNum(int nume, int denom) {
		int result = nume / denom;
		int newNume = nume % denom;
		if (result == 0) {
			return result + "_" + (int) newNume + "/" + (int) denom;
		} else {
			return result + "_" + (int) absValue(newNume) + "/" + (int) absValue(denom);
		}
	}
	
}