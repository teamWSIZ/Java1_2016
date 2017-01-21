package zajecia_I_21;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by stasz_000 on 2017-01-21.
 */
public class PlikiForm {
    private JPanel panel;
    private JTextArea textArea1;
    private JButton wczytajButton;
    private JButton zapiszButton;

    public static void main(String[] args) throws Exception {
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("PlikiForm");
        frame.setContentPane(new PlikiForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public PlikiForm() {
        wczytajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Tekst", "txt")); // ustawienie jakiego formatu można wczytać pliki
                fileChooser.setAcceptAllFileFilterUsed(false); //wyłaczenie wyszukiwania wszystkich plików

                int rezultat = fileChooser.showOpenDialog(panel);
                if (rezultat == 0) {
                    File plik = fileChooser.getSelectedFile();
                    System.out.println(plik.getPath());
                    System.out.println(plik.getName());
                    String tekst = null;
                    try {
                        tekst = przeczytaj(plik);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    textArea1.setText(tekst);
                }
            }
        });


        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Tekst", "txt"));
                int rezultat = fileChooser.showSaveDialog(panel);
                if (rezultat == 0) {
                    //nacisnieto OK, a nie cancel --> zapisujemy
                    zapiszStringDoFile(textArea1.getText(), fileChooser.getSelectedFile());
                }
            }
        });
    }

    private String przeczytaj(File naszplik) throws IOException {
        Path lokalizajca = Paths.get(naszplik.getPath());
        List<String> wczytanyTekst = Files.readAllLines(lokalizajca, Charset.forName("UTF-8")); //UTF-8
        String temp = "";
        for (String s : wczytanyTekst) {
            temp += s + "\n";
        }
        return temp;
    }

    private void zapiszStringDoFile(String tekst, File fajl) {
        try {
            Files.write(fajl.toPath(), tekst.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

