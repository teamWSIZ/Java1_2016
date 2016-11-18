package zajecia_18XI;

import javax.swing.*;

/**
 * Created on 18.11.16, at 18:13
 */
public class OknoGui {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JPanel mp;

    public static void main(String[] args) {
        JFrame frame = new JFrame("OknoGui");
        frame.setContentPane(new OknoGui().mp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
