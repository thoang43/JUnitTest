/**  
* This class contains the methods used to decrypt/encrypt strings via Caesar and Bellaso ciphers as
* well as their accessory methods.
* Modified from instructor provided file by Christian Watson 10/13/2019
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
		
		for (int i = 0; i < plainText.length(); i++) {
			
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
				return false;
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

		String encryptedText = "";
		
		for (int i = 0; i < plainText.length(); i++) {
			
			encryptedText += String.valueOf((char)(bringInRange(plainText.charAt(i) + key)));
		}
		
		return encryptedText;
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

		String encryptedText = "";
		String keyExtended = extendKey(bellasoStr, plainText.length());
		
		for (int i = 0; i < plainText.length(); i++) {
			
			encryptedText += String.valueOf((char)(bringInRange(plainText.charAt(i) + keyExtended.charAt(i))));
		}
		
		
		return encryptedText;
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
		
		String decryptedText = "";
		
		for (int i = 0; i < encryptedText.length(); i++) {
			
			
			decryptedText += String.valueOf((char)(bringInRange(encryptedText.charAt(i) - key)));
		}
		
		return decryptedText;
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
		
		String decryptedText = "";
		String keyExtended = extendKey(bellasoStr, encryptedText.length());
		
		for (int i = 0; i < encryptedText.length(); i++) {
			
			decryptedText += String.valueOf((char)(bringInRange(encryptedText.charAt(i) - keyExtended.charAt(i))));
		}
		
		
		return decryptedText;
	}

	
	/**
	 * Checks if a character is in the allowable range of ASCII characters used for the cipher. If the
	 * character value is lower than lower bound, the range is added into it until it is between the upper 
	 * and lower bounds. If the character value is higher than the upper bound, the range is subtracted 
	 * from it until it is between the upper and lower bounds.
	 * @param number integer value of the character
	 * @return the "in-range" character's integer value
	 */
	private static int bringInRange(int number) {
		
		while (number > UPPER_BOUND)
			number -= RANGE;
		
		while (number < LOWER_BOUND)
			number += RANGE;
		
		return number;
	}
	
	
	/**
	 * Extends the length of the user provided key to match the length of the string to encrypt.  For use in
	 * the Bellaso encryption/decryption methods.
	 * @param key An uppercase string containing the user provided key
	 * @param stringLength An integer representing the length of the  string the user wants to encrypt/decrypt
	 * @return the extended key as a string
	 */
	private static String extendKey(String key, int stringLength) {
		
		while (key.length() < stringLength)
			key += key;
		
		return key.substring(0,  stringLength);
	}
}
