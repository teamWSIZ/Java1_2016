package zajecia_I_7;

/**
 * Created on 07.01.17, at 12:19
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Okno do liczenia średniej z ocen
 * Input: text_field --> oceny z przecinkami
 * Button
 * Okno output ze średnią ocen
 */
public class Oceny {

    private JTextField textField1;
    private JButton liczSredniaButton;
    private JTextField textField2;
    private JPanel mp;
    private JLabel label1;

    public Oceny() {
        liczSredniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oc = textField1.getText();
                String[] oceny = oc.split(",");
                System.out.println(Arrays.toString(oceny));

                double suma = 0;

                for (int i = 0; i < oceny.length; i++) {
                    System.out.println("Element numer " + i + " =" + oceny[i]);
                    double nota = Double.valueOf(oceny[i]);
                    suma += nota;
                    System.out.println("razy dwa: " + nota*2 + " teraz suma=" + suma);
                }
                double avg = suma / oceny.length;
                textField2.setText(String.valueOf(avg));
            }
        });
    }

    private void createUIComponents() {
        label1 = new JLabel("");
        label1.setIcon(new ImageIcon("resources/hat.png"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Oceny");
        frame.setContentPane(new Oceny().mp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
