package zajecia_XII_16;

import java.util.Random;

/**
 * Created on 16.12.16, at 18:14
 */
public class A {
    public static void main(String[] args) {
        //To są tablice liczb całkowitych w Javie
        int[] miny = new int[5];
        miny[2] = 1;
        miny[1] = 1;

        if (miny[1]==1) {
            System.out.println("na pozycji 1 jest mina");
        }

        Random rr = new Random();
        int xx = rr.nextInt(10);    //liczba z [0..9] włącznie



    }
}
