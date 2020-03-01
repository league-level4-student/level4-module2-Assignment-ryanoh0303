package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s2.length()> s1.length()) {
			return s2;
		}
		else {
			return s1;
		}
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		
		if(s.contains("underscores")){
			s=s.replace(" ","_");
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String temp= s1.replace(" ", "");
		String temp2=s2.replace(" ", "");
		String temp3= s3.replace(" ", "");
		String p1 = "";
		String p2= "";
		String p3 = "";
		s1 = s1.trim();
		s2= s2.trim();
		s3=s3.trim();
		for(int i=0; i<temp.length(); i++) {
			if(Character.isUpperCase(temp.charAt(i))) {
				 p1 = ""+temp.charAt(i);
			}
		}
		for(int i=0; i<temp2.length(); i++) {
			if(Character.isUpperCase(temp2.charAt(i))) {
				 p2 = ""+temp2.charAt(i);
			}
		}
		for(int i=0; i<temp3.length(); i++) {
			if(Character.isUpperCase(temp3.charAt(i))) {
				 p3 = ""+temp3.charAt(i);
			}
		}

		char x1= p1.charAt(0);
		char x2 = p2.charAt(0);
		char x3 = p3.charAt(0);
		ArrayList<Character> arr= new ArrayList<>();
		arr.add(x1);
		arr.add(x2);
		arr.add(x3);
		Collections.sort(arr);
		
		
		if(x1==arr.get(0)) {
			return s1;
		}
		if(x2==arr.get(0)) {
			return s2;
		}
		else {
			return s3;
		}
		
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int counter = 0;
		String character="abcdefghijklmnopqrstuvwxyz";
		for(int i=0; i<s.length(); i++) {
			if(character.contains(""+s.charAt(i))) {
				
			}
			else {
				counter+= Integer.parseInt(""+s.charAt(i));
			}
			
		}
		
		
		return counter;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int sum =0;
		for(int i=0; i<s.length()-substring.length()+1; i++) {
			if(s.substring(i,i+substring.length()).equals(substring)) {
				
		
				sum+=1;
			}
			
		}
				return sum;
		
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		String x =Utilities.encrypt(s.getBytes(), (byte) key);
		
		
		
		
		return x;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String x= Utilities.decrypt(s, (byte) key);
		return x;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		ArrayList<Integer> spacing = new ArrayList<>();
		int sum =0;
		int counter =0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==' ') {
				counter+=1;
				spacing.add(i);
			}
		}
		for(int i=0; i<counter; i++) {
			String x= s.substring(i, s.indexOf(' ',spacing.get(i) ));
			if(x.endsWith(substring)) {
				sum+=1;
			}
		}
		
		return sum;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		int counter = s.indexOf(substring);
		int counter2 = s.lastIndexOf(substring);
		return counter2-counter-substring.length();
		
		
		
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String temporary ="";
		s= s.replace(" ", "");
		s=s.toLowerCase();
		String character= "abcdefghijklmnopqrstuvwxyz";
		for(int i =0; i<s.length();i++) {
			if(character.contains(""+s.charAt(i))) {
				
			}
			else {
				s=s.replace(""+s.charAt(i),"");
			}
		}
		for(int i=s.length()-1; i>=0; i--) {
			temporary=temporary+""+s.charAt(i);
		}
	
		if(temporary.equals(s)) {
			return true;
		}
		return false;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
