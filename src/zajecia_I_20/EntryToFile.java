package zajecia_I_20;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by stasz_000 on 2017-01-20.
 */
public class EntryToFile {
    private JPanel panel;
    private JButton button1;
    private JTextArea textArea1;
    private JButton zapiszButton;

    public EntryToFile() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fChooser = new JFileChooser();
                fChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int resultWindo = fChooser.showDialog(panel, "abra kadabra");

                if (resultWindo == 0) {
                    File naszPlik = fChooser.getSelectedFile();
                    System.out.println(naszPlik.getPath());

                    try {
                        String text = przeczytajPlk(naszPlik.getPath());
                        textArea1.setText(text);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }

            }
        });

        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchZapisz = new JFileChooser();
                fchZapisz.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int result = fchZapisz.showSaveDialog(panel);
                if (result == 0) {
                    File plik = fchZapisz.getSelectedFile();
                    System.out.println(plik.getPath());

                    zapiszPlik(plik.getPath());
                }
            }
        });
    }

    private String przeczytajPlk(String sciezka) throws IOException {
        //zmieniamy sciezke która jest typem String na lokalizacje (path)
        Path lokalizacja = Paths.get(sciezka);

        //czytam cały plik tekstowy
        List<String> TextPliku = Files.readAllLines(lokalizacja);
        String naszTekst = "";

        for (String s : TextPliku) {
            naszTekst += s + "\n";
        }
        return naszTekst;
    }

    private void zapiszPlik(String sciezka) {
        try {
            Path lokalizacja = Paths.get(sciezka);
            Files.write(lokalizacja, textArea1.getText().getBytes());
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) throws Exception {
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("EntryToFile");
        frame.setContentPane(new EntryToFile().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}


//    JFileChooser chooser = new JFileChooser();
//    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//     int returnVal = chooser.showOpenDialog(contentPane);
//
//     if (returnVal == JFileChooser.APPROVE_OPTION) {
//     //        buttonOK.setEnabled(true);
//        jLabFileName.setText(chooser.getSelectedFile().getName());
//        file = new cFile(chooser.getSelectedFile().getName(), chooser.getSelectedFile().getAbsolutePath(), chooser.getSelectedFile().length());
//        } else
//        JOptionPane.showMessageDialog(contentPane, "Plik jest za duży max 500 MB", "Plik", JOptionPane.INFORMATION_MESSAGE);
//        }

