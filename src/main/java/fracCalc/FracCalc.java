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
		return secondFrac;
    }
//    public static String seperateFrac (String frac) {
//    	String numerator = "";
//    	String denominator = "";
//    	String whole = "";
//    	int i = 0;
//    	while (numerator =="") {
//    		if (frac.charAt(i)== ('_')) {
//    			whole = frac.substring(0, i);
//    		}
//    		else {
//    			if (i < frac.length()) {
//    				i++;
//    			}
//    			else {
//    				whole
//    		}
//    	}
//    }
}
