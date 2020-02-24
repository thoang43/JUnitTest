
/**
 * Class to encrypt and decrypt a string using
 * the Caesar and Bellaso techniques
 * 
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
		int charOutOfRange = 0;
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) < 32 || plainText.charAt(i) > 95) {
				charOutOfRange++;
			}
		}
		if(charOutOfRange > 0) 
			return false;
		else
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
		if(stringInBounds(plainText)) {
		String encryptedText = "";
		while(key > 95) {
			key -= RANGE;
		}
		while(key < 0) {
			key += 32;
		}
		for(int i = 0; i < plainText.length(); i++) {
			int start = ((int) plainText.charAt(i) + key);
			while(start > 95) {
				start = start - RANGE;
			} 
			encryptedText += (char)start;
		}
		return encryptedText;
		}
		else {
			return "String not in bounds";
		}
		
		//throw new RuntimeException("method not implemented");
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
		if(stringInBounds(plainText)) {
			String encryptedText = "";
			
			for (int i = 0; i < plainText.length(); i++){
				int start = (int)plainText.charAt(i);
				int encryptedCharASCIInum = (start + (int)bellasoStr.charAt(i % bellasoStr.length()));
				while (encryptedCharASCIInum > 95){			
					encryptedCharASCIInum -= RANGE;
				}
				encryptedText += (char)encryptedCharASCIInum;
			}
			return encryptedText;
		}
		else {
			return "String out of bounds";
		}
		//throw new RuntimeException("method not implemented");
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
		while(key > 95) {
			key -= (95 - 32 + 1);
		}
		while(key < 0) {
			key += (32);
		}
		for(int i = 0; i < encryptedText.length(); i++) {
			int start = (int)encryptedText.charAt(i) - key;
			while(start < 32) {
				start += RANGE;
			}
			decryptedText += (char)start;
		}
		return decryptedText;
		//throw new RuntimeException("method not implemented");
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
		for(int i = 0; i < encryptedText.length(); i++) {
			int start = (int)encryptedText.charAt(i);
			int decryptedCharASCIInum = start - (int)bellasoStr.charAt(i % bellasoStr.length());
			while (decryptedCharASCIInum < 32) {
				decryptedCharASCIInum += RANGE;
			}
			decryptedText += (char)decryptedCharASCIInum;
		}
		return decryptedText;
		
		//throw new RuntimeException("method not implemented");
	}
}
