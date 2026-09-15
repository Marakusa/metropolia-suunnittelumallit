package Decorator;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptedPrinter implements Printer {
    private final Printer printer;

    private final SecretKey secretKey;
    private final Cipher cipher;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;

        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            secretKey = keyGenerator.generateKey();
            cipher = Cipher.getInstance("AES");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing encryption: " + e.getMessage());
        }
    }

    public void print(String message) {
        try {
            printer.print(encrypt(message, secretKey));
        } catch (Exception e) {
            System.out.println("Error encrypting message: " + e.getMessage());
        }
    }

    private String encrypt(String plainText, SecretKey secretKey) throws Exception {
        byte[] plainTextByte = plainText.getBytes();

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedByte = cipher.doFinal(plainTextByte);

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encryptedByte);
    }
}
