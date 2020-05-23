/**
 * CryptoManager is a class that contain just a few instance fields, and static methods.
 * Classes other than this one will be able to call this classes' methods to encrypt and decrypt Strings,
 * with two approaches: Caeser Cipher, and Bellaso Cipher.
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
		boolean withinBounds = true;	//the boolean that'll be returned, initialized to true
		
		//Loop until we've gone through all of the characters of the plainText
		for(int x = 0; x < plainText.length(); x++)
		{
			//if at least one character is determined to be out of bounds, end the loop, and set the boolean to false
			if(!(plainText.charAt(x) >= ' ' && plainText.charAt(x) <= '_'))
			{
				withinBounds = false;
				x = plainText.length();
			}
		}
		return withinBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//proceed to encrypt if input is valid, otherwise return "invalid input"
		if(stringInBounds(plainText)) {
			
			int encryptedCharValue;			//the int that will hold the value of a encrypted character
			String encryptedString = "";	//the string that will be returned; it'll hold the encrypted string
			
			//Loop until we've gone through all of the characters of the plainText
			for (int x = 0; x < plainText.length(); x++)
			{
				//find the encrypted character value by offsetting the original's character value by the key value
				encryptedCharValue = plainText.charAt(x) + key;
				
				//if the key creates a character that's out of bounds, wrap around 
				while(encryptedCharValue > UPPER_BOUND)
				{
					encryptedCharValue -= RANGE;
				}
				
				//add the encrypted character to the string that will hold the encrypted string
				encryptedString += (char)encryptedCharValue;
			}
	
			return encryptedString;
		}
		else
		{
			System.out.println("Invalid input");
			return "Invalid input";
		}
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
		//proceed to encrypt if input is valid, otherwise return "invalid input"
		if(stringInBounds(plainText))
		{
			//extend the key word to the length of the plain text
			while(plainText.length() > bellasoStr.length())
			{
				bellasoStr += bellasoStr;
				
				//remove extra characters from the key word
				while(plainText.length() < bellasoStr.length())
				{
					bellasoStr = bellasoStr.substring(0, bellasoStr.length() - 1);
				}
			}
			
			int encryptedCharValue;			//the int that will hold the value of a encrypted character
			String encryptedString = "";	//the string that will be returned; it'll hold the encrypted string
			
			//Loop until we've gone through all of the characters of the plainText
			for (int x = 0; x < plainText.length(); x++)
			{
				//find the encrypted character value by offsetting the original
				//character's value by the value of the key word's corresponding character
				encryptedCharValue = plainText.charAt(x) + bellasoStr.charAt(x);
				
				//if the key word creates a character that's out of bounds, wrap around 
				while(encryptedCharValue > UPPER_BOUND)
				{
					encryptedCharValue -= RANGE;
				}
				
				//add the encrypted character to the string that will hold the encrypted string
				encryptedString += (char)encryptedCharValue;
			}
	
			return encryptedString;
		}
		else
		{
			System.out.println("Invalid input");
			return "Invalid input";
		}
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the decrypted string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//if input is an error message, let user know nothing was encrypted, otherwise encrypt input
		if(!encryptedText.equals("Invalid input"))
		{
			int decryptedCharValue;			//the int that will hold the value of a decrypted character
			String decryptedString = "";	//the string that will be returned; it'll hold the decrypted string

			//Loop until we've gone through all of the characters of the encrypted string
			for (int x = 0; x < encryptedText.length(); x++)
			{
				//find the decrypted character value by offsetting the encrypted character value by the value of the key
				decryptedCharValue = encryptedText.charAt(x) - key;
				
				//if the key creates a character that's out of bounds, wrap around 
				while(decryptedCharValue < LOWER_BOUND)
				{
					decryptedCharValue += RANGE;
				}
				
				//add the decrypted character to the string that will hold the decrypted string
				decryptedString += (char)decryptedCharValue;
			}
	
			return decryptedString;	
		}
		else
		{
			System.out.println("Error: Nothing was encrypted");
			return "Nothing was encrypted";
		}
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an an encrypted string to be decrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//if input is an error message, let user know nothing was encrypted, otherwise encrypt input
		if(!encryptedText.equals("Invalid input"))
		{
			//extend the key word to the length of the encrypted text
			while(encryptedText.length() > bellasoStr.length())
			{
				bellasoStr += bellasoStr;
				
				//remove extra characters from the key word
				while(encryptedText.length() < bellasoStr.length())
				{
					bellasoStr = bellasoStr.substring(0, bellasoStr.length() - 1);
				}
			}
			
			int decryptedCharValue;			//the int that will hold the value of a decrypted character
			String decryptedString = "";	//the string that will be returned; it'll hold the decrypted string
			
			//Loop until we've gone through all of the characters of the encrypted string
			for (int x = 0; x < encryptedText.length(); x++)
			{
				//find the encrypted character value by offsetting the encrypted 
				//character's value by the value of the key word's corresponding character
				decryptedCharValue = encryptedText.charAt(x) - bellasoStr.charAt(x);
			
				//if the key creates a character that's out of bounds, wrap around 
				while(decryptedCharValue < LOWER_BOUND)
				{
					decryptedCharValue += RANGE;
				}
				
				//add the decrypted character to the string that will hold the decrypted string
				decryptedString += (char)decryptedCharValue;
			}
	
			return decryptedString;
		}
		else
		{
			System.out.println("Error: Nothing was encrypted");
			return "Nothing was encrypted";
		}
	}
}