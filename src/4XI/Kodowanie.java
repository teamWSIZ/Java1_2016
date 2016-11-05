package obiektowe;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;

/**
 * Created on 05.11.16, at 13:12
 */
public class Kodowanie {
    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    //hasło ma mieć 16 znaków
    public static String zakodujWiadomosc(String wiadomosc, String haslo) throws Exception {
        String key = haslo; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        byte[] encrypted = cipher.doFinal(wiadomosc.getBytes());
        String hexEncrypted = toHexString(encrypted);
        return hexEncrypted;
    }

    //hasło ma mieć 16 znaków
    public static String odkodujWiadomosc(String hexZakodowanaWiadomosc, String haslo) throws Exception {
        String key = haslo; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher2.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher2.doFinal(toByteArray(hexZakodowanaWiadomosc));
        return new String(original);
    }

    public static void main(String[] args) throws Exception {
        String wiad = "TaJnA";
        String pass = "1234567890123456";

        String zakodowana = zakodujWiadomosc(wiad, pass);
        System.out.println("encrypted string: " + zakodowana);

        //-------------------------------------

        System.out.println("odkodowana: " + odkodujWiadomosc(zakodowana, pass));
    }
}
