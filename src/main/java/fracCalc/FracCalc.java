/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Welcome to the Fraction Calculator!\nInput your fraction: ");
		String fraction = userInput.nextLine();
		String solution = "";
		//receive input from user and output answer 
		while (!fraction.equals("quit")) {
			solution = produceAnswer(fraction);
			System.out.println(solution);
			System.out.print("Input your fraction: ");
			fraction = userInput.nextLine();
		}
		userInput.close();
	}

	public static String produceAnswer(String input) {
		//this method returns the answer
		String firstFrac = "";
		String operator = "";
		String secondFrac = "";
		int i = 0;
		//seperate the fraction into the first frac, second frac, and operator
		while (firstFrac == "") {
			if (input.charAt(i) == (' ')) {
				firstFrac = input.substring(0, i);
				operator = input.substring(i + 1, i + 2);
				secondFrac = input.substring(i + 3, input.length());
			} else {
				i++;
			}
		}
		//seperate each fraction into their respective parts
		int firstWhole = seperateFrac(firstFrac, "Whole");
		int firstNum = seperateFrac(firstFrac, "Numerator");
		int firstDen = seperateFrac(firstFrac, "Denominator");
		int secondWhole = seperateFrac(secondFrac, "Whole");
		int secondNum = seperateFrac(secondFrac, "Numerator");
		int secondDen = seperateFrac(secondFrac, "Denominator");
		//calculate the answer
		String decimalFrac = operation(firstWhole, secondWhole, firstNum, secondNum, firstDen, secondDen, operator);
		return decimalFrac;
	}

	public static int seperateFrac(String frac, String want) {
		//this method seperates the fraction into the numerator, denominator, and whole number
		int numerator = 0;
		int denominator = 1;
		int whole = 0;
		int i = 0;
		int j = 0;
		while (whole == 0 && i < frac.length()) {
			if (frac.charAt(i) == ('_')) {
				whole = Integer.parseInt(frac.substring(0, i));
			}
			i++;
		}
		if (i == frac.length()) {
			i = 0;
		}
		Boolean running = true;
		while (running && j < frac.length()) {
			if (frac.charAt(j) == ('/')) {
				running = false;
				numerator = Integer.parseInt(frac.substring(i, j));
				denominator = Integer.parseInt(frac.substring(j + 1, frac.length()));
			}
			j++;
		}
		if (j == frac.length()) {
			whole = Integer.parseInt(frac.substring(0, frac.length()));
		}
		if (want.equals("Numerator")) {
			return numerator;
		}
		if (want.equals("Whole")) {
			return whole;
		}
		if (want.equals("Denominator")) {
			return denominator;
		}
		return 0;

	}

	public static String operation(int whole1, int whole2, int num1, int num2, int dem1, int dem2, String operator) {
		//this method performs the operation and returns the final result
		if (whole1 < 0) {
			num1 = -num1 + whole1 * dem1;
		} else {
			num1 = num1 + whole1 * dem1;
		}
		if (whole2 < 0) {
			num2 = -num2 + whole2 * dem2;
		} else {
			num2 = num2 + whole2 * dem2;
		}
		int num = 0;
		int dem = 0;
		if (operator.equals("+")) {
			num = num1 * dem2 + dem1 * num2;
			dem = dem1 * dem2;

		} else if (operator.equals("-")) {
			num = num1 * dem2 - dem1 * num2;
			dem = dem1 * dem2;

		} else if (operator.equals("*")) {
			num = num1 * num2;
			dem = dem1 * dem2;
		} else if (operator.equals("/")) {
			num = num1 * dem2;
			dem = num2 * dem1;
		}
		int whole = num / dem;
		num -= whole * dem;
		if (num < 0 && whole != 0) {
			num *= -1;
		}
		if (dem < 0) {
			if (whole == 0 && num > 0) {
				num *= -1;
			}
			dem *= -1;
		}
		if (num > 0) {
			for (int i = num; i > 0; i--) {
				if ((num % i == 0) && (dem % i == 0)) {
					dem /= i;
					num /= i;
				}
			}
		} else if (num < 0) {
			for (int i = num; i < 0; i++) {
				if ((num % i == 0) && (dem % i == 0)) {
					dem /= i;
					num /= i;
				}
				if (dem <= 0) {
					dem *= -1;
				}
			}
		}

		if (num == 0 && whole == 0) {
			return "0";
		}
		if (num != 0 && whole == 0) {
			return num + "/" + dem;
		}
		if (num == 0 && whole != 0) {
			return whole + "";
		}
		return whole + "_" + num + "/" + dem;
	}

}
