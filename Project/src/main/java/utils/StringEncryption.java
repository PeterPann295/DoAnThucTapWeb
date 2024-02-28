package utils;

import java.util.Base64;

public class StringEncryption {
	 public static String encryptString(String plainText) {
	        // Mã hóa chuỗi
	        byte[] encodedBytes = Base64.getEncoder().encode(plainText.getBytes());
	        return new String(encodedBytes);
	    }

	    public static String decryptString(String encryptedText) {
	        // Giải mã chuỗi
	        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText.getBytes());
	        return new String(decodedBytes);
	    }

	    public static void main(String[] args) {
	        // Chuỗi cần mã hóa
	        String originalString = "333333";

	        // Mã hóa chuỗi
	        String encryptedString = encryptString(originalString);
	        System.out.println("Encrypted String: " + encryptedString);

	        // Giải mã chuỗi
	        String decryptedString = decryptString(encryptedString);
	        System.out.println("Decrypted String: " + decryptedString);
	    }
}
