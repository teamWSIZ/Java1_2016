package zajecia_4XI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//9D068491DF5B6D4A7702277372B781BB0F17CDDE835C67CF313DD0C61434A29A6B2E74D4D620E247F2A537A79A706C3766AB51C8F45930A92290FFFAECF99437


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

    private String wyrownajHaslo(String napis) {
        return (napis + "*************************").substring(0, 16);
    }


    public KodGUI() {
        zakodujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wiadomosc = textArea1.getText();
                String haslo = new String(passwordField1.getPassword());
                haslo = wyrownajHaslo(haslo);
                String zakodowana = "";
                try {
                    zakodowana = MaszynaKodowa.zakodujWiadomosc(wiadomosc, haslo);
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
                haslo = wyrownajHaslo(haslo);
                String odkodowana = "";
                try {
                    odkodowana = MaszynaKodowa.odkodujWiadomosc(wiadomosc, haslo);
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
