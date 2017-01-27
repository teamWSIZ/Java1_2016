package zajecia_I_21;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * Created by stasz_000 on 2017-01-21.
 */
public class PlikiForm {
    private JPanel panel;
    private JTextArea textArea1;
    private JButton wczytajButton;
    private JButton zapiszButton;
    private JLabel lblWyrazy;
    private JLabel lblZnaki;
    private JComboBox comboBox1;

    public static void main(String[] args) throws Exception {
        Properties wczytane = new Properties();
        FileInputStream in = new FileInputStream("nasze.properties");
        wczytane.load(in);
        System.out.println(wczytane.getProperty("nazwaFontu"));
        System.out.println(wczytane.getProperty("wielkoscFontu"));
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("PlikiForm");
        frame.setContentPane(new PlikiForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //--------------------------
        Properties p = new Properties();
        p.setProperty("nazwaFontu", "Calibri");
        p.setProperty("wielkoscFontu", "16");
        FileOutputStream out = new FileOutputStream("nasze.properties");
        p.store(out,null);
    }

    public PlikiForm() {
        wczytajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser wyszukiwacz = new JFileChooser();
                wyszukiwacz.setFileSelectionMode(JFileChooser.FILES_ONLY);
                wyszukiwacz.setFileFilter(new FileNameExtensionFilter("Tekst", "txt")); // ustawienie jakiego formatu można wczytać pliki
                wyszukiwacz.setAcceptAllFileFilterUsed(false); //wyłaczenie wyszukiwania wszystkich plików

                int rezultat = wyszukiwacz.showOpenDialog(panel);
                if (rezultat == 0) {
                    File plik = wyszukiwacz.getSelectedFile();
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
        textArea1.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                //to się wywoła jak cokolwiek zrobimy na polu tekstowym
                String tekst = textArea1.getText();
                liczWyrazy(tekst);
                lblZnaki.setText("Ilość znaków: " + tekst.length()); //wywietlamy ilość znakow
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String czcionka = (String) comboBox1.getSelectedItem();
                System.out.println(czcionka);
                textArea1.setFont(new Font(czcionka,Font.PLAIN, 16)); //Plain = zwykły
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
            Path lokalizacja = Paths.get(fajl.getPath() + ".txt");
            Files.write(lokalizacja, tekst.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void liczWyrazy(String tekst) {
        if (tekst.isEmpty()) { //sprawdzamy czy tekst jest pusty
            lblWyrazy.setText("Ilość wyrazów: 0");
        } else {
            tekst = tekst.replace("\n", " ");
            String[] wyrazy = tekst.split(" ");
            lblWyrazy.setText("Ilość wyrazów: " + wyrazy.length);
        }
    }


}

