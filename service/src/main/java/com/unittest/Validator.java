package com.unittest;
import java.util.*;
import java.io.*;
import java.util.regex.*;
import org.apache.commons.lang3.*;
public class Validator {
    final Scanner input = new Scanner(System.in);
    
    public String validateStrLength(String str) {
        boolean isNotValid = true;
        
        if(str.length() > 3 || str.length() < 1) {
			while(isNotValid) {
				str = input.nextLine();
				
				if(str.length() <= 3 && str.length() >= 1) {
					isNotValid = false;
				}else {
					System.out.print("Invalid input! Please try another: ");
				}
			}
		}
        return str;
    }
    
    public String createAsciiKey() {
		List<String> uniqueKeys = new ArrayList<String>();
		
		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String asciiKey = "";
		char tempChar;
		int x = 0;
        boolean isUnique = false;
		
		while (x < 3) {
			int randomAlphaNumeric = (int) (Math.random() * alphaNumeric.length()-1);
			tempChar = alphaNumeric.charAt(randomAlphaNumeric);
			asciiKey += tempChar;
			x++;
		}
		
        asciiKey = asciiKey.toUpperCase();
		
        while(isUnique) {
            if ( uniqueKeys.contains(asciiKey)) {
                asciiKey = RandomStringUtils.randomAscii(3).toUpperCase();
            }else {
                isUnique = false;
            }
        }
		
		return asciiKey.toUpperCase();
	}
    
    public int checkIntegerInput(int numInput, int min, int max) {
		boolean isNotValid = true;
		
		while (isNotValid) {
            try{
                if(numInput <= max && numInput >= min) {
                    isNotValid = false;
                }else {
                    System.out.print("Input out of range! Please enter 1-" + max + " only: ");
                    numInput = input.nextInt();
                }  
            }
            catch(InputMismatchException e){
                System.out.print("invalid input! Please try another: ");
                numInput = input.nextInt();
            }finally{}
		}
        System.out.println("");
		return numInput;
	}
}