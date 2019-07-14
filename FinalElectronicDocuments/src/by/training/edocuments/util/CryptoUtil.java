package by.training.edocuments.util;

import java.security.spec.KeySpec;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import by.training.edocuments.connection.ConnectionPool;

public class CryptoUtil {
     
        private static final String UNICODE_FORMAT;
        private static final String DESEDE_ENCRYPTION_SCHEME;
        private  static final String MY_ENCRYPT_KEY;
        
        static {
        	Properties properties = new Properties();
    	    try {
    	    	properties.load(ConnectionPool.class.getClassLoader().getResourceAsStream("app.properties"));	
    	    } catch (Exception e) {
    	    	e.printStackTrace();
    	    }
            UNICODE_FORMAT = properties.getProperty("UNICODE_FORMAT");
            DESEDE_ENCRYPTION_SCHEME = properties.getProperty("DESEDE_ENCRYPTION_SCHEME");
            MY_ENCRYPT_KEY = properties.getProperty("MY_ENCRYPT_KEY");
        }
        
        private KeySpec ks;
        private SecretKeyFactory skf;
        private Cipher cipher;
        byte[] arrayBytes;
        
        private String myEncryptionScheme;
        SecretKey key;

        public CryptoUtil() throws Exception {
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            arrayBytes = MY_ENCRYPT_KEY.getBytes(UNICODE_FORMAT);
            ks = new DESedeKeySpec(arrayBytes);
            skf = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = skf.generateSecret(ks);
        }


        public String encrypt(String unencryptedString) {
            String encryptedString = null;
            try {
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
                byte[] encryptedText = cipher.doFinal(plainText);
                encryptedString = new String(Base64.encodeBase64(encryptedText));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encryptedString;
        }


        public String decrypt(String encryptedString) {
            String decryptedText=null;
            try {
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte[] encryptedText = Base64.decodeBase64(encryptedString);
                byte[] plainText = cipher.doFinal(encryptedText);
                decryptedText= new String(plainText);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return decryptedText;
        }


        public static void main(String args []) throws Exception
        {
            CryptoUtil td= new CryptoUtil();

            String target="111";
           // String decrypted_test=td.decrypt(target);
            String encrypted=td.encrypt(target);
            String decrypted=td.decrypt(encrypted);
            System.out.println("String To Encrypt: "+ target);
            System.out.println("Encrypted String:" + encrypted);
            System.out.println("Decrypted String:" + decrypted);

        }
}
