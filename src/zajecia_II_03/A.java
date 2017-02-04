package zajecia_II_03;

/**
 * Created by stasz_000 on 2017-02-04.
 */
public class A {
    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 6, 8};
        int total = 12; //odp: tak
        //total = 11; //odp: nie

        int dlugoscTab = a.length;
        int x = a[2]; //trzeci z kolei element tablicy

        //podp: użyć dwóch pętli

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i==j){continue;}
                if (a[i]+a[j]==total){
                    System.out.println(a[i]+" " +a[j]);
                }
            }
        }

    }
}
