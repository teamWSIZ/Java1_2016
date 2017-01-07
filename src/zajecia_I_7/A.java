package zajecia_I_7;

import java.util.Arrays;

/**
 * Created on 07.01.17, at 12:22
 */
public class A {
    public static void main(String[] args) {
        String oc = "4, 4.5, 3, 3 , 5";
        String[] oceny = oc.split(",");
        System.out.println(Arrays.toString(oceny));

        double suma = 0;

        for (int i = 0; i < oceny.length; i++) {
            System.out.println("Element numer " + i + " =" + oceny[i]);
            double nota = Double.valueOf(oceny[i]);
            suma += nota;
            System.out.println("razy dwa: " + nota*2 + " teraz suma=" + suma);
        }

        System.out.println("suma całkowita = " + suma);
        System.out.println("średnia arytmetyczna = " + (suma / oceny.length));
    }

}
