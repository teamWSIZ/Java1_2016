package b;

/**
 * Created on 15.10.16, at 13:54
 */

public class B23 {

    public static void main(String[] args) {
        //poszukiwanie liczb podzielnych przez 7, nie większych niż 1007
        int ileX = 0;
        for (int i = 0; i <= 1007; i++) {
            if (i%7==0) {
                ileX++; //to samo co ileX = ileX +1, albo ileX += 1
            }
        }
        System.out.println("liczba podzielników: " + ileX);

        //poszukiwanie takich liczb a, b, że a*a + b*b = 148
        int liczba = 148;
        for (int a = 0; a < Math.sqrt(liczba)+1; a++) {
            for (int b = 0; b < a; b++) {
                if (a*a + b*b==liczba) {
                    System.out.println("a=" + a + " b=" + b);
                }
            }
        }

        String s = "abra kadabra";
        //poszukiwanie częstości występowania litery 'a'
        int ileA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='a') {
                ileA ++;
            }
        }
        System.out.println("'a' występuje " + ileA + " razy");

        String p = "abbsbba";
        //sprawdzenie czy 'p' jest palindormą, czyli czy `p` czytany wspak jest taki sam jak `p`
        boolean jest = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i)!=p.charAt(p.length()-1-i)) {
                jest = false;
            }
        }
        if (jest) {
            System.out.println("jest palindromą");
        } else {
            System.out.println("nie jest palindormą");
        }


        String q = "Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut molestie a, ultricies porta urna.";
        //Sprawdzenie która litera występuje najczęściej (zadanie z *)
        q = q.toLowerCase();    //zamieniamy na małe litery

        char bestLetter = 'a';
        int howMany = '0';
        for(char lit = 'a'; lit <='z'; lit++) {
            int ile = 0;
            for (int i = 0; i < q.length(); i++) {
                if (q.charAt(i)==lit) {
                    ile++;
                }
            }
            if (ile>howMany) {
                howMany = ile;
                bestLetter = lit;
            }
        }
        System.out.println("Najczęściej występuje litera '" + bestLetter + "', dokładnie " + howMany + " razy" );


    }
}
