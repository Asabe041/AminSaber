/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ICS4_revision;
import javax.swing.JOptionPane;
import java.io.*;

        public class SevensOutAvecUneMethod {
        static boolean debogue = true; //initiliase debogue
        public static int tour=1,nombrePoint=0,pari;//initialiser les max, et pari a travers toute le program
        private static String nomUnstr, nomDeuxstr;//initialise les string pour les noms des joueurs
    
        public static void Debogue (String s) {//methode de debogue
        if (debogue) 
        System.out.println(s);//imprime arguments envoyer par la methode qui l'appelle
        }
        public static void Gagner (String gagnant){
             JOptionPane.showMessageDialog(null, "Wooooo!! " + gagnant + " a gagnés");//affiche que le premier joueurs a gagner      
             JOptionPane.showMessageDialog(null,"Tu as gagner "+pari+"$");
             System.exit(0);//termine le jeu
            
        }
    
     
        public static int jouJeux (String nom,int total,int max){
            int jouOuNon = 0,d1=0,d2=0,fTotal=0;
             

             jouOuNon = JOptionPane.showConfirmDialog(null, nom + " veux tu rouler?" );//show.confirmdialog pour voir si le joueurs veux rouler ou non
             
             if(jouOuNon==2||jouOuNon==-1)//si il annule ou click sur x dessus la fenetre sa le ferme
                 System.exit(0);
            
              if(jouOuNon==1){//si il dit non sa vas au premier joueurs
               tour=2; 
               CommenceJeu();
              }
                if(jouOuNon==0){//si il dit oui sa continue le programme
                    Debogue("Valeur de jouOunon "+jouOuNon);
                    d1=(RouleD());
                    Debogue("valeur de d1 " + d1);
                    d2=(RouleD());
                    Debogue("valeur de d2 " + d2);
                    Debogue("valeur de d1 + d2 " + d1+d2);
                    if (d1==d2) {//si les deux des roules on la même valeur
                    d1=d1*2;//double la valeurs des des
                    d2=d2*2;//double la valeurs des des
                            }
               
                    if (d1+d2!=7){//si les deux des ne donne pas une valeurs de 7 
                
                total=d1+d2;//additionne les deux des pour le total
                max=max+total;//sauve la valeur des roules precedants
                JOptionPane.showMessageDialog(null, nom+ " tu a recu " + total + " ton total est " + max); //affiche combien de points il a recu et il montre son total
                    if (max >= nombrePoint){//si son total est plus que le maximum points decide par les joueurs
                        Gagner(nom);
                    }
                }
                else{//si le total est egale a 7 
                      JOptionPane.showMessageDialog(null, "Oh non " + nom + " tu as un 7");//
                      fTotal=7;
                    
                }
                }
                Debogue(nom + " valeur de total " + total);
          return max;
        }
        public static void CommenceJeu (){
            int de1,de2,total1=0,total2=0,max1=0,max2=0;
         do{
         if (tour==1){
             JOptionPane.showMessageDialog(null, "tour de " + nomUnstr);
             max1 = jouJeux(nomUnstr,total1,max1);
             tour=2;
         }
         if (tour==2){
             JOptionPane.showMessageDialog(null, "tour de " + nomDeuxstr);
             max2 =  jouJeux(nomDeuxstr,total2,max2);
             tour=1;
         }
             }while(max1 != 7||max2 != 7);//si le total est 7 sa termine le jeu
         }
        public static void Pari(){
            String pariStr;
            pariStr = JOptionPane.showInputDialog(null, "Combien voulez vous mettre en pari");
            pari=Integer.parseInt(pariStr);
            pari=pari*2;
        }
           
        
        public static int RouleD(){
           return ((int) (Math.random() * 6 + 1));
           
        }
        public static void main( String args[] ){
     
        String nombrePointstr, montantStr1, montantStr2;   
        int demandpari ,montant;
        Debogue("P- Demande pour nom");
        
        nomUnstr = JOptionPane.showInputDialog(null, "C'est quoi le nom du premier joueur?");//demande le nom du premier joueur
        nomDeuxstr = JOptionPane.showInputDialog(null, "C'est quoi le nom du deuxième joueur?");//demande le nom du deuxième joueur
        
        nombrePointstr = JOptionPane.showInputDialog(null, "C'est quoi le point maximal de points pour gagner?");//point maximal mis par l'usager
        nombrePoint= Integer.parseInt(nombrePointstr);
         Pari();
         CommenceJeu();
         
        }
        }
     
        
       
