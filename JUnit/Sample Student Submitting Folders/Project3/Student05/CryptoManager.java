/**CMSC 203
 * Assignment 3
 * 
 * 
 *  
 *
 */

/* 
 * Jonathan Merino 
 * 
 * This Program when tested in the J Unit test will pass without fault. When tested in the CryptoTest it will display All
 * the correct Outputs as requested on the Assignment.
 * 
 * This Program in the GUI will accept a String and then also ask for a key in order to encrypt the String. 
 * After the user has inputed the key, the program will use the key to encrypt the String according to which type of 
 * encryption the user has chosen(Caesar or Bellaso).
 * After the program has encrypted the String the user then can choose to decrypt the string and see the original input.
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
	
	//Determines if the String is in the bounds
	public static boolean stringInBounds (String plainText) {
		boolean bounds=true; //Creating varibale bounds to contain the boolean choice of whether it is true or false
		for(int i=0;i<plainText.length();i++) { //Getting the length of the String 
			if(plainText.charAt(i)<LOWER_BOUND||plainText.charAt(i)>UPPER_BOUND) { //Testing the Length of the String if it is in bounds
				bounds=false; //If outside of bounds return false
			}
			
				
		}
		return bounds; //If in bounds return true 
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) { //This method will encrypt the String using Caesar
		 String caesar = "";
for (int i = 0; i < plainText.length(); i++) { //Testing the string length 
		int charCaesar = (int) plainText.charAt(i) + key;//Adding the encryption to the string 
			while (charCaesar > (int) UPPER_BOUND) { //Making sure the String is still in bounds
	               charCaesar -= RANGE;
	           }
			caesar += (char) charCaesar; //Adding the encryption string to the variable to be returned
	       }
return caesar;// Returning the encryption 
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
		String bellaso="";// Variable that will hold the encypted bellaso String 
		String bellKey="";
		
		int bellLength=0; //Variable that will be used to count the length of the text
		
		while(bellKey.length()!=plainText.length()) {
			//While the variable's length does not equal the length of the plainText
			//The Variable bellKey will bring in the encryption for the String 
			bellKey+=bellasoStr.charAt(bellLength);
			bellLength++;//Each time it will add one until it is the same length then it will finish the loop
			 if(bellLength==bellasoStr.length())
				 bellLength=0;
		}
		
		for(int i=0;i<plainText.length();i++) { //For loop to add the bellKey encryption to the original String
			int bell=plainText.charAt(i)+bellKey.charAt(i); //Add the encryption to the original String to be further encrypted 
			//Testing if the String is still within the bounds 
			if(bell>UPPER_BOUND) {
				while(bell>UPPER_BOUND)
					bell-=RANGE;
			}
		
		bellaso+=(char)bell; //Passing the encryption to variable bellaso to be returned
		}
		return bellaso; //Returning Bellaso encryption string 
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) { //Decrypting the String that was in Caesar
		 String deCaesar = ""; //Variable that will hold the decryption 
		 for (int i = 0; i < encryptedText.length(); i++) {          
	       int deCae = (int) encryptedText.charAt(i) - key; //Removing the encryption from the string. Doing the opposite of the encryption 
	          while (deCae < (int) LOWER_BOUND) { //Testing if the String falls within the bounds
	        	  deCae += RANGE;
	        	  }
	          deCaesar += (char) deCae; //Adding the String to the variable to be returned
	       }   
		 return deCaesar;// Returning the decrypted Caesar String
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {//This method will return the decrypted Bellaso
//As before in this method we will undo what was done in the encryption and test if it is still in bounds
		String keyBell = "";
String deBellaso = "";
	int counter = 0;
while (keyBell.length() != encryptedText.length()) { //while the variable is not the same length of the encryption 
	//The next formula add character to the string until they are equal 
	keyBell = keyBell + bellasoStr.charAt(counter);
    counter++; 
    if (counter == bellasoStr.length())// If the requirements are met the loop will end 
    	counter = 0;
    }

for (int i = 0; i < encryptedText.length(); i++) {
	int bellCount= encryptedText.charAt(i) - keyBell.charAt(i);// Taking the encryption away from the String according the counter so one by one
	if (bellCount < LOWER_BOUND) { //Testing if it is in bounds
		while (bellCount < LOWER_BOUND)
			bellCount = bellCount + RANGE; 
	}
deBellaso +=(char) bellCount; //Adding the decrypted string to the variable to be returned 
}
return deBellaso;//Returning the decrypted string 
	}
}
