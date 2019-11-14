/**
 * @author Mr. Rasmussen
 */
package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args){
		Scanner userInput = new Scanner (System.in);
		System.out.print("Input your fraction: ");
		String fraction = userInput.nextLine();
		String firstFrac = "";
    	while (!fraction.equals("quit")) {
    		firstFrac = produceAnswer(fraction);
        	System.out.println(firstFrac);
    		System.out.print("Input your fraction: ");
    		fraction = userInput.nextLine();
    	}
    }
    
    public static String produceAnswer(String input){
    	String firstFrac = "";
    	String operator = "";
    	String secondFrac = "";
    	int i = 0;
    	while (firstFrac == "") {
    		if (input.charAt(i)== (' ')) {
    			firstFrac = input.substring(0, i);
    			operator = input.substring(i+1, i+2);
    			secondFrac = input.substring(i+3, input.length());
    		}
    		else {
    			i++;
    		}
    	}
//    	secondFrac = seperateFrac(secondFrac);
//		return secondFrac;
    	return seperateFrac(secondFrac);
    }
    public static String seperateFrac (String frac) {
    	int numerator = 0;
    	int denominator = 1;
    	int whole = 0;
    	int i = 0;
    	int j = 0;
    	while (whole==0 && i < frac.length()) {
    		if (frac.charAt(i)== ('_')) {
    			whole = Integer.parseInt(frac.substring(0, i));
    		}
    		i++;
    	}
    	if (i == frac.length()) {
    		i = 0;
    	}
//    	if (i == frac.length()) {
//    		whole = Integer.parseInt(frac.substring(0,i));
//    	}
    	while (numerator== 0 && j < frac.length()) {
    		if (frac.charAt(j)== ('/')) {
    			numerator = Integer.parseInt(frac.substring(i, j));
    			denominator = Integer.parseInt(frac.substring(j+1, frac.length()));
    		}
    		j++;
    	}
    	if (j ==frac.length()) {
    		whole = Integer.parseInt(frac.substring(0, frac.length()));
    	}
    	return ("whole:"+whole+ " numerator:"+ numerator + " denominator:"+ denominator);
    }
}
