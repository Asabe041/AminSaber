

package ICS4_revision;
import javax.swing.JOptionPane;
import java.io.*;

public class SevensOut {
    static boolean debogue = true; //initiliase debogue
    public static int max=0,max2=0,pari1=0,pari2=0,parigagner;//initialiser les max, et pari a travers toute le program
    private static String nomUnstr, nomDeuxstr;//initialise les string pour les noms des joueurs
    
     public static void Debogue (String s) {//methode de debogue
   if (debogue ) 
      System.out.println(s);//imprime arguments envoyer par la methode qui l'appelle
     }
     
     public static void Joueur1Gagne(){//methode pour si le premier joueur gagne
         
   Debogue ("Dans Joueur1Gagne avec");//appelle la , methode de debogue
             JOptionPane.showMessageDialog(null, "Wooooo!! " + nomUnstr+ " a gagnés");//affiche que le premier joueurs a gagner      
             parigagner= pari1+pari2; //additionne les pari 
              Debogue("S- Parigagner = "+ parigagner);//apelle la methode de debogue
             JOptionPane.showMessageDialog(null, "Tu as gagner"+parigagner+ "$");//affiche combiens d'argent il a gagné 
             System.exit(0);//termine le jeu
     } 
     
     public static void Joueur2Gagne(){//methode pour si le deuxième joueur gagne
         
           Debogue ("Dans Joueur2Gagne avec");//appelle la , methode de debogue
             JOptionPane.showMessageDialog(null, "Wooooo!! " + nomDeuxstr+ " a gagnés");//affiche que le premier joueurs a gagner 
             parigagner= pari1+pari2;//additionne les pari 
             Debogue("S- Parigagner = "+ parigagner);//apelle la methode de debogue
             JOptionPane.showMessageDialog(null, "Tu as gagner"+parigagner+ "$");//affiche combiens d'argent il a gagné 
             System.exit(0);//termine le jeu 
     }
     
     public static void CommenceJeu2(int nombrePoint){
           Debogue ("Dans CommenceJeu2 avec "+ nombrePoint);
           int jouOuNon2,total2=0;
            JOptionPane.showMessageDialog(null, "C'est le tour de " + nomDeuxstr);//affiche que c'est le tour du deuxieme joueurs
             do{
             jouOuNon2 = JOptionPane.showConfirmDialog(null,nomDeuxstr + " veux tu rouler?" );//show.confirmdialog pour voir si le joueurs veux rouler ou non
             Debogue("A-  jouOuNon2="+ jouOuNon2);//debogue pour sa reponse
             if(jouOuNon2==2||jouOuNon2==-1)//si il annule ou click sur x dessus la fenetre sa le ferme
                 System.exit(0);
            
              if(jouOuNon2==1)//si il dit non sa vas au premier joueurs
               CommenceJeu1(nombrePoint);//appelle au methode du premier joueurs
              
                if(jouOuNon2==0){//si il dit oui sa continue le programme
                int d1=0, d2=0, double2 = 0;
 
                    d1 = (int)(Math.random() * (6 - 1) + 1);//choisie un nombre entre 1 et 6 
                    d2 = (int)(Math.random() * (6 - 1) + 1);//choisie un nombre entre 1 et 6 
                    Debogue("B-  d1="+d1+" d2= "+d2);//appelle debogue
                if (d1==d2) {//si les deux des roules on la même valeur
                       d1=d1*2;//double la valeurs des des
                       d1=d2*2;//double la valeurs des des
                         }
                Debogue("C-  d1="+d1+" d2= "+d2);
                if (d1+d2!=7){//si les deux des ne donne pas une valeurs de 7 
                
                total2=d1+d2;//additionne les deux des pour le total
                max2=max2+total2;//sauve la valeur des roules precedants
                JOptionPane.showMessageDialog(null, nomDeuxstr+" tu a recu "+total2+" ton total est " + max2); //affiche combien de points il a recu et il montre son total
                Debogue("D-  max2="+max2+" nombrePoint= "+nombrePoint);
                    if (max2 >= nombrePoint){//si son total est plus que le maximum points decide par les joueurs
                        total2=7;// termine methode pour dire au programme que le joueurs a gagné et l'envoye a methode Joueur2Gagne
                    }
                }
                else{//si le total est egale a 7 
                      JOptionPane.showMessageDialog(null, "Oh non "+ nomDeuxstr + " tu as un 7");//
                CommenceJeu1(nombrePoint);
                }
                }
                Debogue("Boucle A-  total2="+total2);
             }while(total2 != 7);//si le total est 7 sa termine le jeu
                Joueur2Gagne();
             }
     
