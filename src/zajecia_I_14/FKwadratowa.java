package zajecia_I_14;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stasz_000 on 2017-01-14.
 */
public class FKwadratowa {
    private JPanel panel1;
    private JButton button1;
    private JTextField wartosci;
    private JTextField wyswietlWinyk;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FKwadratowa");
        frame.setContentPane(new FKwadratowa().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FKwadratowa() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //4,5,2
                String[] napis = wartosci.getText().split(",");
                // zamieniamy napisy z tablicy na liczby
                int a = Integer.valueOf(napis[0]);
                int b = Integer.valueOf(napis[1]);
                int c = Integer.valueOf(napis[2]);

                double dt = b * b - 4 * a * c;
                if (dt > 0) {
                    //liczymy delte i wyciągamy pierwiastek (Math.sqrt() liczy na pierwiastek z liczby)
                    double pDt = Math.sqrt(dt);
                    double x1 = (-b - pDt) / 2 * a;
                    double x2 = (-b + pDt) / 2 * a;
                    wyswietlWinyk.setText("X1 = " + x1 + " X2 = " + x2);
                } else if (dt == 0) {
                    wyswietlWinyk.setText("X0 = " + (-b / 2 * a));
                } else {
                    wyswietlWinyk.setText("Delta jest ujemna");
                }
            }
        });
    }
}


