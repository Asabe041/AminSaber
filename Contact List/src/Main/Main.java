package Main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
    
       public static List<InfoEx> contactList = new ArrayList();
     public Main()throws IOException {
         
        Scanner scan = Lire();
        CollecteDonnes(scan);
        GUI gui = new GUI();
    }
    
     public static File FileChooser(File fichier) throws IOException {
        int x;
        do {
            try {
                JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
                int valeurRetour = fileChooser.showOpenDialog(null);

                if (valeurRetour == 0) {
                    fichier = fileChooser.getSelectedFile();

                    if (!fichier.isFile()) {
                        System.out.println("Pas un fichier ca");
                        throw new FileNotFoundException("pas fichier");
                    }
                } else {
                    throw new FileNotFoundException("Problème avec FC");
                }
                x = 1;
            } catch (FileNotFoundException ex) {
                System.out.println("DO noice onefas");
                x = 0;
            }
        } while (x == 0);
        return fichier;
    }

    public static Scanner Lire() throws IOException {
        File fichier = null;
        fichier = FileChooser(fichier);
        Scanner scan = new Scanner(fichier);
        return scan;
    }

     public static void CollecteDonnes(Scanner scan) throws IOException {
        
    
            while (scan.hasNext()) {
                InfoEx contact = new InfoEx();
                String nom = scan.next();
                String numero = scan.next();
                String location = scan.next();
                String nomPhoto = scan.next();
                contact.SetNom(nom);
                contact.SetNumero(numero);
                contact.SetLocation(location);
                contact.SetPhoto(nomPhoto);
                contactList.add(contact);
            }
        }
 
   public static void main(String[] args) throws IOException {
        new Main();
    }
   
}
