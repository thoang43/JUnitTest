

/**
 * 
 * Assignment 3 - CryptoManager
 * CMSC 203
 * Professor Alla Webb
 * This class takes in string values to encrypt and decrypt phrases depending
 * on which cipher is used: Caesar or Bellaso.
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
     public static boolean stringInBounds (String plainText){  
    	 
    	 //Check whether the each character in the plainText is in the RANGE or not
          //Return false, if at least one character is out of range

          for(int i = 0;i<plainText.length();i++){
              if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND )

                   return false;
          }   
          
          //Return true, if all characters are within the range
          return true;
     }
     
     /**
     * Encrypts a string according to the Caesar Cipher. The integer key specifies an offset
     * and each character in plainText is replaced by the character \"offset\" away from it
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer that specifies the offset of each character
     * @return the encrypted string
     */

     public static String encryptCaesar(String plainText, int key){

    	 String result = "";
	        for (int i=0; i<plainText.length(); i++)
	        {
	        	char ch = (char)(((int)plainText.charAt(i) + key - 32) % (96-32) + 32);
	        	result += ch;
	        }
	      return result;
     }

     /**

     * Encrypts a string according the Bellaso Cipher. Each character in plainText is offset
     * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
     * to correspond to the length of plainText
     * @param plainText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the encrypted string
     */
     public static String encryptBellaso(String plainText, String bellasoStr){

          String key="";
          String encrypted="";
          //Make key by extending the key string to the length of plain text
          int j=0;

          while(key.length()!=plainText.length()){

              key=key+bellasoStr.charAt(j);          
              j++;
              if(j==bellasoStr.length())

                   j=0;
          }

          //Encrypt each character in the plain text
          for(int i=0;i<plainText.length();i++)
          {

              //Replace each character in the plain text by
              //the character that is away of corresponding character
              //in the key string

              int result=plainText.charAt(i)+key.charAt(i);

              //If the result is not within the range,
              //subtract the RANGE from the result until
              //the result is in the allowable range
              if(result>UPPER_BOUND){                 

                   while(result>UPPER_BOUND) {

                        result=result-RANGE; //RANGE=95-32+1=64
                   }
              }        

              //Add the encrypted charcter to encrypted string
              encrypted=encrypted+(char)result;
          }
          
          //Return the encrypted string.
          return encrypted;

     }

     /**
     * Decrypts a string according to the Caesar Cipher. The integer key specifies an offset
     * and each character in encryptedText is replaced by the character \"offset\" characters before it.
     * This is the inverse of the encryptCaesar method.
     * @param encryptedText an encrypted string to be decrypted.
     * @param key an integer that specifies the offset of each character
     * @return the plain text string
     */

     public static String decryptCaesar(String encryptedText, int key){

    	String result = "";
 		int c;
 		
         for (int i=0; i<encryptedText.length(); i++)
         {
             c = (int)encryptedText.charAt(i) - key;
             while (c<0){
             	c += 95-32+1;
             }
         	char ch = (char)((c + 32) % (95-32+1) + 32);
         	result += ch;
         }
         
     return result;

     }

     /**
     * Decrypts a string according the Bellaso Cipher. Each character in encryptedText is replaced by
     * the character corresponding to the character in bellasoStr, which is repeated
     * to correspond to the length of plainText. This is the inverse of the encryptBellaso method.
     * @param encryptedText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the decrypted string

     */

     public static String decryptBellaso(String encryptedText, String bellasoStr){

          String key="";
          String decrypted="";
          int j=0;

          //Make key by extending the key string to the length of plain text
          while(key.length()!=encryptedText.length()){

              key=key+bellasoStr.charAt(j);          
              j++;
              
              if(j==bellasoStr.length()) {

                   j=0;
              }
          }

          //Do the inverse of the encryptBellaso
          for(int i=0;i<encryptedText.length();i++){

              int result=encryptedText.charAt(i)-key.charAt(i);

              if(result<LOWER_BOUND){                 

                   while(result<LOWER_BOUND) {

                        result=result+RANGE;
                   }
              }            
              
              decrypted=decrypted+(char)result;
          }
          //Return the decrypted string
          return decrypted;

     }

}