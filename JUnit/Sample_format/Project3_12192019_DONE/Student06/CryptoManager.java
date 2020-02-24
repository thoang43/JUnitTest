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
	{//check if all characters are within allowable bounds
		//return false if any characters are outside bounds
		for(int i=0; i<plainText.length(); i++)
		{
			if (plainText.charAt(i)<LOWER_BOUND || plainText.charAt(i)>UPPER_BOUND)
				return false;
		}
		//return true if all characters are within allowable bounds
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) 
	{//if key is greater than the range of characters, the range will subtract from key 
		//until the key is within range
		String encrypted="";
		if (key>RANGE)
		{
			while (key>UPPER_BOUND)
				key=key-RANGE-1;
		}
		//character in plainText is replaced by a character that has a 
		//specified distance determined by key
		for(int i=0; i<plainText.length(); i++)
		{
			encrypted=encrypted+(char)(plainText.charAt(i)+key);
		}
		return encrypted;
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
	{//extend the key string to the length of plain text
		String key="";
		String encrypted="";
		int j=0;
		while (key.length()!=plainText.length())
		{
			key=key+bellasoStr.charAt(j);
			j++;
			if (j==bellasoStr.length())
				j=0;
		}
		//encrypt each character in the plaintext
		for (int i=0; i<plainText.length(); i++)
		{
			//replace each character
			int result=plainText.charAt(i)+key.charAt(i);
			//if result is greater than upper bound, subtract range from result
			//until the result is in range
			if(result>UPPER_BOUND)
			{
				while(result>UPPER_BOUND)
					result=result-RANGE;
			}
			//add encrypted character to the encrypted string
			encrypted=encrypted+(char)result;
		}
		return encrypted;
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
		String decrypted="";
		//if the key is greater than the range, subtract the range from key 
		//until the key is in range
		if (key>RANGE)
		{
			while (key>UPPER_BOUND)
				key=key-RANGE-1;
		}
		//inverse of encryptCaesar
		for (int i=0; i<encryptedText.length(); i++)
		{
			decrypted=decrypted+(char)(encryptedText.charAt(i)-key);
		}
		return decrypted;
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
	{
		String key="";
		String decrypted="";
		int j=0;
		//extend key string to length of plain text
		while(key.length()!=encryptedText.length())
		{
			key=key+bellasoStr.charAt(j);
			j++;
			if (j==bellasoStr.charAt(j))
				j=0;
		}
		//inverse of encryptBellaso
		for (int i=0; i<encryptedText.length(); i++)
		{
			int result=encryptedText.charAt(i)-key.charAt(i);
			if (result<LOWER_BOUND)
			{
				while(result<LOWER_BOUND)
					result=result+RANGE;
			}
			decrypted=decrypted+(char)result;
		}
		return decrypted;
	}
}