
public class CryptoManager {

    private static final char LOWER_BOUND = ' '; //ASCII 32
    private static final char UPPER_BOUND = '_'; //ASCII 95
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; //95-32+1=64. key=120. 120-64=56. ASCII 56 => 8

    /**This method determines if a string is within the allowable bounds of ASCII codes 
     * according to the LOWER_BOUND and UPPER_BOUND characters
     * @param plainText a string to be encrypted, if it is within the allowable bounds
     * @return true if all characters are within the allowable bounds, false if any character is outside
     */
    public static boolean stringInBounds (String plainText)
    {
        //throw new RuntimeException("method not implemented");
        boolean flag = true;
        //determines if string is within allowable bounds of ASCII codes (according to bounds)
        for (int i = 0; i < plainText.length(); i++)
        {
            if ( !((int) plainText.charAt(i) >= LOWER_BOUND && (int) plainText.charAt(i) <= UPPER_BOUND) )
            {
                //false if any character is outside of the bounds
                flag = false;
                break;
            }
        }
        //returns true if all characters are within allowable bounds
        return flag;
    }

    /**METHOD ADDED TO MINIMIZE CODE REPEATABILITY
     * @param key
     * @return updated key after necessary # of wraparounds
     */
    public static int wrapAround(int key)
    {
        while (key > UPPER_BOUND)
        {
            key -= (UPPER_BOUND - LOWER_BOUND + 1);
        }
        return key;
    }

    /**Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in plainText is replaced by the character \"offset\" away from it 
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer that specifies the offset of each character
     * @return the encrypted string
     */
    public static String encryptCaesar(String plainText, int key)
    {
        //throw new RuntimeException("method not implemented");
        //wrap around the key, IF it's greater than the UPPER_BOUND
        key = wrapAround(key);

        //encrypted text
        String encrypted = "";
        //encryption
        for (int i = 0; i < plainText.length(); i++)
        {
            encrypted += Character.toString( (char)((int)plainText.charAt(i) + key) );
        }
        //return encrypted result
        return encrypted;
    }

    /**Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in encryptedText is replaced by the character \"offset\" characters before it.
     * This is the inverse of the encryptCaesar method.
     * @param encryptedText an encrypted string to be decrypted.
     * @param key an integer that specifies the offset of each character
     * @return the plain text string
     */
    public static String decryptCaesar(String encryptedText, int key)
    {
        //throw new RuntimeException("method not implemented");
        //wrap around the key, IF it's greater than UPPER_BOUND
        key = wrapAround(key);

        //decrypted text
        String decrypted = "";
        //encryption
        for (int i = 0; i < encryptedText.length(); i++)
        {
            decrypted += Character.toString( (char)((int)encryptedText.charAt(i) - key) );
        }

        //return decrypted result
        return decrypted;
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
        //encrypted text
        String encrypt = "";


        while(bellasoStr.length()<plainText.length())
        {
            bellasoStr += bellasoStr.substring(0, bellasoStr.length());
        }

        //encryption
        for(int i = 0; i < plainText.length(); i++)
        {
            char c = (char)wrapAround( (int)plainText.charAt(i) + (int)bellasoStr.charAt(i) );
            encrypt += Character.toString(c);
        }
        //return encrypted message
        return encrypt;
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
        //decrypted text
        String decrypt = "";

        //Adjust length of bellasoStr to plainText
        while(bellasoStr.length() < encryptedText.length())
        {
            bellasoStr += bellasoStr.substring(0, bellasoStr.length());
        }

        //decryption
        for(int i = 0; i < encryptedText.length(); i++)
        {
            //char c = (char)wrapAround((int)encryptedText.charAt(i) + (int)bellasoStr.charAt(i) );
        	
        	//char c = (char)wrapAround((int)bellasoStr.charAt(i) - (int)encryptedText.charAt(i));
        	
        	char c = (char)wrapAround( (int)encryptedText.charAt(i) - (int)bellasoStr.charAt(i) );
        	
            decrypt += Character.toString(c);
        }
        //return decrypted message
        return decrypt;
    }
}

