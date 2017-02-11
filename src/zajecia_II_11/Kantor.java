package zajecia_II_11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by stasz_000 on 2017-02-11.
 */
public class Kantor {
    private JPanel tt;
    private JButton btnSprz;
    private JButton btnKup;
    private JLabel eKupno;
    private JLabel rKupno;
    private JLabel eIle;
    private JLabel rIle;
    private JLabel lblKonto;
    private JRadioButton walutaRubel;
    private JRadioButton walutaEuro;
    private JComboBox comboBox1;

    //Dane w systemie (kursy walut i ilość gotówki)
    private Double kursEuro;
    private Double kursRubla;
    private double konto = 1000.00;

    /**
     * Funkcja odświeżająca label-e pokazujące ceny walut
     */
    private void refreshWindow() {
        //Formatowanie zmiennych ułamkowych tak, by pokazywało 4 miejsca po przecinku
        String rubel = String.format(java.util.Locale.US, "%.4f", kursRubla);
        String euro = String.format(java.util.Locale.US, "%.4f", kursEuro);
        //Wyświetlanie na GUI
        rKupno.setText("" + rubel);
        eKupno.setText("" + euro);
        //napisać zliczanie pieniedzy
    }

    public Kantor() {
        lblKonto.setText(konto + "");
        kursEuro = new Double(4.20);
        kursRubla = new Double(0.069);

        /**
         * To jest mechanizm który dokładnie co 1sekundę losuje zmiany ceny walut i
         * wywołuje odświeżanie ich wyświetlania na GUI;
         *
         * Można dociągnąć dane z internetu: https://cinkciarz.pl/statics/currency/eur/ajax
         */
        Thread timerek = new Thread(new Runnable() {
            @Override
            public void run() {
                Random r = new SecureRandom();
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    kursEuro *= (1 + 0.01 * r.nextGaussian());
                    kursRubla *= (1 + 0.05 * r.nextGaussian());
                    SwingUtilities.invokeLater(() -> {
                        refreshWindow();
                    });
                }
            }
        });
        timerek.start();


        btnKup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sztuk = Integer.valueOf((String) comboBox1.getSelectedItem());
                if (walutaEuro.isSelected()) {
                    int posiadaneEUR = Integer.valueOf(eIle.getText());
                    posiadaneEUR += kupWalute(kursEuro, sztuk);
                    eIle.setText("" + posiadaneEUR);

                } else if (walutaRubel.isSelected()) {
                    int posiadaneRuble = Integer.valueOf(rIle.getText());
                    posiadaneRuble += kupWalute(kursRubla, sztuk);
                    rIle.setText("" + posiadaneRuble);
                }
                lblKonto.setText(String.format(java.util.Locale.US, "%.2f", konto));
            }
        });

        btnSprz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ileSztuk = Integer.valueOf((String) comboBox1.getSelectedItem());
                if (walutaEuro.isSelected()) {
                    int posiadaneEuro = Integer.valueOf(eIle.getText());
                    posiadaneEuro -= sprzedajWalute(kursEuro, ileSztuk, posiadaneEuro);
                    eIle.setText(posiadaneEuro + "");

                } else if (walutaRubel.isSelected()) {
                    int posiadaneRuble = Integer.valueOf(rIle.getText());
                    posiadaneRuble -= sprzedajWalute(kursRubla, ileSztuk, posiadaneRuble);
                    rIle.setText(posiadaneRuble + "");
                }
                lblKonto.setText(String.format(java.util.Locale.US, "%.2f", konto));
            }
        });
    }

    /**
     * Funkcja próbująca kupić walutę po cenie `cena`; liczba do kupienia jest odczytywana z
     * `comboBox1`.
     */
    private int kupWalute(double cena, int sztuk) {
        if (konto >= sztuk * cena) {
            konto -= sztuk * cena;
            return sztuk;
        } else {
            return 0;
        }
    }

    private int sprzedajWalute(double cena, int sztuk, int posiadane) {
        if (posiadane >= sztuk) {
            konto = konto + (cena * sztuk);
            return sztuk;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kantor");
        frame.setContentPane(new Kantor().tt);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
