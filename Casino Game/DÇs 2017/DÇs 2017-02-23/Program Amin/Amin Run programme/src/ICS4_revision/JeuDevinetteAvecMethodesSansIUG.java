//**********************************************************
// Nom: Richard A. Paquette
// Date: 
// Description: 
//**********************************************************
// Packages d'extension Java.
package ICS4_revision;
import javax.swing.JOptionPane;
import java.io.*;

public class JeuDevinetteAvecMethodesSansIUG {
   static Console c;             // pour une fa?on alternative de faire du I/O
   static boolean debug;                       // activer le debugging
   static int malDeviner = 0;    // compteur du nombre de fois mal deviner la r�ponse
  
   /*  Explication: permet de faire du debugging dans ton pgm
    *  param?tres: String pour ?tre afficher sur la console
    *  val. retour: aucune
    */
   public static void Debogue (String uneStr) {
      
      if (debug)
          System.out.println(uneStr);
   } //fin Debogue
   
   /*  Explication: Demande � l'usager pour un num�ro. Pourrais faire du checking
    *  param?tres: aucun
    *  val. retour: un entier, le num�ro obtenu de l'usager
    */   
   public static int DemandePourNumero () {
      String uneStr;
      int unInt;
      // demande et converti la string en num�ro entier
      uneStr = JOptionPane.showInputDialog ("Devine un num\u00E9ro");
      unInt = Integer.parseInt(uneStr);
      return unInt;
   } //fin DemandePourNumero
   
   /*  Explication: trouve un num�ro de fa?on al�atoire, entre 1 et 20
    *  param?tres: auncun
    *  val. retour: un entier, la valeur al�atoire
    */
   public static int NombreADeviner() {
      int unInt=0;
      // utilise random(), et ensuite ajuste le range entre 1 et 20
      unInt = (int)(Math.random()*20+1);
      return (unInt);
   } // fin NombreADeviner
   
   /*  Explication: Affiche un de deux messages (trop haut ou trop bas)
    *  param?tres: int, l'identifiant pour la String � afficher
    *  val. retour: aucun
    */
   public static void AfficheMessage (int lequel) {
      String uneStr="";
      Debogue("Dans AfficheMessage avec valeur:"+lequel);
      // change la String d'affichage d�pendent de la valeur num�rique
      switch (lequel) {
         case 1: 
            uneStr = "Tu es trop bas";
            break;
         case 2:
            uneStr = "Tu es trop haut";
            break;
         default:
            uneStr = "Il y a une erreur avec la string � afficher";
      } // fin switch
      
      // affiche le tout
      JOptionPane.showMessageDialog (null, 
                         uneStr,
                         "Oops",
                         JOptionPane.QUESTION_MESSAGE);
   } // fin AfficheMessage
   
   /*  Explication: C'est le jeu m?me. Suit les r�glements du jeu
    *  param?tres: un entier, le nombre qui doit ?tre deviner
    *  val. retour: boolean, Si bien deviner, le retour est TRUE, 
    *               autrement il est FALSE
    */
   public static boolean LeJeu (int leNumADeviner) {
      // le num�ro qu'entre l'usager
      int devinette = 0;    
      // indication que le num�ro fut bien deviner ou non
      boolean fini = false;
      
      // accepte valeur de utilisateur
      devinette = DemandePourNumero();

      // est-ce le bon num�ro?
      // si c'est le bon - on sort de la boucle
      // si c'est tros haut ou trop bas - affiche msg
      Debogue("A- devinette="+devinette+
              "   et nombre="+leNumADeviner);
      if (devinette == leNumADeviner){
         fini = true;
      } else {
         malDeviner++;
         Debogue("B- devinette="+devinette+
                 "   et nombre="+leNumADeviner+
                 "   et malDevier="+malDeviner);
         if (devinette < leNumADeviner){
            AfficheMessage(1);
         } else {
           AfficheMessage(2);
         }
      }
   return fini;
   }
   
   public static void main( String args[] )
   {  
      // le nombre qui sera � deviner      
      int nombreAleatoire = 0;
      // deux valeurs sentinelle qui controlent les boucles
      boolean finiBoucleInterne = false;
      int choix = 0;

      // boucle externe - pour jouer encore
      do {
         // le code suivant te donne un nombre aléatoire (random) entre 1 et 20
         // sers-toi de la valeur dans "pourDeviner" comme le numéro que tu
         // dois trouver dans ton jeu de devinette
         nombreAleatoire = NombreADeviner();
         
         // remettre � z�ro pour chaque passe
         malDeviner = 0;
         finiBoucleInterne = false;
     
         Debogue ("La valeur choisi: "+nombreAleatoire);
         // tant que tu n'as pas devin�, continue � boucler
         do{
            finiBoucleInterne = LeJeu(nombreAleatoire);
            Debogue("Fin while avec fini="+finiBoucleInterne);
         } while (!finiBoucleInterne);
      
         // montre message finale
         JOptionPane.showConfirmDialog (null,
              "Tu as deviner "+nombreAleatoire+
              " en essayant "+(malDeviner+1)+" fois",
              "F\u00e9licitations",
              JOptionPane.ERROR_MESSAGE);
         
         // demande si veut refaire le jeu
         choix = JOptionPane.showConfirmDialog (null, 
            "Voulez-vous jouer encore?", 
            "Je jeux de devinette", 
            JOptionPane.YES_NO_OPTION);
      
      } while (choix == 0);
   }  // fin m�thode main
} // fin pgm