package files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * Created by pm on 1/21/17.
 */
public class WriteFajl {
    public static void main(String[] args) throws IOException {
        String burak = "abra\nkadabra";  //  "\n" oznacza znak nowej linii
        System.out.println(burak);

        File f = new File("abc.txt");
        Files.write(f.toPath(), burak.getBytes("UTF-8"));  //zapis pliku z kodowaniem tekstu UTF-8

        f = new File("abc.txt");

        //odczyt pliku z kodowaniem UTF-8
        for(String s : Files.readAllLines(f.toPath(), Charset.forName("UTF-8"))) {
            System.out.println(s);
        }
    }
}
