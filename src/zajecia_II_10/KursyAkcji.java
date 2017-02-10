package zajecia_II_10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.PaintEvent;

/**
 * Created by stasz_000 on 2017-02-10.
 */
public class KursyAkcji {
    private JTextField a100TextField;
    private JTextField a110TextField;
    private JTextField a112TextField;
    private JTextField a130TextField;
    private JPanel kk;
    private JButton obliczZyskButton;
    private JTextField textField1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JButton button1;

    public KursyAkcji() {
        obliczZyskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cena = 0;
                if (radioButton1.isSelected()) {
                    cena = 100;
                }
                if (radioButton2.isSelected()) {
                    cena = 110;
                }
                if (radioButton3.isSelected()) {
                    cena = 112;
                }
                if (radioButton4.isSelected()) {
                    cena = 130;
                }
                textField1.setText("Kupiłeś akcje typu:" + cena);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double dx = 
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kursy GUI");
        frame.setContentPane(new KursyAkcji().kk);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
