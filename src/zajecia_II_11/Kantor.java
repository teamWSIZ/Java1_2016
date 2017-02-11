package zajecia_II_11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Function;

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
    private JRadioButton radioButton2;
    private JRadioButton radioButton1;
    private JComboBox comboBox1;

    private Double kursEuro;
    private Double kursRubla;
    private double konto = 1000.00;

    private void refreshWindow() {
        String rubel = String.format(java.util.Locale.US,"%.4f", kursRubla);
        String euro = String.format(java.util.Locale.US,"%.4f", kursEuro);
        rKupno.setText("" + rubel);
        eKupno.setText("" + euro);
    }

    public Kantor() {
        lblKonto.setText(konto +"");
        kursEuro = new Double(4.20);
        kursRubla = new Double(0.069);
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
                    SwingUtilities.invokeLater(()->{
                        refreshWindow();
                    });
                }
            }
        });
        timerek.start();

        btnKup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton1.isSelected())
                {

                }else
                {

                }
            }
        });

        btnSprz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton1.isSelected())
                {

                }else
                {

                }
            }
        });
    }

    private int kupWalute(double cena)
    {
        int ile = (int)comboBox1.getSelectedItem();
        if(konto > ile*cena){
            konto -= ile*cena;
            return ile;
        }
        else
            return 0;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kantor");
        frame.setContentPane(new Kantor().tt);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
