package Main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {

    private List<InfoEx> contactList = Main.contactList;
    private File fichier;
    PrintWriter sortie;
    int i = 0;
    JFrame frame = new JFrame();

    public static JButton ajoute = new JButton("Ajoute");
    public static JButton recherche = new JButton("Recherche");
    public static JButton supprime = new JButton("Supprime");
    public static JButton premier = new JButton("Premier");
    public static JButton precedent = new JButton("Précédent");
    public static JButton prochain = new JButton("Prochain");

    public JPanel section1 = new JPanel();
    public JPanel section2 = new JPanel();
    public JPanel section3 = new JPanel();
    public JPanel section4 = new JPanel();
    public JPanel section5 = new JPanel();

    public FlowLayout flowDeSection1 = new FlowLayout();
    public FlowLayout flowDeSection2 = new FlowLayout();
    public FlowLayout flowDeSection3 = new FlowLayout();
    public FlowLayout flowDeSection4 = new FlowLayout();
    public FlowLayout flowDeSection5 = new FlowLayout();

    public static JLabel affichePrenom = new JLabel(" ");
    public static JLabel afficheNumero = new JLabel(" ");
    public static JLabel afficheLocation = new JLabel(" ");
    ImageIcon icon = new ImageIcon (""+contactList.get(0).GetPhoto());
    public JLabel image           = new JLabel(icon);

    public static JTextField prenom = new JTextField("Prénom");
    public static JTextField numero = new JTextField("Numéro de téléphone");
    public static JTextField location = new JTextField("Location");
    public static JTextField prenomCherche = new JTextField("Prénom");
    
      private void Ordre() {
        if (!contactList.isEmpty()) {
            Collections.sort(contactList, new Comparator<InfoEx>() {
                public int compare(InfoEx nom1, InfoEx nom2) {
                    return (nom1.GetNom().toUpperCase()).compareTo(nom2.GetNom().toUpperCase());
                }
            });
        }
    }
      
    public void SetUp() {

        frame = new JFrame("Liste de contact");
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout leGrid = new GridLayout(5, 1);
        frame.setLayout(leGrid);

        section1.setLayout(flowDeSection1);
        section1.add(prenom);
        section1.add(numero);
        section1.add(location);
        section1.add(ajoute);
        frame.add(section1);

        section2.setLayout(flowDeSection2);
        section2.add(prenomCherche);
        section2.add(recherche);
        section2.add(supprime);
        frame.add(section2);

        section3.setLayout(flowDeSection3);
        section3.add(premier);
        section3.add(precedent);
        section3.add(prochain);
        frame.add(section3);

        section4.setLayout(flowDeSection4);
        section4.add(affichePrenom);
        section4.add(afficheNumero);
        section4.add(afficheLocation);
        section4.add(image);
        frame.add(section4);
        section5.setLayout(flowDeSection5);

        prenom.setPreferredSize(new Dimension(125, 25));
        numero.setPreferredSize(new Dimension(125, 25));
        location.setPreferredSize(new Dimension(125, 25));
        prenomCherche.setPreferredSize(new Dimension(125, 25)); 
        
        affichePrenom.setText(contactList.get(0).GetNom());
        afficheNumero.setText(contactList.get(0).GetNumero());
        afficheLocation.setText(contactList.get(0).GetLocation());
        
        
        frame.add(section5);
       
        
        ajoute.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent u) {

                InfoEx contact = new InfoEx();

                String ajouteNom = prenom.getText();
                String ajouteNumero = numero.getText();
                String ajouteLocation = location.getText();

                contact.SetNom(ajouteNom);
                contact.SetNumero(ajouteNumero);
                contact.SetLocation(ajouteLocation);

                prenom.setText("Prénom");
                numero.setText("Numéro de téléphone");
                location.setText("Location");
                contactList.add(contact);
                Ordre();
              
            }
        }
        );

        recherche.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent u) {

                for (int i = 0; i < contactList.size(); i++) {
                    System.out.println("i=" + i + "   info=" + contactList.get(i).ToString());
                }
                String nom;

                boolean check = true;

                String ajouteNom = prenomCherche.getText();

                for (int i = 0; i < contactList.size(); i++) {

                    if (ajouteNom.equals(contactList.get(i).GetNom())) {

                        String nom2 =       contactList.get(i).GetNom();
                        String location = contactList.get(i).GetLocation();
                        String numero = contactList.get(i).GetNumero();
                        System.out.println(nom2 + " " + location + " " + numero);
                        affichePrenom.setText(nom2);
                        afficheNumero.setText(numero);
                        afficheLocation.setText(location);
                        ImageIcon icon = new ImageIcon(""+contactList.get(i).GetPhoto());
                        image.setIcon(icon);
                        check = true;
                        Ordre();
                        break;
                    } else {
                        check = false;
                    }

                }
                if (check == false) {
                    JOptionPane.showMessageDialog(null, "Mauvais nom");

                }
            }

        }
        );

        supprime.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent u) {
               
                boolean check = true;
                String ajouteNom = prenomCherche.getText();
                for (int i = 0; i < contactList.size(); i++) {
                    if (ajouteNom.equals(contactList.get(i).GetNom())) {
                        System.out.println("num elt= " + i +" " + contactList.get(i).ToString() + " ceci est supprimer");
                        contactList.remove(i);
                        check = true;
                        affichePrenom.setText(contactList.get(0).GetNom());
                        afficheNumero.setText(contactList.get(0).GetNumero());
                        afficheLocation.setText(contactList.get(0).GetLocation());
                        Ordre();
                        break;
                    } else {
                        check = false;
                    }

                }
                if (check == false) {
                    JOptionPane.showMessageDialog(null, "Mauvais nom");
                }

            }
        }
        );

        

        premier.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nom, location, numero;
                nom = contactList.get(0).GetNom();
                location = contactList.get(0).GetLocation();
                numero = contactList.get(0).GetNumero();
                affichePrenom.setText(nom);
                afficheNumero.setText(numero);
                afficheLocation.setText(location);
                 ImageIcon icon = new ImageIcon(""+contactList.get(0).GetPhoto());
                        image.setIcon(icon);
            }
        }
        );
        prochain.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                i++;
                if (i >= contactList.size()) {
                    i = 0;
                }
                String nom = contactList.get(i).GetNom();
                String location = contactList.get(i).GetLocation();
                String numero = contactList.get(i).GetNumero();
                affichePrenom.setText(nom);
                afficheNumero.setText(numero);
                afficheLocation.setText(location);
                 ImageIcon icon = new ImageIcon(""+contactList.get(i).GetPhoto());
                        image.setIcon(icon);

            }

        });
        precedent.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (i <= 0) {
                    i = contactList.size();
                }
                i--;
                String nom = contactList.get(i).GetNom();
                String location = contactList.get(i).GetLocation();
                String numero = contactList.get(i).GetNumero();
                affichePrenom.setText(nom);
                afficheNumero.setText(numero);
                afficheLocation.setText(location);
                 ImageIcon icon = new ImageIcon(""+contactList.get(i).GetPhoto());
                        image.setIcon(icon);

            }
        });
frame.setVisible(true);
    }

    public GUI() throws IOException {
        Ordre();
        SetUp();
    }
}
