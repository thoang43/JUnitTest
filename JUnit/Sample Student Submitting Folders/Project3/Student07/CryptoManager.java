/**
 * This class implements methods to check if a string is in bounds
 * and the encrypt and decrypt Strings using the Caesar and Bellaso methods
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
	public static boolean stringInBounds (String plainText) 
	{
	//This method uses a for loop to check each character against the lower and upper bounds. paramater is plain text string - Malcolm Almuntazar-Harris 13OCT2019
		boolean inBounds = true; //variable to hold boolean representing whether string is in bounds
		int index;
		
		for (index = 0; index < plainText.length(); index++)
		{
			if (plainText.charAt(index) < (int) LOWER_BOUND || plainText.charAt(index) > (int) UPPER_BOUND)  //checks if each character is between the ascii values for the lower and upper bound
				inBounds = false; //if the character is not between the bounds, the flag gets marked false
		}
		
		return inBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) 
	{
	//This method iterates along each character in a string, and shifts it on the ASCII value using the provided key parameter - Malcolm Almuntazar-Harris 13OCT2019
		String encryptText = ""; //variable to hold text after encryption
		int index;
		
		for (index = 0; index < plainText.length(); index++)
		{
			int newEncryptChar = ( (int) plainText.charAt(index) + key);  //converts the specific character at the index to an integer and adds the key value, stores in variable
			while (newEncryptChar > (int) UPPER_BOUND)  
				newEncryptChar -= (int) RANGE;  //removes the value of the range until it's lower than the upper bound
			encryptText += (char) newEncryptChar; //adds character to the string
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
	public static String encryptBellaso(String plainText, String bellasoStr)
	//This method iterates along the plaintText string and shifts each character with the corresponding character along the bellasoStr index  - Malcolm Almuntazar-Harris 13OCT2019
	{
		
		String encryptText = ""; //variable to hold text after encryption
		int index;
		
		for (index = 0; index < plainText.length(); index++)
		{
			int newEncryptChar = (int) plainText.charAt(index) + (int) (bellasoStr.charAt(index % bellasoStr.length())); //converts the specific character using the bellaString. The modulo is so that it wraps around the string when it reaches the end.
			while (newEncryptChar > (int) UPPER_BOUND) //removes the value of range until it's lower than the upper bounds
				newEncryptChar -= (int) RANGE;
			encryptText += (char) newEncryptChar;  //adds new char to string
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
	public static String decryptCaesar(String encryptedText, int key)
	{
	//This method iterates along an encrypted text string and decrypters it by shifting each character to a lower ASCII value using the key - Malcolm Almuntazar-Harris 13OCT2019
		String decryptText = "";  //holds the decrypted text string
		int index;
		
		for (index = 0; index < encryptedText.length(); index++)
		{
			int newDecryptChar = ( (int) encryptedText.charAt(index) - key);  //stores an integer that is the ASCII value of each character shifted down by the key
			while (newDecryptChar < (int) LOWER_BOUND)
				newDecryptChar += (int) RANGE;  //if below lower bound, it adds the range until it's not
			decryptText += (char) newDecryptChar;  //adds each shifted character decrypted text string
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
	public static String decryptBellaso(String encryptedText, String bellasoStr) 
	//This method iterates along an encrypted text string and decrypts it by shifting each character to a lower ASCII value using the ascii value of the bella string - Malcolm Almuntazar-Harris 13OCT2019
	{
			String decryptText = "";  //holds decrypted text
			int index;
			
			for (index = 0; index < encryptedText.length(); index++)
			{
				int newDecryptChar = (int) encryptedText.charAt(index) - (int) (bellasoStr.charAt(index % bellasoStr.length()));  //shifts each character and holds it as an integer. modulo is used to repeat from the beginning when the end of the character is reached
				while (newDecryptChar < (int) LOWER_BOUND)
					newDecryptChar += (int) RANGE;  // if belower lower bound, it adds the range difference
				decryptText += (char) newDecryptChar;  //adds each character to string
			}
			
			return decryptText;
	}
}
