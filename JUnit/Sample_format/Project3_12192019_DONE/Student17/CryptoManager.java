
//Description: Class used to encrypt and decrypt given strings

package assignment3;

import java.util.ArrayList;

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
//		for each character in plainText
//			if character is greater than upper bound or lower than lower bound, return false
//		return true
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) > UPPER_BOUND || plainText.charAt(i) < LOWER_BOUND) return false;
		}
		return true;
	}

	
	
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
//		create new string representing encryption
//		for each character in plainText
//			add current character ASCII value + key
//			if added value > upper bound
//				DO subtract range 
//				WHILE greater than upper bound
//			concatenate to new string: character ASCII value of plainText + key
//		return encrypted string	
		String encryptText = "";
		for (int i = 0; i < plainText.length(); i++) {
			int ascii = plainText.charAt(i) + key;
			if (ascii > UPPER_BOUND) {
				do {
					ascii -= RANGE;
				} while (ascii > UPPER_BOUND);
			}
			encryptText += (char) ascii; 
		}
		return encryptText;
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
//		create string representing encryption
//		for each index of plainText
//			if at the end of bellasoStr, reset index of bellasoStr to beginning
//			add ascii value of current char of plainText + current char of bellasoStr
//			If value is greater than upper bound 
//				DO value -= range 
//				WHILE value is greater than upper bound
//			concatenate each index in char array to string
//		Return string
		String encryptText = "";
		for (int i = 0, j = 0; i < plainText.length(); i++, j++) {
			if (j == bellasoStr.length()) j = 0;
			int ascii = plainText.charAt(i) + bellasoStr.charAt(j);
			if (ascii > UPPER_BOUND) {
				do {
					ascii -= RANGE;
				} while (ascii > UPPER_BOUND);
			}
			encryptText += (char) ascii;
		}
		return encryptText;
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
//		create new string representing decryption
//		for each character in plainText
//			subtract current character ASCII value - key
//			if subtracted value < lower bound
//				DO add range 
//				WHILE value less than lower bound
//			concatenate to new string: character ASCII value of plainText + key
//		return decrypted string	
		String decryptText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			int ascii = encryptedText.charAt(i) - key;
			if (ascii < LOWER_BOUND) {
				do {
					ascii += RANGE;
				} while (ascii < LOWER_BOUND);
			}
			decryptText += (char) ascii; 
		}
		return decryptText;
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
//		create string representing encryption
//		for each index of plainText
//			if at the end of bellasoStr, reset index of bellasoStr to beginning
//			subtract ascii value of current char of plainText + current char of bellasoStr
//			If value is less than lower bound 
//				DO value += 64 
//				WHILE value is less than lower bound
//			concatenate each index in char array to string
//		Return string
		String decryptText = "";
		for (int i = 0, j = 0; i < encryptedText.length(); i++, j++) {
			if (j == bellasoStr.length()) j = 0;
			int ascii = encryptedText.charAt(i) - bellasoStr.charAt(j);
			if (ascii < LOWER_BOUND) {
				do {
					ascii += RANGE;
				} while (ascii < LOWER_BOUND);
			}
			decryptText += (char) ascii;
		}
		return decryptText;
	}
}
