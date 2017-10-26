/*Madeline Hain
 * September 5, 2017
 * This is our homegrown library that will contain various mathematical methods.
*/

public class Calculate {
	
/* This method takes an integer and returns its square.
 */
	public static int square (int operand) {
		return operand*operand;
	}
	
	public static int cube (int operand) {
		return operand*operand*operand;
	}
	
	public static double average (double operand1, double operand2, double operand3) {
		double average = (operand1 + operand2 + operand3)/3;
		return average;
	}
	
	public static double toDegrees (double radian) {
		double degree = (radian*180)/3.14159;
		return degree;
	}
	
	public static double toRadians (double angle) {
		double radian = (angle*3.14159)/180;
		return radian;
	}
	
	public static double discriminant (double a, double b, double c) {
		double discriminant = (b*b) - (4*a*c);
		return discriminant;
	}
	
	public static String toImproperFrac (int num1, int num2, int num3) {
		int improperFrac = (num1*num3) + num2;
		return improperFrac + "/" + num3;
	}

	public static String toMixedNum (int topNum, int bottomNum) {
		int mixedNum = topNum/bottomNum;
		return mixedNum + " " + topNum%bottomNum + "/" + bottomNum;
	}
	
	public static String foil (int a, int b, int c, int d, String letter) {
		int firstTerm = a * c;
		int secondTerm = b + d;
		int thirdTerm = b * d;
		String foil = firstTerm + letter + "^2" + " + " + secondTerm + letter + " + " + thirdTerm;
		return foil;
	}
	
	public static boolean isDivisibleBy (int a, int b) {
		boolean divisible = a % b == 0;
		return divisible;
	}

	public static double absValue (double a) {
		if (a < 0) {
			a *= -1;
			return a;
		} else {
			return a;
		}
	}

	public static double max (double a, double b, double c) {
		if (a > b && a > b) {
			return a;
		} else if (b > a && b > c) {
			return b;
		} else {
			return c;
		}
	}
	
	public static int min (int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static double round2 (double a) {
		double result = 0.0;
		
		int tempInt = (int)(a * 1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt / 10;
		if (roundNum >= 5 && tempInt > 0)
			tempInt++;
		else if(roundNum <= -5 && tempInt < 0)
			tempInt--;
		result = tempInt / 100.0;
		return result;
	}
	
	public static double exponent (double a, int b) {
		double result = 1;
		for (int i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
	
	public static int factorial (int a) {
		int result = 1;
		for (int i = 1; i <= a; i++) {
			result = result *= i;
		}
		return result;
	}
	
	public static boolean isPrime (int a) {
		int factor = 2;
		while(!isDivisibleBy (a, factor)) {
			factor++;
		}
		if(factor == a) {
			return true;
		} else {
			return false;
		}
	}
	
//	public static int gcf (int a, int b) {
		
//	}
}