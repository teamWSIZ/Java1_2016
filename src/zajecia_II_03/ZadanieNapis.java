package zajecia_II_03;

/**
 * Created by stasz_000 on 2017-02-03.
 */
public class ZadanieNapis {
    public static void main(String[] args) {
        String napis = "asdfdhfgjjhlkk";
        System.out.println(napis.length());
        //pobiera literke z napisu na danej pozycji 0-12
        System.out.println(napis.charAt(12)); //== k

        // dzieli napis od danej pozycji do ilosci znaków
        System.out.println(napis.substring(3, 4));

        System.out.println("-------------------");


        //przykład pętli
        for(int i = 10; i < 20; i += 2) {
            System.out.println("i=" + i);
            System.out.println("-----");
        }

        String s = "fog";
        System.out.println(s.charAt(0)); //znak na pozycji "0" w napisie `s`
        System.out.println("");

        System.out.println("Liczba liter w napisie `s` = " + s.length());


        // rozwiazanie zadania
        for (int i = 0; i < napis.length()-1; i++) {
            if(napis.charAt(i)==napis.charAt(i+1)){
                //podmiana podwójnych literek na literke z *
                napis=napis.replace(napis.charAt(i)+""+napis.charAt(i+1),
                        napis.charAt(i)+"*"+napis.charAt(i+1));


            }
        }
        System.out.println("========================\n"+napis);

        int[] tab = new int[]{1,2,3,4,2,4}; //--> 1,3

        int n = tab.length;  ///ile jest elementów w tablicy
        for(int x : tab) {
            //co zrobić z elementem "x"
        }
        //ArrayIndexOutOfBound Exception --> rządamy elementu z pozycji
        //która leżałaby poza tablicą

        //int[] cnt = new int[1000];  //tablica z 1000 elementów, ustawionych na 0

        //można wykorzystać kod typu cnt[tab[2]] += 1;

        int a = 2;
        System.out.println(Math.sin(a));
    }
}
