/*
 * Palindrome.java
 * 
 * Name: Mohao Yi
 * Email: mohaoyi@bu.edu
 * 
 * This class defines a method isPal() that tests 
 * whether a string is a palindrome.
 */
package ps5;

public class Palindrome {

    // isPal - takes a String object as a parameter and determines if it is 
	// a palindrome, returning true if it is and false if it is not
	public static boolean isPal(String str) {
		
		if (str == null) {
			throw new IllegalArgumentException();
		}
		
		// Create two stacks to separately store the characters in the left half 
		// and the characters in the right half of the string
		LLStack<Character> leftStack = new LLStack<Character>();
		LLStack<Character> rightStack = new LLStack<Character>();
		
		// the index of next letter to be pushed to the leftStack
		int leftIndex = 0;
		// the index of the next letter to be pushed to the rightStack
		int rightIndex = str.length() - 1;
		// the next character from the left
		char charLeft;
		// the next character from the right
		char charRight;
		
		while (leftIndex <= rightIndex) {
			charLeft = str.charAt(leftIndex);
			charLeft = Character.toLowerCase(charLeft);
			charRight = str.charAt(rightIndex);
			charRight = Character.toLowerCase(charRight);
			
			// keep looping until we find the closest 
			// letter from the left, ignoring the non-letter ones
			if ((charLeft > 'z') || (charLeft < 'a')) {
				leftIndex ++;
				continue;
			}
			// keep looping until we find the closest 
			// letter from the right, ignoring the non-letter ones
			if ((charRight > 'z') || (charRight < 'a')) {
				rightIndex --;
				continue;
			}
			
			// push the pair of characters to the stacks, respectively
			leftStack.push(charLeft);
			rightStack.push(charRight);
			// update both the left and right indices
			leftIndex ++;
			rightIndex --;
			
		}

		// comparing each pair of letters
		while (! leftStack.isEmpty()) {
			Character leftChar = leftStack.pop();
			Character rightChar = rightStack.pop();
			if (!leftChar.equals(rightChar)) {
				return false;
			}
		}
		
		return true;
		
		
	}
	
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        
        // Additional Tests:
        
        // Test 1.
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(1) Testing on \"\"");
        try {
            boolean results = isPal("");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
        
        // Test 2.
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(2) Testing on \",,!!@@,@\"");
        try {
            boolean results = isPal(",,!!@@,@");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
        
        // Test 3.
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(3) Testing on \",,!!a@@,@\"");
        try {
            boolean results = isPal(",,!!a@@,@");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
        
        // Test 4.
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(4) Testing on \"a,,!!@@,b@c\"");
        try {
            boolean results = isPal("a,,!!@@,b@c");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
        
     	// Test 5.
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(5) Testing on \"A Santa! Lived As a Devil At!! NASA!!!\"");
        try {
            boolean results = isPal("A Santa! Lived As a Devil At!! NASA!!!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();
    }
}