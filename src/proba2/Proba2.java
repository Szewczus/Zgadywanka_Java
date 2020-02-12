/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proba2;

import static com.sun.tools.attach.VirtualMachine.list;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.util.*;
public class Proba2 extends JFrame {

    JLabel wyraz = new JLabel("Wyraz");
    JTextField tab_wyraz[] = new JTextField[10];
    JLabel proby = new JLabel("Próby");
    JTextField tab_proby[] = new JTextField[10];
    int k = 0;
    int licz = 0;
    int i=0;
    
    
    ArrayList<String> tab_edytor=new ArrayList<>();
    
    
    public Proba2() throws HeadlessException {
        String tab_znakow[] = {"ewa", "ola", "ania", "baltek"};

        JPanel panel_na_wszystko = new JPanel();

        panel_na_wszystko.setLayout(new BorderLayout());
        JPanel panel_na_wyraz = new JPanel();
        SpringLayout s1 = new SpringLayout();
        panel_na_wyraz.add(wyraz);
        int j;
        System.out.println("podaj liczbe od 0 do 3");
        Scanner a = new Scanner(System.in);
        j = a.nextInt();
        for (int i = 0; i < tab_znakow[j].length(); i++) {
            tab_wyraz[i] = new JTextField(3);

            tab_wyraz[i].setText("?");
            panel_na_wyraz.add(tab_wyraz[i]);
            s1.putConstraint(SpringLayout.WEST, tab_wyraz[i], 10, SpringLayout.WEST, panel_na_wyraz);
            s1.putConstraint(SpringLayout.NORTH, tab_wyraz[i], 10, SpringLayout.SOUTH, wyraz);

        }
        for (int i = 0; i < tab_znakow[j].length() - 1; i++) {

            s1.putConstraint(SpringLayout.WEST, tab_wyraz[i], 0, SpringLayout.EAST, tab_wyraz[i + 1]);

        }

        panel_na_wyraz.setLayout(s1);
        s1.putConstraint(SpringLayout.WEST, wyraz, 10, SpringLayout.WEST, panel_na_wyraz);
        s1.putConstraint(SpringLayout.NORTH, wyraz, 10, SpringLayout.NORTH, panel_na_wyraz);
        add(panel_na_wyraz);
        //----------------------------------------------------------------------

        panel_na_wyraz.add(proby);
        s1.putConstraint(SpringLayout.WEST, proby, 10, SpringLayout.WEST, panel_na_wyraz);
        s1.putConstraint(SpringLayout.NORTH, proby, 20, SpringLayout.SOUTH, tab_wyraz[1]);

        for (int i = 0; i < 10; i++) {
            tab_proby[i] = new JTextField(3);
            panel_na_wyraz.add(tab_proby[i]);
            s1.putConstraint(SpringLayout.WEST, tab_proby[i], 10, SpringLayout.WEST, panel_na_wyraz);

            s1.putConstraint(SpringLayout.NORTH, tab_proby[i], 20, SpringLayout.NORTH, proby);
        }
        for (int i = 0; i < 9; i++) {

            s1.putConstraint(SpringLayout.WEST, tab_proby[i], 0, SpringLayout.EAST, tab_proby[i + 1]);

        }

        JLabel znaki = new JLabel("Wybrane znaki");
        JEditorPane edytor = new JEditorPane();
        s1.putConstraint(SpringLayout.WEST, znaki, 500, SpringLayout.WEST, panel_na_wyraz);
        s1.putConstraint(SpringLayout.NORTH, znaki, 10, SpringLayout.NORTH, panel_na_wyraz);

        s1.putConstraint(SpringLayout.WEST, edytor, 500, SpringLayout.WEST, panel_na_wyraz);
        s1.putConstraint(SpringLayout.NORTH, edytor, 20, SpringLayout.SOUTH, znaki);
        panel_na_wyraz.add(znaki);
        panel_na_wyraz.add(edytor);
        edytor.setPreferredSize(new Dimension(200, 80));

        JLabel napis = new JLabel("");
        panel_na_wyraz.add(napis);
        s1.putConstraint(SpringLayout.WEST, napis, 10, SpringLayout.WEST, panel_na_wyraz);
        s1.putConstraint(SpringLayout.NORTH, napis, 20, SpringLayout.SOUTH, tab_proby[0]);

        JButton Nowa_gra = new JButton("Nowa gra");
        panel_na_wyraz.add(Nowa_gra);
        s1.putConstraint(SpringLayout.WEST, Nowa_gra, 100, SpringLayout.EAST, napis);
        s1.putConstraint(SpringLayout.NORTH, Nowa_gra, 20, SpringLayout.SOUTH, tab_proby[0]);

        JLabel znak = new JLabel("Nowy znak");
        panel_na_wyraz.add(znak);
        s1.putConstraint(SpringLayout.WEST, znak, 10, SpringLayout.EAST, Nowa_gra);
        s1.putConstraint(SpringLayout.NORTH, znak, 20, SpringLayout.SOUTH, tab_proby[0]);

        JTextField znak_tekst = new JTextField(5);
        panel_na_wyraz.add(znak_tekst);
        s1.putConstraint(SpringLayout.WEST, znak_tekst, 10, SpringLayout.EAST, znak);
        s1.putConstraint(SpringLayout.NORTH, znak_tekst, 20, SpringLayout.SOUTH, tab_proby[0]);

        JButton Sprawdz = new JButton("Sprawdz");
        panel_na_wyraz.add(Sprawdz);
        s1.putConstraint(SpringLayout.WEST, Sprawdz, 10, SpringLayout.EAST, znak_tekst);
        s1.putConstraint(SpringLayout.NORTH, Sprawdz, 20, SpringLayout.SOUTH, tab_proby[0]);

        //----------------------------------------------------------
        //Akcja punkt a
        Nowa_gra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                napis.setText("");
                for (int i = 0; i < tab_znakow[j].length(); i++) {
                    tab_wyraz[i] = new JTextField(3);
                    panel_na_wyraz.add(tab_wyraz[i]);
                    s1.putConstraint(SpringLayout.WEST, tab_wyraz[i], 10, SpringLayout.WEST, panel_na_wyraz);
                    s1.putConstraint(SpringLayout.NORTH, tab_wyraz[i], 10, SpringLayout.SOUTH, wyraz);

                }
                
                for (int i = 0; i < 10; i++) {
                    tab_proby[i].setBackground(Color.WHITE);
                }
                
                edytor.setText(" ");
            }
        });
        
        
        
        Sprawdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                char literka = znak_tekst.getText().charAt(0);
                
                int czy=0;
                
                if(tab_edytor.isEmpty())
                {
                    tab_edytor.add(String.valueOf(literka));
                }
                else
                {
                    for(String index: tab_edytor)
                    {
                        System.out.println(index);
                        if(index.equals(String.valueOf(literka)))
                        {
                            JOptionPane.showMessageDialog(rootPane, "powtórka");
                            czy++;
                            
                        }
                    }
                    if(czy==0){
                        tab_edytor.add(String.valueOf(literka));
                    }
                    
                }
                String Wczesniejsze;
                Wczesniejsze=edytor.getText();
                for(String index: tab_edytor)
                {
                    
                    edytor.setText(Wczesniejsze+index+ ", ");
                }
                
                
                
                
                char literka_z_hasla;
                //tab_edytor.add(String.valueOf(literka));
                int dl_hasla = tab_znakow[j].length();
                String ciag_znakow="";
                for (int i = 0; i < dl_hasla; i++) {

                    literka_z_hasla = tab_znakow[j].charAt(i);

                    System.out.println("-------");
                    //spr czy taka literka jest w haśle 
                    if (literka == literka_z_hasla) {
                        tab_wyraz[dl_hasla - 1 - i].setText(String.valueOf(literka));
                    }
                    //tworze ciag zaków z tablicy wyrazów
                    ciag_znakow+=tab_wyraz[dl_hasla - 1 - i].getText();
                    
                }
                
                
                
                //porównuje ciag znaków z hasłem
                if(ciag_znakow.equals(tab_znakow[j])){
                napis.setText("Wygrałeś");
                }
                int licznik = 0;
                //przejrzyj tablice haseł i zobacz czy tak jest taka literka
                
                for (int i = 0; i < dl_hasla; i++) {
                    //jezeli jest to licznik zmien na 1
                    if (literka == tab_znakow[j].charAt(i)) {
                        licznik = 1;
                    }
                }
                //jeżeli licznik=0 to okinko próby zmien na czerwony
                if (licznik == 0) {

                    tab_proby[k++].setBackground(Color.red);
                }
                
                //jezeli 10 okienko prób jest zamlowne to pisz przegrałes
                if (tab_proby[8].getBackground() == Color.RED) {
                    napis.setText("Przegrales");
                }
            }
        }
        );

        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel_na_wyraz);
        setVisible(true);

    }

    public static void main(String[] args) {
        Proba2 p = new Proba2();
    }

}
