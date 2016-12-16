package zajecia_XII_16;

import java.util.Arrays;
import java.util.Random;

/**
 * Created on 16.12.16, at 18:14
 */
public class A {

    public static int ileMinUSasiadow(int poz, int[] miny) {
        if (poz==0) return miny[1];
        if (poz==4) return miny[3];
        int ile = 0;
        if (miny[poz-1]==1) ++ile;
        if (miny[poz+1]==1) ++ile;
        return ile;
    }

    public static void main(String[] args) {
        //To są tablice liczb całkowitych w Javie
        int[] miny = new int[5];
//        miny[2] = 1;
//        miny[1] = 1;

        if (miny[1]==1) {
            System.out.println("na pozycji 1 jest mina");
        }

        Random rr = new Random();
        int xx = rr.nextInt(10);    //liczba z [0..9] włącznie

        for (int i = 0; i < 3; i++) {
            miny[rr.nextInt(5)]=1;
        }

        //ile jest min woków pozycji nr. 2?
        int ile = 0;
        if (miny[1]==1) ile++;
        if (miny[3]==1) ile++;
        //wynik jest w "ile"

        System.out.println(Arrays.toString(miny));
        System.out.println(ileMinUSasiadow(0, miny));

    }
}
