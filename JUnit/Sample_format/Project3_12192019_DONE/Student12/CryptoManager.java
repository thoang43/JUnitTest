/*
 * 
 * CMSC 203
 * 10/11/2019
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
		
		// Boolean value determines if the plainText
		// is acceptable or not
		boolean inBounds = true;
		
		// Loop through each character in the plainText string
		for (int index = 0; index < plainText.length(); index++)
		{
			// Check to see if the current character is between 32 and 95 
			// in the ASCII table
			if ((plainText.charAt(index) < 32) || (plainText.charAt(index) > 95))
			{
				// If the current character is outside of the range 32 to 95
				// in the ASCII table, return false
				inBounds = false;
			}
		}
		// Returns true or false depending on validity of plainText string
		return inBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		// Holds the value of a character in the string
		int ascVal;
		// Create a string object to build the newly ecnrypted string
		String encryptedStr = "";
		
		// Loop through each character in the plainText string
		for (int index = 0; index < plainText.length(); index++)
		{
			// Set ascVal equal to the ASCII value + the 
			// integer in the key parameter
			ascVal = plainText.charAt(index) + key;
			
			// If the ASCII value in ascVal is greater than 95
			// wrap back around the acceptable range of values
			while (ascVal > 95)
				ascVal -= 64;
			
			// Convert the value in ascVal to a character
			// and add it to the encryptedStr
			encryptedStr += (char)ascVal;
			
		}
		// Returns the newly created encrypted string
		return encryptedStr;
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

		// Holds the index of the bellasoStr character
		int keyIndex = 0;
		// Holds the ASCII value of a plainText character
		int strVal;
		// Holds the ASCII value of a bellasoStr character
		int keyVal;
		// Holds calculated encrypted character
		int encrVal;
		// Create a String object to generate an encrypted String
		String encryptedStr = "";
		
		// Loop through each character in the String
		for (int index = 0; index < plainText.length(); index++)
		{
			// Set the keyIndex to zero after all elements have 
			// used. This resets the key so it can be applied
			// to any remaining characters in the plainText string.
			if (keyIndex == bellasoStr.length()) {
				keyIndex = 0;
			}
			
			// Get the ASCII value of the current bellasoStr string character
			keyVal = bellasoStr.charAt(keyIndex);
			// Get the ASCII value of the current plainText string character
			strVal = plainText.charAt(index);
			// Offset the plainText character by the ASCII value of the
			// bellasoStr character.
			encrVal = keyVal + strVal;
			
			// If the offset of the plainText's ASCII value
			// moves out of the range of acceptable characters,
			// wrap around the range to find the appropriate value.
			while (encrVal > 95)
				encrVal -= 64;
			while (encrVal < 32)
				encrVal += 64;
			
			// Add the encrypted character to the encryptedStr string.
			encryptedStr += (char)encrVal;
			// Increment the bellasoStr index.
			keyIndex++;
		}
		
		// Return the entire encrypted string.
		return encryptedStr;
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
		
		// Holds the value of a character in the string
		int ascVal;
		// Create a string object to build the newly ecnrypted string
		String decryptedStr = "";
			
		// Loop through each character in the plainText string
		for (int index = 0; index < encryptedText.length(); index++)
		{
			// Set ascVal equal to the ASCII value + the 
			// integer in the key parameter
			ascVal = encryptedText.charAt(index) - key;
			
			while (ascVal < 32)
				ascVal += 64;
			// Convert the value in ascVal to a character
			// and add it to the encryptedStr
			decryptedStr += (char)ascVal;
					
		}
		// Returns the newly created encrypted string
		return decryptedStr;
		
		
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
		
		// Holds the index of the bellasoStr character
		int keyIndex = 0;
		// Holds the ASCII value of a plainText character
		int strVal;
		// Holds the ASCII value of a bellasoStr character
		int keyVal;
		// Holds calculated encrypted character
		int encrVal;
		// Create a String object to generate an encrypted String
		String decryptedStr = "";
				
		// Loop through each character in the String
		for (int index = 0; index < encryptedText.length(); index++)
		{
			// Set the keyIndex to zero after all elements have 
			// used. This resets the key so it can be applied
			// to any remaining characters in the plainText string.
			if (keyIndex == bellasoStr.length()) {
				keyIndex = 0;
			}
					
			// Get the ASCII value of the current bellasoStr string character
			keyVal = bellasoStr.charAt(keyIndex);
			// Get the ASCII value of the current plainText string character
			strVal = encryptedText.charAt(index);
			// Offset the plainText character by the ASCII value of the
			// bellasoStr character.
			encrVal = strVal - keyVal;
					
			// If the offset of the plainText's ASCII value
			// moves out of the range of acceptable characters,
			// wrap around the range to find the appropriate value.
			while (encrVal < 32)
				encrVal += 64;
			while (encrVal > 95)
				encrVal -= 64;
			
			// Add the encrypted character to the encryptedStr string.
			decryptedStr += (char)encrVal;
			// Increment the bellasoStr index.
			keyIndex++;
		}
				
		// Return the entire encrypted string.
		return decryptedStr;
		
	}
}
