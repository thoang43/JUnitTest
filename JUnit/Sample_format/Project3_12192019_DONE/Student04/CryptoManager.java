/**
 * Date: 10/13-2019
 * Assignment 3
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
		
		//Check if the characters is in the RANGE or not
		for(int i=0;i<plainText.length();i++) 
        {
			
	        //Return false, if at least one character is out of range
            if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND )
            	return false;
        }   
		
        //Return true, if all characters are within the range
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
		String encrypted="";

        //If the key is greater than the range of characters, key will subtract the range until the key is within the range.
        if(key>RANGE) 
        {
            while(key>UPPER_BOUND)
                 key=key-RANGE-1;
        }

        //To replace character by a character that is key positions away
        for(int i=0;i<plainText.length();i++)
        {
            encrypted=encrypted+(char)(plainText.charAt(i)+key);
        }
        
        // return to encrypted string
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
	{
		String key="";
        String encrypted="";
        int j=0;
        
        //Make key by extending the key string to the length of plain text
        while(key.length()!=plainText.length())
        {
            key=key+bellasoStr.charAt(j);          
            j++;
            if(j==bellasoStr.length())
            j=0;
        }

        //To encrypt every character in the plain text
        for(int i=0;i<plainText.length();i++)
        {

            //To Replace each character in the plain text that is away of corresponding character in the key string.
            int result=plainText.charAt(i)+key.charAt(i);

            //If the result is not within the range, key will subtract the range until the result is within the range.
            if(result>UPPER_BOUND)
            {                 
                 while(result>UPPER_BOUND)           
                      result=result-RANGE; 
            }        

            //Add the encrypted character to encrypted string
            encrypted=encrypted+(char)result;
        }
        
        //Return the encrypted string.
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

        //If the key is greater than the range of characters, kill will subtract the range from the key until the key is within the range.
        if(key>RANGE)
        {
            while(key>UPPER_BOUND)
                 key=key-RANGE-1;
        }

        //To make inverse of the encryptCaesar
        for(int i=0;i<encryptedText.length();i++)
        {
            decrypted=decrypted+(char)(encryptedText.charAt(i)-key);
        }

        //Return decrypted string
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

        //To make key by extending the key string to the length of plain text
        while(key.length()!=encryptedText.length())
        {
            key=key+bellasoStr.charAt(j);          
            j++;
            if(j==bellasoStr.length())
            j=0;
        }

        //To make the inverse of the encryptBellaso
        for(int i=0;i<encryptedText.length();i++)

        {
            int result=encryptedText.charAt(i)-key.charAt(i);
            if(result<LOWER_BOUND)
            {                 
                 while(result<LOWER_BOUND)
                      result=result+RANGE; 
            }            
            decrypted=decrypted+(char)result;
        }

        //Return the decrypted string
        return decrypted;
   }
}