package zajecia_I_21;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    private Properties prop;
    private JFrame frejm;

    public static void main(String[] args) throws Exception {

        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("PlikiForm");
        frame.setContentPane(new PlikiForm(frame).panel); //przekazujemy frame do konstruktora
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //--------------------------
    }

    void czytajUstawienia() {
        try {
            prop = new Properties();
            FileInputStream in = new FileInputStream("nasze.properties");
            prop.load(in);
            String fontName = prop.getProperty("nazwaFontu");
            textArea1.setFont(new Font(fontName, 0, 16));
            System.out.println("ustawilem:" + fontName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void zapiszUstawienia() {
        try {
            prop = new Properties();
            Font czcionka = textArea1.getFont();
            prop.setProperty("nazwaFontu", czcionka.getFontName());
            prop.setProperty("wielkoscFontu", "" + czcionka.getSize());
            FileOutputStream out = new FileOutputStream("nasze.properties");
            prop.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Kontruktor całego GUI
    public PlikiForm(JFrame fff) {//przekazanie frame do konstruktora
        frejm = fff;// przypisanie przekazanego kontruktora do naszej zmiennej
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
                int nWyrazow = liczWyrazy(tekst);
                lblWyrazy.setText("Wyrazów:" + nWyrazow);
                lblZnaki.setText("Ilość znaków: " + tekst.length()); //wywietlamy ilość znakow
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String czcionka = (String) comboBox1.getSelectedItem();
                System.out.println(czcionka);
                textArea1.setFont(new Font(czcionka, Font.PLAIN, 16)); //Plain = zwykły
            }
        });
        czytajUstawienia();

        //wvent na zamknięcie okna
        frejm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //dodać "are you sure?"
                zapiszUstawienia();
                super.windowClosing(e);
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

    //Nasza funkcja; bierze tekst, liczy liczbe wyrazów którą też zwraca.
    private int liczWyrazy(String tekst) {
        if (tekst.isEmpty()) {
            return 0;
        }
        tekst = tekst.replace("\n", " ");
        String[] wyrazy = tekst.split(" ");
        return wyrazy.length;
    }


}

