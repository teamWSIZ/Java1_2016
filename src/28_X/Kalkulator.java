import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Kalkulator {
    private JPanel jpmainp;
    private JSlider slider1;
    private JProgressBar progressBar1;
    private JButton button1;
    private JTextField textField1;
    private JLabel labelNapis;
    private JButton button2;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JButton button3;
    private JLabel LabelWynik;
    int innaNazwaInta = 0;


    public Kalkulator() {

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int wart = slider1.getValue();

                progressBar1.setValue(wart);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //innaNazwaInta = innaNazwaInta + 10;
                slider1.setValue(innaNazwaInta += 10);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naszNapis = textField1.getText();

                String przykładowaZmiennaString = "12332342.234234";
                //int liczby = Integer.valueOf(przykładowaZmiennaString);
                //double liczbyZmienno = Double.valueOf(przykładowaZmiennaString);
                labelNapis.setText(naszNapis);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double liczba1 = Double.valueOf(textField2.getText());
                double liczba2 = Double.valueOf(textField3.getText());

                String znak = String.valueOf(comboBox1.getSelectedItem());
                double wynik;

                if (znak.equals("+"))
                    wynik=liczba1+liczba2;
                else if(znak.equals("-"))
                    wynik=liczba1-liczba2;
                else if (znak.equals("*"))
                    wynik=liczba1*liczba2;
                else
                    wynik=liczba1/liczba2;

                LabelWynik.setText(String.valueOf(wynik));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Kalkulator().jpmainp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
