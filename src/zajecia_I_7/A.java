package zajecia_I_7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created on 07.01.17, at 12:22
 */
public class A {
    private JButton sredniaButton;
    private JPanel panel;
    private JTextArea ta;
    private JTextArea ta2;
    public String oc = "4, 4.5, 3, 0, 5";



    public A() {
        ta2.setText(oc);
        sredniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] oceny = ta2.getText().split(",");
                System.out.println(Arrays.toString(oceny));
                double values=0;
                int counter = 0;
                double min=2, max = 5;
                int dlugosc = 0;
                for (int i = 0; i < oceny.length; i++) {
                    if (Double.valueOf(oceny[i]) != 0) {
                        dlugosc++;
                        values += Double.valueOf(oceny[i]);
                    } else {
                        counter++;
                    }
                }
                System.out.println(dlugosc);
                ta.setText(String.valueOf(values/dlugosc)+"\n min = "
                        +(values+min*counter)/oceny.length+"\n max = "+(values+max*counter)/oceny.length);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("A");
        frame.setContentPane(new A().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
