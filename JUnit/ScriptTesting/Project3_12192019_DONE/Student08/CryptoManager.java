											/* Michael Pontillo */





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

			//Return the value false if out of range

			// test if plainText is in range

			for(int c=0;c<plainText.length();c++)

			{

				if(plainText.charAt(c) < LOWER_BOUND || plainText.charAt(c) > UPPER_BOUND )

					return false;

			}

			// If all of the char's are in range return the value true
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

		String encrypt = "";

		/* Test is key is greater than the range of characters, if so then subtract range from the key.

		if( key > RANGE ) */

		{
			while(key>UPPER_BOUND)

				key=key-RANGE-1;

		}

		//Substitute char

		for(int i=0;i<plainText.length();i++)

		{

			encrypt += (char) (plainText.charAt(i) + key);

		}
		return encrypt;
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

		String Key = "";

		String encrypt = "";

		/* Make key string length of plainText */

		int b=0;

		while(Key.length()!=plainText.length())

		{

			Key = Key + bellasoStr.charAt(b);

			b++;

			if(b == bellasoStr.length())

				b=0;

		}

		/* encrypt the char's in plainText */

		for(int i = 0; i < plainText.length();i++)

		{

			/* replace each char in plainText to match with key */

			int Result = plainText.charAt(i) + Key.charAt(i);

			/* subtract range from result if out of range */

			if(Result>UPPER_BOUND)

			{

				while(Result>UPPER_BOUND)

					Result=Result-RANGE;     		//range = 95 - 32 + 1 = 64

			}
			//add the character to string

			encrypt = encrypt + (char)Result;
		}
		//Return the encrypted string.
		return encrypt;
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

		String decrypt = "";

		{

			while(key>UPPER_BOUND)

				key -= RANGE - 1;

		}

		// inverse encryptCaesar

		for(int i=0;i<encryptedText.length();i++)

		{

			decrypt += (char) (encryptedText.charAt(i) - key);

		}

		//Return decrypted string

		return decrypt;

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

		String Key = "";

		String decrypt = "";

		int k=0;

		/* extend length of plainText to make key */

		while(Key.length()!=encryptedText.length())

		{

			Key=Key+bellasoStr.charAt(k);

			k++;

			if(k==bellasoStr.length())

				k=0;

		}

		/* inverse encryptBellaso */

		for(int i=0;i<encryptedText.length();i++)

		{

			int result;
			result = encryptedText.charAt(i)-Key.charAt(i);

			if(result<LOWER_BOUND)

			{

				while(result<LOWER_BOUND)

					result += RANGE; /* RANGE=95-32+1=64 */

			}

			decrypt += (char) result;

		}

		/* Return string after decryption */

		return decrypt;

	}
}