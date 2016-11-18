package zajecia_X;

/**
 * Created by user49 on 10/8/16.
 */
public class A2 {
    //psvm + tab
    public static void main(String[] args) {
        //sout + tab
        System.out.println(" Hello!");

        int a = 12;
        int b = 8;
        System.out.println(a * b);
        int c = a * b;
        System.out.println(c);

        String n1 = "Abra";
        String n2 = "Kadabra";
        System.out.println(n1 + " " + n2);

        int xx = 15;
        if (xx>10) {
            System.out.println("X jest równe 10");
        } else {
            System.out.println("X to nie jest 10");
        }

        int x = 5;
        int y = 6;
        int z = 5;
        //? jesli da sie zrobic trojkat --> "TAK", jesli nie "NIE"

//        if (xx==15) {
//            if (x == 5) {
//                System.out.println("OK");
//            }
//        }

        if (x==5 || y==5) {
            System.out.println("ktoras liczba jest 5");
        }

        if (x==5 && y==5) {
            System.out.println("Obie liczby to 5");
        }

        if (x==5)
            if (x==6)
                if (x==7)
                    System.out.println("ok");


    }
}
