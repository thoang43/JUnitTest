/** The CryptoManager class defines the methods used to encrypt and 
 * decrypt Strings with Caesar Cipher and Bellaso encryption.
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
		boolean results=true;
		for (int i=0; i<plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				results=false;
			}
		}
		return results;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedString="";
		for (int i=0; i<plainText.length(); i++) {
			char c= (char) (plainText.charAt(i) + key);
			encryptedString+=boundAdjust(c);
		}
		return encryptedString;
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
		String encryptedString="";
		for (int i=0; i<plainText.length(); i++) {
			char c = (char) (plainText.charAt(i)+bellasoStr.charAt(i%bellasoStr.length()));
			encryptedString+=boundAdjust(c);
		}
		return encryptedString;
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
		String decryptedString="";
		for (int i=0; i<encryptedText.length(); i++) {
			char c = (char) (encryptedText.charAt(i)-key);
			decryptedString+=boundAdjust(c);
		}
		return decryptedString;
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
		String decryptedString="";
		for (int i=0; i<encryptedText.length(); i++) {
			char c = (char) (encryptedText.charAt(i) - bellasoStr.charAt(i%bellasoStr.length()));
			decryptedString+=boundAdjust(c);
		}
		return decryptedString;
	}
	
	/**
	 * This method adjusts characters in the plainText/encryptedText to be within the
	 * allowable bounds by wrapping it around if too high or low.
	 * @param a character in the plainText/encryptedText String
	 * @return the adjusted character in the plainText/encryptedText string within allowable bounds
	 */
	private static char boundAdjust(char c) {
		if (c>UPPER_BOUND) {
			do {
				c -= RANGE;
			} while (c>UPPER_BOUND || c<LOWER_BOUND);
			
		}
		else if (c<LOWER_BOUND) {
			do {
				c += RANGE;
			} while (c>UPPER_BOUND || c<LOWER_BOUND);

		}
		
		return c;
	}
}