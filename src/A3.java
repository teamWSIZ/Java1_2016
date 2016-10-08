/**
 * Created by user49 on 10/8/16.
 */
public class A3 {
    public static void main(String[] args) {
        System.out.println("hello");

        int a = 12;
        int b = 9;
        int c = b / a;
        System.out.println(c);

        String s = "aaa bb";
        s = s + " xxy";
        System.out.println(s);

        if (a > 10) {
            System.out.println("A jest duże");
            System.out.println("......");
        } else {
            System.out.println("A jest małe");
            System.out.println("______");
        }

        if ((a > 10) && (b > 50)) {
            System.out.println("Sukces!");
        }
        if (a==12) {

        }
        System.out.println(" A jest rowne " + a + " cm");

        int bokA = 10;
        int bokB = 120;
        int bokC = 9;

        if ((bokA + bokB > bokC) && (bokB + bokC > bokA) && (bokC + bokA > bokB)) {
            System.out.println("Jest trójkąt!!");
        } else {
            System.out.println("Nie da się zbudować trójkąta");
        }


    }
}
