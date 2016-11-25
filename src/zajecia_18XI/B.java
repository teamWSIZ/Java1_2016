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
        w += '*';
        System.out.println("długość=" + napis.length());

        int dlugoscTeraz = napis.length();
        int maByc = 16;
        int ileGwiazdek = maByc - dlugoscTeraz;






    }
}
