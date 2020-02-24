/*
 * author: Matthew Proctor
 * CMSC-203 22656
 * 10/13/2019
 * 
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		//Create and initialize method variables
				boolean inRange = false;
				int value = 0;
				
				//Creates array of chars
				char[] plainTextArray = plainText.toCharArray();
				
				//Check range of chars
				for(int i = 0; i < plainTextArray.length; i++) {
					if(plainTextArray[i] < LOWER_BOUND || plainTextArray[i] > UPPER_BOUND) {
						++value;
					}
					
				}
				//returns false if any chars out of bounds
				if(value > 0) {
					inRange = false;
				}
				else {
					inRange = true;
				}
				
				return inRange;
			
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
				
				//Create array of chars
				char[] plainTextArray = plainText.toCharArray();
				
				//Loops through array and replaces chars
				for(int i = 0; i < plainTextArray.length; i++) {
					plainTextArray[i] = (char) (plainTextArray[i] + key);
					//sets char to range
					if(plainTextArray[i] < LOWER_BOUND) {
						while(plainTextArray[i] < LOWER_BOUND) {
							plainTextArray[i] += RANGE;
						}
					}				
					else if(plainTextArray[i] > UPPER_BOUND) {
						while(plainTextArray[i] > UPPER_BOUND) {
							plainTextArray[i] -= RANGE;
						}
					}	
				}
				
				//Create String from array
				String newText = String.valueOf(plainTextArray);
				
				//return encrypted string
				return newText;
			
			
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		//initialize method variables
		int arrayLength = plainText.length();
		
		char[] plainTextArray = plainText.toCharArray();
		char[] emptyArray = new char[arrayLength];
		char[] keyArray = bellasoStr.toCharArray();
		
		//sets empty array with key array
		for(int i = 0, j = 0; i < plainTextArray.length; i++, j = (j+1) % keyArray.length) {
			emptyArray[i] = keyArray[j];
		}
		
		//Loops through array and replaces chars
		for(int i = 0; i < plainTextArray.length; i++) {
			plainTextArray[i] = (char) (plainTextArray[i] + emptyArray[i]);
			//sets char to range
			if(plainTextArray[i] < LOWER_BOUND) {
				while(plainTextArray[i] < LOWER_BOUND) {
					plainTextArray[i] += RANGE;
				}
			}				
			else if(plainTextArray[i] > UPPER_BOUND) {
				while(plainTextArray[i] > UPPER_BOUND) {
					plainTextArray[i] -= RANGE;
				}
			}	
		}
		
		//Create String from array
		String newText = String.valueOf(plainTextArray);	
		
		return newText;
	
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
				//Create array of chars
				char[] encryptedTextArray = encryptedText.toCharArray();
				
				//Loops through array and replaces chars
				for(int i = 0; i < encryptedTextArray.length; i++) {
					encryptedTextArray[i] = (char) (encryptedTextArray[i] - key);
					
					
					if(encryptedTextArray[i] < LOWER_BOUND) {
						while(encryptedTextArray[i] < LOWER_BOUND) {
						encryptedTextArray[i] += RANGE;
						}
					}				
					else if(encryptedTextArray[i] > UPPER_BOUND) {
						while(encryptedTextArray[i] > UPPER_BOUND) {
							encryptedTextArray[i] -= RANGE;
						}
					}	
					
				}
				//Create String from array
				String newText = String.valueOf(encryptedTextArray);
				
				
				//return encrypted string
				return newText;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		//initialize method variables
				int arrayLength = encryptedText.length();
				
				char[] plainTextArray = encryptedText.toCharArray();
				char[] emptyArray = new char[arrayLength];
				char[] keyArray = bellasoStr.toCharArray();
				
				//sets empty array with key array
				for(int i = 0, j = 0; i < plainTextArray.length; i++, j = (j+1) % keyArray.length) {
					emptyArray[i] = keyArray[j];
				}
				
				//Loops through array and replaces chars
				for(int i = 0; i < plainTextArray.length; i++) {
					plainTextArray[i] = (char) (plainTextArray[i] - emptyArray[i]);
					//sets char to range
					if(plainTextArray[i] < LOWER_BOUND) {
						while(plainTextArray[i] < LOWER_BOUND) {
							plainTextArray[i] += RANGE;
						}
					}				
					else if(plainTextArray[i] > UPPER_BOUND) {
						while(plainTextArray[i] > UPPER_BOUND) {
							plainTextArray[i] -= RANGE;
						}
					}	
				}
				
				//Create String from array
				String newText = String.valueOf(plainTextArray);	
				
				return newText;
		
	}
}
