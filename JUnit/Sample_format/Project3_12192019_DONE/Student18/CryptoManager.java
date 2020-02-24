public class CryptoManager {
	static int LOWER_BOUND = 32;
	static int UPPER_BOUND = 95;
	public static boolean stringInBounds(String plainText) {
		boolean flag = true;
		for (int i = 0; i < plainText.length(); i++) {
			if (!((int) plainText.charAt(i) >= LOWER_BOUND && (int) plainText.charAt(i) <= UPPER_BOUND)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	//encrypts a string according to Caesar Cipher
	public static String encryptCaesar(String plainText, int key) {
		key = Wrap_around(key);
		String result = "";
		for (int i = 0; i < plainText.length(); i++) {
			result += Character.toString((char) ((int) plainText.charAt(i) + key));
		}
		return result;
	}
	//decrypts a string according to Caesar Cipher
	public static String decryptCaesar(String encryptedText, int key) {
		key = Wrap_around(key);
		String org = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			org += Character.toString((char) ((int) encryptedText.charAt(i) - key));
		}
		return org;
	}
	public static int Wrap_around(int key) {
		while (key > UPPER_BOUND) {
			key -= (UPPER_BOUND - LOWER_BOUND);
		}
		return key;
	}
	//encrypts a string according to Bellaso Cipher
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String result = "";
		//adjusts length of bellasoStr to plainText
		while (bellasoStr.length() < plainText.length()) {
			bellasoStr += bellasoStr.substring(0, (plainText.length() - bellasoStr.length()));
		}
		for (int i = 0; i < plainText.length(); i++) {
			char c = (char) Wrap_around((int) plainText.charAt(i) + (int) bellasoStr.charAt(i));
			result += Character.toString(c);
		}
		return result;
	}
	//decrypts a string according to Bellaso Cipher
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String result = "";
		//adjusts length of bellasoStr to plainText
		while (bellasoStr.length() < encryptedText.length()) {
			bellasoStr += bellasoStr.substring(0, (encryptedText.length() - bellasoStr.length()));
		}
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = (char) Wrap_around((int) encryptedText.charAt(i) - (int) bellasoStr.charAt(i));
			result += Character.toString(c);
		}
		return result;
	}
}