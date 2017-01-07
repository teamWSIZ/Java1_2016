package zajecia_21XII;

public class Main { //Klasa

    public static void main(String[] args) {//funkcja nic nie zwracająca i przyjmuje jeden parametr (tablicę String'ów)

        int[] tablica_1 = new int[10]; //1 zapis tablicy która ma 10 elementów wypełniona domyślnie zerami (0)
        int[] tablica_2 = new int[]{2, 3, 4, 5, 6}; //2 zapis tablicy już wypełnione
        int[] tablica_3 = {53, 564, 3452, 234423}; //3 zapisz również wypełnionej (skrócona wersja tego wyżej)

        // przypisywanie wartości
        tablica_1[0] = 10;
        tablica_1[3] = 22;
        tablica_1[1] = 6;
        tablica_1[9] = 21;

        //dlugosc tablicy
        int dlugosc = tablica_1.length;
        System.out.println("" + dlugosc);

        //wypiswyanie wartości z tablicy_1
        for (int i = 0; i < tablica_1.length; i++) {
            int wartosc = tablica_1[i];
            System.out.println(wartosc);
        }

        //wywołanie funkcji nic nie zwracajacej
        wypiszWartosci(tablica_2);
        wypiszWartosci(tablica_3);

        //funkcja zwracająca
        String ourVaules = tableToString(tablica_1); //zwracane wartości przypisujemy do zmiennej String
        System.out.println(ourVaules);

    }

    // pryvatna funkcja która nic nie zwraca i przyjmuje jeden parametr tablicę int'ów
    /*
    private - motyfikator dostępu (jest dostępny tylko w tej klasie gdzie została stworzona)
    static - tworzona od razu przy startowaniu programu (static = niezmienna wiecznie stała)
    void - typ czyli nic nie zwracająca
    wypiszWartosci - nasz nazwa funkcji
    w ( _parametr) - w nawiasach podaje się parametry jakie będzie przyjmować
     */
    private static void wypiszWartosci(int[] parametr_tablica) {
        for (int i = 0; i < parametr_tablica.length; i++) {
            System.out.println("" + parametr_tablica[i]);
        }
    }

    //zamiast void jest String (czyli typ) wszystko poza void'em jest funkją zwracającą
    private static String tableToString(int[] tablica)
    {
        String temp="";

        for (int i = 0; i < tablica.length; i++) {
            temp += tablica[i] +" ";
        }

        return  temp;
    }
}