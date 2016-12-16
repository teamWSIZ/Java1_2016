package zajecia_XII_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    //Ta funkcja ustawia kolor tła przycisków na taki jaki był na początku (`czystyKolor`)
    private void czyscButtonyMin() {
        a1Button.setBackground(czystyKolor);
        a2Button.setBackground(czystyKolor);
        a3Button.setBackground(czystyKolor);
        a4Button.setBackground(czystyKolor);
        a5Button.setBackground(czystyKolor);
    }


    //To jest konstruktor, czyli coś uruchamianego w momencie wykonania `new Saper()`
    public Saper() {
        czystyKolor = a1Button.getBackground(); //zczytujemy jakie jest zwykłe tło przycisków

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
