package ie.gmit.dip;

import java.util.Arrays;
import java.util.Scanner;

public class RailFenceCypher {
	
/*
 * Code adopted and modified from: 
 * https://exercism.io/tracks/java/exercises/rail-fence-cipher/solutions/bb4b033b643b4d72b933f6bbf1591247
 * https://www.geeksforgeeks.org/rail-fence-cipher-encryption-decryption/
 */

	private int key;
	public static Scanner s;


	
	
	  public char[][] initialiseMatrix(String inputText, int key) {
	        char[][] railMatrix = new char[key][inputText.length()];
	        
	        // Populate matrix with null chars
	        for (int rail = 0; rail < railMatrix.length; rail ++) {
	            for (int railChar = 0; railChar < railMatrix[rail].length; railChar ++) {
	                railMatrix[rail][railChar] = '\0';
	            }
	        }
	        
	        int check = -1;
	        int inputRow = 0;
	        int inputCol = 0;
	        
	        // Loop over input characters
	        for(int i = 0; i < inputText.length(); i ++){
	            railMatrix[inputRow][inputCol++] = inputText.charAt(i);
	            
	            // Adjust target row offset at beginning/end of array
	            if(inputRow == 0 || inputRow == key-1) {
	                check = check * (-1);
	            }
	            
	            inputRow = inputRow + check;
	        }
	        
	        return railMatrix;
	    }
	  
	  //
	  
	  public String encrypt(String inputText, String stuff) {
		  
		  if(stuff.contains("quack")) {
			  return encrypt(inputText, 4, 0);
		  }
		  
		  return encrypt(inputText, key, 0);
		  
	  }
	  public String encrypt(String inputText, int key) {
			  return encrypt(inputText, key, 0);
	  }
	  public String encrypt(String inputText, int key, int offset) {
	        char[][] railMatrix = initialiseMatrix(inputText, key);
	        char[] cipherChars = new char[inputText.length()];
	        int n = 0;
	        
	        int ii = offset;
	        
	        for (int i = 0; i < key; i ++) {
	        	if(ii >= key) {
		        	ii -= key;
		        }
	            for (int j = 0; j < inputText.length(); j ++) {
	                if(railMatrix[ii][j] != '\0') {
	                    cipherChars[n++] = railMatrix[ii][j];
	                }
	            }
	            
	            ii++;
	        }

	        
	        //print2dCharMatrix(railMatrix);
	        return String.valueOf(cipherChars);
	    }

	   public String decrypt(String inputText, int key, int offset) {
	        char[][] railMatrix = initialiseMatrix(inputText, key);
	        char[] decryptedChars = new char[inputText.length()];
	        
	        int inputCharCount = 0;
	        int ii = offset;

	        for (int i = 0; i < key; i ++) {
	        	if(ii>=key) {
		        	ii -= key;
		        }
	        	for (int j = 0; j < inputText.length(); j ++) {
	                if(railMatrix[ii][j] != '\0') {
	                    railMatrix[ii][j] = inputText.charAt(inputCharCount++);
	                }
	            }
	        	ii++;
	        }
	        
	        int decryptedCharCount = 0;
	        int check = -1;
	        int inputRow = 0;
	        int inputCol = 0;
	        
	        // // Loop over input characters
	        for(int i = 0; i < inputText.length(); i ++){
	            decryptedChars[decryptedCharCount++] = railMatrix[inputRow][inputCol++];
	  
	            // Adjust target row offset at beginning/end of array
	            if(inputRow == 0 || inputRow == key-1) {
	            	check = check * (-1);
	            }
	            
	            inputRow = inputRow + check;
	        }

	        //print2dCharMatrix(railMatrix);
	        return String.valueOf(decryptedChars);
	    }

	public void print2dCharMatrix(char[][] matrix) {
		for (char[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}