     public static void CommenceJeu1 (int nombrePoint){
             int jouOuNon1, jouOuNon2,total1=0;
               Debogue ("Dans CommenceJeu1 avec " + nombrePoint);
          
            JOptionPane.showMessageDialog(null, "C'est le tour de " + nomUnstr);//affiche que c'est le tour du premier joueurs
             do{     
                 
            jouOuNon1 = JOptionPane.showConfirmDialog(null,nomUnstr + " veux tu rouler?" );//show.confirmdialog pour voir si le joueurs veux rouler ou non
            Debogue("F-  jouOuNon1="+ jouOuNon1);
            if(jouOuNon1==2||jouOuNon1==-1)//si il annule ou click sur x dessus la fenetre sa le ferme
                 System.exit(0);
           
            if(jouOuNon1==1)//si il dit non sa vas au premier joueurs
               CommenceJeu2 (nombrePoint);     
           
                         if(jouOuNon1==0){//si il dit oui sa continue le programme
                             int d1=0, d2=0, double1 = 0;
                             
                             d1 = (int)(Math.random() * (6 - 1) + 1);//choisie un nombre entre 1 et 6 
                             d2 = (int)(Math.random() * (6 - 1) + 1);//choisie un nombre entre 1 et 6 
                                Debogue("G-  d1="+d1+" d2= "+d2);
                             if (d1==d2) {//si les deux des roules on la même valeur
                                
                                 d1=d1*2;//double la valeurs des des   
                                 d2=d2*2;//double la valeurs des des
                             }
                             Debogue("H-  d1="+d1+" d2= "+d2);
                             if (d1+d2!=7){//si les deux des ne donne pas une valeurs de 7 
                                 
                                 total1=d1+d2;//additionne les deux des pour le total
                                 max=max+total1;//sauve la valeur des roules precedants
                                 
                                 JOptionPane.showMessageDialog(null, nomUnstr+" tu a recu "+total1+" ton total est " + max);//affiche combien de points il a recu et il montre son total
                                 
                                  Debogue("I-  d1="+d1+" d2= "+d2);
                                 if (max >= nombrePoint)//si son total est plus que le maximum points decide par les joueurs
                                     total1=7;// termine methode pour dire au programme que le joueurs a gagné et l'envoye a methode Joueur1Gagne
                                
                             }
                             Debogue("J-  d1="+d1+" d2= "+d2);
                             if(d1+d2==7){//si le total est egale a 7 
                                 JOptionPane.showMessageDialog(null, "Oh non "+ nomUnstr +" tu as un 7");
                                 CommenceJeu2(nombrePoint);
                             }
                         }    
                 
           Debogue("Boucle A- total1= "+total1);
             }while(total1 != 7);//si le total est 7 sa termine le jeu
                Joueur1Gagne();
           }
     
     public static void main( String args[] ){
     
         String nombrePointstr, montantStr1, montantStr2;   
         int nombrePoint=0, demandpari ,montant;
         Debogue("P- Demande pour nom");
         nomUnstr = JOptionPane.showInputDialog(null, "C'est quoi le nom du premier joueur?");//demande le nom du premier joueur
         nomDeuxstr = JOptionPane.showInputDialog(null, "C'est quoi le nom du deuxième joueur?");//demande le nom du deuxième joueur
         Debogue("Q- Demande pour nombre pour gagner");
         nombrePointstr = JOptionPane.showInputDialog(null, "C'est quoi le point maximal de points pour gagner?");//point maximal mis par l'usager
         
        nombrePoint = Integer.parseInt(nombrePointstr);
        Debogue("R- Demande pour pari");
        demandpari = JOptionPane.showConfirmDialog(null, "Voulez vous faire des pari?");//demande si il veulent faires des pari
       Debogue("K-  pari="+demandpari);
        if(demandpari == 0){//si il dit oui  
        montantStr1 =JOptionPane.showInputDialog(null, nomUnstr + " combien veut tu parir, il y a un max de 100");//demande combien il veulent mettre en pari
        pari1 = Integer.parseInt(montantStr1);
       Debogue("L- Montant du premier pari de " +nomUnstr+" " +montantStr1);
        while (pari1 > 100){// boucle si il mets un pari plus grand que 100
             montantStr1 = JOptionPane.showInputDialog(null, nomUnstr + " Tu ne peut pas faire un pari plus que 100");           
pari1 = Integer.parseInt(montantStr1);
Debogue("M- Montant du deuxième pari de " +nomUnstr +" " +montantStr1);
        }
        
        
        montantStr2 = JOptionPane.showInputDialog(null, nomDeuxstr + " combien veut tu parir, il y a un max de 100");//demande combien il veulent mettre en pari
        pari2 = Integer.parseInt(montantStr2);
        Debogue("N- Montant du premier pari de " + nomDeuxstr+" "  + montantStr2);
        while (pari2 > 100){// boucle si il mets un pari plus grand que 100
             montantStr2 = JOptionPane.showInputDialog(null, nomDeuxstr + " combien veut tu parir, il y a un max de 100?");
        pari2 = Integer.parseInt(montantStr2);
         Debogue("O- Montant du deuxième pari de " + nomDeuxstr +" " + montantStr2);
        }
        }
        
        CommenceJeu1(nombrePoint);
        
     } 
     
            

}
          