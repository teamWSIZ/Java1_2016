package kalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 04.11.16, at 18:14
 */
public class CalcGUI {
    private JPanel mp;
    private JTextArea textArea1;
    private JButton button1;
    private JButton liczButton;
    private JButton button3;
    private JTextField a0TextField;
    private JTextField a0TextField1;
    private JProgressBar progressBar1;

    public CalcGUI() {
        liczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputJeden = a0TextField.getText();
                String wDrugim = a0TextField1.getText();

                int a = Integer.valueOf(inputJeden);
                int b = Integer.valueOf(wDrugim);

                System.out.println("Licze [" + inputJeden + "]");
                textArea1.append("\n"+"Wynik=" + (a * b));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CalcGUI");
        frame.setContentPane(new CalcGUI().mp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
