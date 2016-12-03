import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 03.12.16, at 12:38
 */

//Operacja bankowa
class Operacja {
    String data;
    String typ;
    String details;
    Double kwota;

    @Override
    public String toString() {
        return "[data:" + data + ", typ:" + typ + ", details:" + details + ", kwota:" + kwota + "]";
    }
}

//Silnik do zamiany wydruku z banku na listę operacji bankowych
class BankParser {
    public static List<Operacja> parseInput(String input) {
        List<Operacja> result = new ArrayList<>();
        String[] lines = input.split("\n");
        int at = 0;
        while(at != lines.length) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date dateStr = formatter.parse(lines[at]);
            } catch (ParseException e) {
                at++;
                continue;
            }
            Operacja op = new Operacja();
            op.data = lines[at];
            op.typ = lines[at + 2];
            op.details = lines[at + 4];
            op.kwota = Double.parseDouble(lines[at + 6].replace(",", "."));
            result.add(op);
            at++;
        }
        return result;
    }
}

//przykład wykorzystania
public class KontoGUI {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;
    private JPanel ff;

    public KontoGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = textArea1.getText();
                List<Operacja> operacjas = BankParser.parseInput(tekst);
                for(Operacja o  : operacjas) {
                    textArea2.append(o.toString() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KontoGUI");
        frame.setContentPane(new KontoGUI().ff);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
