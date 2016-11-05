package kalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 05.11.16, at 14:09
 */
public class KodGUI {
    private JTextArea textArea1;
    private JPasswordField passwordField1;
    private JButton zakodujButton;
    private JButton odkodujButton;
    private JTextArea textArea2;
    private JPanel aa;

    public KodGUI() {
        zakodujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wiadomosc = textArea1.getText();
                String haslo = new String(passwordField1.getPassword());
                String zakodowana = "";
                try {
                    zakodowana = Kod.zakodujWiadomosc(wiadomosc, haslo);
                } catch (Exception ee) {
                    //
                    System.out.println(ee);
                }
                textArea2.setText(zakodowana);
            }
        });
        odkodujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wiadomosc = textArea1.getText();
                String haslo = new String(passwordField1.getPassword());
                String odkodowana = "";
                try {
                    odkodowana = Kod.odkodujWiadomosc(wiadomosc, haslo);
                } catch (Exception ee) {
                    //
                    System.out.println(ee);
                }
                textArea2.setText(odkodowana);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KodGUI");
        frame.setContentPane(new KodGUI().aa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
