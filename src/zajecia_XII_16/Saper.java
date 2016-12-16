package zajecia_XII_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

/**
 * Created on 16.12.16, at 18:10
 */
public class Saper {
    private JPanel fff;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton pokazMinyButton;
    private JButton wylosujNaNowoButton;
    private JButton ukryjMinyButton;

    ///////////////////////////////////
    // Model
    int[] miny = new int[5];
    Color czystyKolor;  //początkowe tło przycisków; zczytujemy w konstruktorze
    JButton[] butony;

    ///////////////////////////////////

    //To jest nasza tzw. funkcja (prywatna metoda)
    private void wylosujMiny() {
        //Czyszczenie informacji o minach
        for (int i = 0; i < 5; i++) {
            miny[i] = 0;
        }

        //Generowanie losowych pozycji min
        Random rr = new Random();
        for (int i = 0; i < 3; i++) {
            int pozycja = rr.nextInt(5);    //losuje liczbe 0..4
            miny[pozycja] = 1;  //ustawienie, ze na tej pozycji ma byc mina
        }
    }

    //Ta funkcja wylicza ile jest min na lewo i prawo od pozycji `poz`
    public int ileMinUSasiadow(int poz, int[] miny) {
        if (poz==0) return miny[1];
        if (poz==4) return miny[3];
        int ile = 0;
        if (miny[poz-1]==1) ++ile;
        if (miny[poz+1]==1) ++ile;
        return ile;
    }

    //Ta funkcja ustawia kolor tła przycisków na taki jaki był na początku (`czystyKolor`)
    private void czyscButtonyMin() {
        a1Button.setBackground(czystyKolor);
        a2Button.setBackground(czystyKolor);
        a3Button.setBackground(czystyKolor);
        a4Button.setBackground(czystyKolor);
        a5Button.setBackground(czystyKolor);
        for (int i = 0; i < 5; i++) {
            butony[i].setText(" ");
        }
    }


    //To jest konstruktor, czyli coś uruchamianego w momencie wykonania `new Saper()`
    public Saper() {
        czystyKolor = a1Button.getBackground(); //zczytujemy jakie jest zwykłe tło przycisków
        //Zbieranie buttonów do tablicy
        butony = new JButton[]{a1Button, a2Button, a3Button, a4Button, a5Button};
        czyscButtonyMin();



        System.out.println("Generuję miny...");
        wylosujMiny();
        System.out.println("miny:" + Arrays.toString(miny));


        ///Wygenerowane z GUI
        pokazMinyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czyscButtonyMin();
                if (miny[0]==1) a1Button.setBackground(Color.RED);
                if (miny[1]==1) a2Button.setBackground(Color.RED);
                if (miny[2]==1) a3Button.setBackground(Color.RED);
                if (miny[3]==1) a4Button.setBackground(Color.RED);
                if (miny[4]==1) a5Button.setBackground(Color.RED);
            }
        });
        wylosujNaNowoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wylosujMiny();
            }
        });
        ukryjMinyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czyscButtonyMin();
            }
        });

        /**
         * Uwaga: to jest automatyzacja dodawania listenerów do wszystkich buttonów;
         * alternatywnie można po kolei dla każdego dodać takie akcje.
         */
        for(int i=0; i<5; i++) {
            final Integer poz = i;
            butony[poz].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (miny[poz]==1) butony[poz].setBackground(Color.BLACK);
                            else {
                                butony[poz].setBackground(Color.GREEN);
                            }
                            butony[poz].setText(""+ileMinUSasiadow(poz, miny));
                        }
                    }
            );
            butony[poz].addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (e.getButton()!=3) return;
                            butony[poz].setBackground(Color.ORANGE);
                        }
                    }
            );
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Saper");
        frame.setContentPane(new Saper().fff);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
