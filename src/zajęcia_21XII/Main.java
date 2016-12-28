package zajêcia_21XII;

public class Main { //Klasa

    public static void main(String[] args) {//funkcja nic nie zwracaj¹ca i przyjmuje jeden parametr (tablicê String'ów)

        int[] tablica_1 = new int[10]; //1 zapis tablicy która ma 10 elementów wype³niona domyœlnie zerami (0)
        int[] tablica_2 = new int[]{2, 3, 4, 5, 6}; //2 zapis tablicy ju¿ wype³nione
        int[] tablica_3 = {53, 564, 3452, 234423}; //3 zapisz równie¿ wype³nionej (skrócona wersja tego wy¿ej)

        // przypisywanie wartoœci
        tablica_1[0] = 10;
        tablica_1[3] = 22;
        tablica_1[1] = 6;
        tablica_1[9] = 21;

        //d³ugoœæ tablicy
        int d³ugoœæ = tablica_1.length;
        System.out.println("" + d³ugoœæ);

        //wypiswyanie wartoœci z tablicy_1
        for (int i = 0; i < tablica_1.length; i++) {
            int wartoœæ = tablica_1[i];
            System.out.println(wartoœæ);
        }

        //wywo³anie funkcji nic nie zwracajacej
        wypiszWartoœci(tablica_2);
        wypiszWartoœci(tablica_3);

        //funkcja zwracaj¹ca
        String naszeWartoœci = zwrócWartoœæZTablicy(tablica_1); //zwracane wartoœci przypisujemy do zmiennej String
        System.out.println(naszeWartoœci);

    }

    // pryvatna funkcja która nic nie zwraca i przyjmuje jeden parametr tablicê int'ów
    /*
    private - motyfikator dostêpu (jest dostêpny tylko w tej klasie gdzie zosta³a stworzona)
    static - tworzona od razu przy startowaniu programu (static = niezmienna wiecznie sta³a)
    void - typ czyli nic nie zwracaj¹ca
    wypiszWartoœci - nasz nazwa funkcji
    w ( _parametr) - w nawiasach podaje siê parametry jakie bêdzie przyjmowaæ
     */
    private static void wypiszWartoœci(int[] parametr_tablica) {
        for (int i = 0; i < parametr_tablica.length; i++) {
            System.out.println("" + parametr_tablica[i]);
        }
    }

    //zamiast void jest String (czyli typ) wszystko poza void'em jest funkj¹ zwracaj¹c¹
    private static String zwrócWartoœæZTablicy(int[] tablica)
    {
        String temp="";

        for (int i = 0; i < tablica.length; i++) {
            temp += tablica[i] +" ";
        }

        return  temp;
    }
}
