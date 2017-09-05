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
	
	public static void toImproperFrac (int num1, int num2, int num3) {
		double improperFrac = (num1*num3) + num2;
		
	}
}
