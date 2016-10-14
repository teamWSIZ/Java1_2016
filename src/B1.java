/**
 * Created on 14.10.16, at 18:18
 */
public class B1 {

    public static void main(String[] args) {
//        int x = 1;
//        int y = 33;
//
//        if (x==y) {
//            System.out.println("x jest równe y");
//        }
//        if (x<y) {
//            System.out.println("x jest mniejsze niż y");
//        }
//        //---------------------------------


        int szukanyKod = 12;

        for (int spr = 0; spr < 20; spr++) {
            System.out.println("Sprawdzam kod dla spr=" + spr);
            if (spr==szukanyKod) {
                System.out.println("Trafiłem; szukany kod był równy: " + spr);
            } else {
                System.out.println("Nie trafiony");
            }
        }



    }

}
