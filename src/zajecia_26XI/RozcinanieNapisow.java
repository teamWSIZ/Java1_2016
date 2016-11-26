package zajecia_26XI;

/**
 * Zagadnienia trudniejsze: rozcinanie napisów, pętle po elementach tablic
 */
public class RozcinanieNapisow {
    public static void main(String[] args) {

        //rozcinanie napisu po przecinkach
        String wczytany = "Shell,4.52,200";
        String[] rozciete = wczytany.split(",");
        System.out.println(rozciete[0]);
        System.out.println(rozciete[1]);
        System.out.println(rozciete[2]);

        //--------------------------

        String skopiowane = "aaaaa aaa aa\nddd ddd";  //dwie linie tekstu

        String[] roz = skopiowane.split("\n");  //rozcięcie po liniach --> 2 elementy
        for(String linia : roz) {
            System.out.println("--->" + linia);
            String[] pocietaLinia = linia.split(" "); //rozcięcie po spacjach
            System.out.println("Linia ma:" + pocietaLinia.length + " wyrazów");
            for(String wyraz : pocietaLinia) {
                System.out.println("    |-->" + wyraz);
            }
        }
    }
}
