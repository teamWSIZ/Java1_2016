package zajecia_18XI;

/**
 * Created on 19.11.16, at 12:21
 */
public class B {

    public static void main(String[] args) {
        //Dany jest napis dowolnej długości
        //zamienić go na napis długości 16B; jeśli był krótszy to dopisać '*', jeśli dłuższy, to obciąć

        String napis = "abrakadabra";
        String w = napis.substring(0, 4);
        w += 'a';
        System.out.println("długość=" + napis.length());


        (napis + "**************************").substring(0, 16);

    }
}
