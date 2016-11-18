package zajecia_X;

/**
 * Created on 07.10.16, at 18:09
 */
public class A1 {
    //psvm + [tab]
    public static void main(String[] args) {
        //sout + [tab]
        System.out.println("hi");

        int x = 10;
        int y = 3;
        int z = x % y;
        System.out.println(x);
        System.out.println("y=" + y);
        System.out.println("reszta z dzielenia x/y wychodzi " + z);

        System.out.println(6 * 6 * 6 * 6 * 6);
        int liczba = 17;
        //czy to jest liczba pierwsza?
        for (int i = 2; i < liczba; i++) {
            System.out.println("Reszta z dzielenia " + liczba + " przez " + i + " to: " + (liczba%i));
            System.out.println("i=" + i);
        }

        if (x == 10) {
            System.out.println("x jest rowne 10");
        } else {
            System.out.println("x to nie jest 10");
        }



    }
}
