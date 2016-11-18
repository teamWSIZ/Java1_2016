package zajecia_28X;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno {
    private JPanel mainPane;
    private JTextField txt1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JComboBox comboBox1;
    private JProgressBar progressBar1;
    private JSlider slider1;
    private JButton button3;

    public Okno() {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText("tekst");

            }
        });

        checkBox2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (checkBox2.isSelected()) //sprawdzenie czy checkbox jest zaznaczony
                    textField3.setText("Zaznaczono");
                else
                    textField3.setText("Odznaczono");
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider1.getValue(); //pobranie wartości z slidera (suwaka)
                progressBar1.setValue(value); //ustawienie wartość dla progress bar'a
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField2.getText(); //pobranie tekstu z pola o nazwie textField2
                txt1.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Okno");
        frame.setContentPane(new Okno().mainPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
