package zajecia_I_7;

/**
 * Created on 07.01.17, at 12:19
 */

import javax.swing.*;

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
