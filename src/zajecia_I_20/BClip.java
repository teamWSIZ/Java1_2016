package files;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pm on 1/21/17.
 */
public class BClip {
    private JTextField textField1;
    private JButton copyButton;
    private JPanel mp;

    public BClip() {
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            
                //To dziala (tresc jest w Clipboard) tylko dopuki GUI jest aktywne 

                StringSelection selection = new StringSelection("Deus vult");
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BClip");
        frame.setContentPane(new BClip().mp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
