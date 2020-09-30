/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ICS4_revision;

import static ICS4_revision.SevensOutAvecUneMethod.Debogue;
import static ICS4_revision.SevensOutAvecUneMethod.RouleD;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author CECCE
 */
public class IUGSevensOut implements ActionListener {

    public JFrame frame;
    public int soustotal = 0, total = 0, montantPointTotal_Joueur1 = 0, montantPointTotal_Joueur2 = 0, montantdePointsPourGagner = 0, l = 1, pari_Joueur1 = 0, pari_Joueur2 = 0, total_Joueur1 = 100, total_Joueur2 = 100, o = 1;
    public String pointStr, totalstr, totalstr1, nom1, nom2;
    JLabel pointRecu1 = new JLabel("0");
    JLabel pointRecu3 = new JLabel("0");
    JLabel gagnant = new JLabel();
    JLabel pointPourGagnerNonValid = new JLabel("Un nombre entre 0 et 100");
    JLabel recu7 = new JLabel();
    JLabel pariInvalid = new JLabel("Ton pari n'est pas valide");
    JButton button_Joueur1 = new JButton("Roule");
    JButton button_Joueur2 = new JButton("Roule");
    JButton continuer = new JButton("continuer");
    JButton recommencer = new JButton("recommencer");
    JLabel[] jLabelArray = new JLabel[]{new JLabel("Ton total est "), new JLabel("0"), new JLabel("Ton total est "), new JLabel("0"), new JLabel("" + total_Joueur1), new JLabel("" + total_Joueur2)};
    JTextField[] textFieldArray = new JTextField[]{new JTextField("Nom", 7), new JTextField("Nom", 7), new JTextField(3), new JTextField(3), new JTextField(3)};
    JLabel[] pointRecuArray = new JLabel[]{new JLabel("Tu as recu "), new JLabel("0"), new JLabel("Tu as recu "), new JLabel("0")};

    public static void main(String args[]) {
        new IUGSevensOut();
    }

    public void Perdu(String nom) {
        Debogue("Dans perdu");
        JOptionPane.showMessageDialog(null, nom + " ,tu as perdue");
        frame.dispose();
    }

    public void ReponseNonValid() {
        pointPourGagnerNonValid.setVisible(true);
    }

    public int ButtonFrapper(int totalpoint, int k, String nom, int pari, int l, int totalargent) {
        String totalargentstr;
        RouleDe();
        recu7.setVisible(false);
        //si il recoit 7 il perd tous ses points
        Debogue("total = " + total);
        if (total == 7) {
            recu7.setText(nom + " tu as rouler un 7");
            recu7.setVisible(true);
            total = 0;
            totalpoint = 0;
        }

        totalpoint = total + totalpoint;
        pointStr = Integer.toString(total);
        //montre ces points recu
        pointRecuArray[k].setText(pointStr);
        totalstr = Integer.toString(totalpoint);
        //montre son points total
        jLabelArray[k].setText(totalstr);
        /*si son point total est plus que le montant de points pour gagner, sa soustrait le pari du perdant, sa donne *2(de son pari)
        au gagnant, si un des joueurs a 0$ il perd, sa donne le choix de recommencer ou continuer.
         */
        Debogue("total points = " + totalpoint + " montant de points pour gagner = " + montantdePointsPourGagner);
        if (totalpoint >= montantdePointsPourGagner) {
            Debogue("total de joueur 1= " + total_Joueur1 + " total de joueur 2= " + total_Joueur2);
            if (total_Joueur1 == 0 || total_Joueur2 == 0) {
                Perdu(nom);
            }
            Debogue("" + total_Joueur1);

            Debogue("montant de point total joueur 2 = " + montantPointTotal_Joueur2 + " montant de point total joueur 1 = " + montantPointTotal_Joueur1);
            if (montantPointTotal_Joueur2 > montantPointTotal_Joueur1) {
                String total1str;
                total_Joueur1 = total_Joueur1 - (pari_Joueur1 * 3);
                Debogue("predu joueur 1 total = " + total_Joueur1);
                total1str = Integer.toString(total_Joueur1);
                jLabelArray[4].setText(total1str);
            }
            Debogue("montant de point total joueur 1 = " + montantPointTotal_Joueur1 + " montant de point total joueur 2 = " + montantPointTotal_Joueur2);
            if (montantPointTotal_Joueur1 > montantPointTotal_Joueur2) {
                String total2str;
                total_Joueur2 = total_Joueur2 - (pari_Joueur2 * 3);
                total2str = Integer.toString(total_Joueur2);
                jLabelArray[5].setText(total2str);
                Debogue("predu joueur 2 total = " + total_Joueur2);
            }

            recommencer.setVisible(true);
            continuer.setVisible(true);
            totalargentstr = Integer.toString(totalargent);
            jLabelArray[l].setText(totalargentstr);
            pari = pari + pari;
            gagnant.setText(nom + " a gagner " + pari + "$");
            ArreteButton();
        }
        return totalpoint;
    }

    public void ArreteButton() {
        Debogue("dans ArreteButton");
        //quand le jeu termine
        button_Joueur1.setEnabled(false);
        button_Joueur2.setEnabled(false);
    }

    public void RouleDe() {
        Debogue("dans RouleDe");
        int d1 = 0, d2 = 0;
        //valeur du premier de
        d1 = (RouleD());
        //valeur du deuxieme de
        d2 = (RouleD());
        if (d1 == d2) {//si les deux des roules on la même valeur
            d1 = d1 * 2;//double la valeurs des des
            d2 = d2 * 2;//double la valeurs des des
        }
        //addition des deux des
        total = d1 + d2;
        if (o == 1) {
            soustotal = total + soustotal;
            o++;
        }
    }

    public int RouleD() {
        Debogue("dans RouleD");
        //valeur au hasard entre 1 et 6 
        return ((int) (Math.random() * 6 + 1));
    }

    public IUGSevensOut() {
        Debogue("dans GUISevensOut");

        frame = new JFrame("GUISevensOut");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BorderLayout
        BorderLayout bordConteneur = new BorderLayout();
        JPanel main = new JPanel(new BorderLayout());
        //Grid layout
        JPanel grid1 = new JPanel(new GridLayout(6, 1));
        JPanel grid2 = new JPanel(new GridLayout(6, 1));
        JPanel grid3 = new JPanel(new GridLayout(6, 1));
        JPanel grid4 = new JPanel(new GridLayout(1, 1));
        //JLabels
        JLabel pPG = new JLabel("Points pour gagner");
        JLabel jPari_Joueur1 = new JLabel("Ton pari");
        JLabel montantPari_Joueur1 = new JLabel("50");
        JLabel jPari_Joueur2 = new JLabel("Ton pari");
        JLabel montantPari_Joueur2 = new JLabel("25");
        JLabel argent_Joueur1 = new JLabel("Ton argent est ");
        JLabel argent_Joueur2 = new JLabel("Ton argent est ");
        //JPanel
        JPanel nom_Joueur1 = new JPanel();
        JPanel rouleButton_Joueur1 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel nom_Joueur2 = new JPanel();
        JPanel rouleButton2 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panel11 = new JPanel();
        JPanel panel12 = new JPanel();
        JPanel panel13 = new JPanel();
        JPanel panel14 = new JPanel();
        JPanel panel15 = new JPanel();

        nom_Joueur1.add(textFieldArray[0]);
        rouleButton_Joueur1.add(button_Joueur1);
        panel1.add(pointRecuArray[0]);
        panel1.add(pointRecuArray[1]);
        panel2.add(jLabelArray[0]);
        panel2.add(jLabelArray[1]);
        panel4.add(jPari_Joueur1);
        panel4.add(textFieldArray[3]);
        panel12.add(argent_Joueur1);
        panel12.add(jLabelArray[4]);

        grid1.add(nom_Joueur1);
        grid1.add(rouleButton_Joueur1);
        grid1.add(panel1);
        grid1.add(panel2);
        grid1.add(panel4);
        grid1.add(panel12);
        /*sa construit le textfield pour entrer le nom du premier joueurs, le button pour rouler du premier joueur, ces points recu, 
        son total de points, son pari et lui laisse entrer un pari et son argent totale.
         */
        main.add(grid1, BorderLayout.WEST);

        nom_Joueur2.add(textFieldArray[1]);
        rouleButton2.add(button_Joueur2);
        panel5.add(pointRecuArray[2]);
        panel5.add(pointRecuArray[3]);
        panel6.add(jLabelArray[2]);
        panel6.add(jLabelArray[3]);
        panel8.add(jPari_Joueur2);
        panel8.add(textFieldArray[4]);
        panel13.add(argent_Joueur2);
        panel13.add(jLabelArray[5]);

        grid2.add(nom_Joueur2);
        grid2.add(rouleButton2);
        grid2.add(panel5);
        grid2.add(panel6);
        grid2.add(panel8);
        grid2.add(panel13);
        /*sa construit le textfield pour entrer le nom du deuxieme joueurs, le button pour rouler du deuxieme joueurs, ces points recu, 
        son total de points, son pari et lui laisse entrer un pari et son argent totale.
         */

        main.add(grid2, BorderLayout.EAST);

        panel3.add(pPG);
        panel3.add(textFieldArray[2]);
        panel10.add(pointPourGagnerNonValid);
        panel11.add(recu7);
        panel14.add(continuer);
        panel14.add(recommencer);
        panel15.add(pariInvalid);

        grid3.add(panel3);
        grid3.add(panel10);
        grid3.add(panel11);
        grid3.add(panel14);
        grid3.add(panel15);
        /*sa laisse entre une valeur pour le points pour gagner, si c'est invalid sa demande d'inserez un nombre entre 0 et 100, sa lui avise 
si il obtient un 7, apres que un joueurs gagne sa montre le choix de continuer ou recommencer et si il a un pari moins que 0 ou plus que
        son argent sa lui avise que c'est invalid.
         */
        main.add(grid3, BorderLayout.CENTER);

        panel9.add(gagnant);

        grid4.add(panel9);
//sa montre qui gagne apres que le total de un des joueurs passe le points pour gagner donner.
        main.add(grid4, BorderLayout.SOUTH);

        frame.add(main);
        recommencer.setVisible(false);
        continuer.setVisible(false);
        pariInvalid.setVisible(false);
        pointPourGagnerNonValid.setVisible(false);
        recu7.setVisible(false);
        button_Joueur1.setEnabled(false);
        button_Joueur2.setEnabled(false);
        button_Joueur1.addActionListener(this);
        button_Joueur1.setActionCommand("Jun");
        button_Joueur2.addActionListener(this);
        button_Joueur2.setActionCommand("Jdeux");
        textFieldArray[0].setActionCommand("nom un");

        //on ne peut pas mettre tous ces action listener sous une methode a cause qu'il sont tous des evenement independant et il on chacun un different utilité.
        //ce actionlistener vas fermer le textfield apres que le premier joueur entre son nom, et le sauver come nom1 
        textFieldArray[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g) {
                textFieldArray[0].setEditable(false);
                nom1 = textFieldArray[0].getText();

            }
        });
        //ce actionlistener vas fermer le text field apres que le deuxieme joueur entre son nom, et le sauver come nom2  
        textFieldArray[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent h) {
                Debogue("textFieldArray[1] ActionListener");
                textFieldArray[1].setEditable(false);
                nom2 = textFieldArray[1].getText();
            }
        });
        //Ce actionlistener est pour fermer le text field de points pour gagner après qu'il click enter, on sauve le montant en valeur Int
        textFieldArray[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent i) {
                Debogue("textFieldArray[2] ActionListener");
                /*il avait un bug que quand tu click enter sa vas dans cette methode et ouvre le premier button lorsque le deuxieme est ouvert
                (on veut seulement un ouvert a la fois), c'est pourquoi j'ai fait une condition pour seulement faire cette methode 1 fois*/
                if (l == 1) {
                    String pPG1str;
                    pPG1str = textFieldArray[2].getText();
                    montantdePointsPourGagner = Integer.parseInt(pPG1str);
                    pointPourGagnerNonValid.setVisible(false);
                    button_Joueur1.setEnabled(true);
                    textFieldArray[2].setEditable(false);
                    l++;
                    Debogue("montant de point pour gagner = " + montantdePointsPourGagner);
                    if ((montantdePointsPourGagner > 100) || (montantdePointsPourGagner <= 0)) {
                        textFieldArray[2].setEditable(true);
                        pointPourGagnerNonValid.setVisible(true);
                        l = 1;
                        button_Joueur1.setEnabled(false);
                    }
                }
            }
        });
        //cette methode est pour le sauver la valeur du pari qui a entrer le premier joueurs, de plus sa ne laisse pas entre plus que le total d'argent qu'il y a.
        textFieldArray[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent j) {
                Debogue("textFieldArray[3] ActionListener");
                String pari1str;
                textFieldArray[3].setEditable(false);
                pariInvalid.setVisible(false);
                pari1str = textFieldArray[3].getText();
                pari_Joueur1 = Integer.parseInt(pari1str);
                Debogue("pari de joueur 1 = " + pari_Joueur1 + " Total de joueur 1 = " + total_Joueur1);
                if (pari_Joueur1 > total_Joueur1 || pari_Joueur1 == 0) {
                    textFieldArray[3].setEditable(true);
                    pariInvalid.setVisible(true);
                }
                total_Joueur1 = total_Joueur1 + (pari_Joueur1 * 2);
                Debogue("" + total_Joueur2);
            }
        });
        //cette methode est pour le sauver la valeur du pari qui a entrer le deuxieme joueurs, de plus sa ne laisse pas entre plus que le total d'argent qu'il y a.
        textFieldArray[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent k) {
                Debogue("textFieldArray[4] ActionListener");
                String pari2str;
                pari2str = textFieldArray[4].getText();
                pari_Joueur2 = Integer.parseInt(pari2str);
                textFieldArray[4].setEditable(false);
                Debogue("pari de joueur 2 = " + pari_Joueur2 + " Total de joueur 2 = " + total_Joueur2);
                if (pari_Joueur2 > total_Joueur2 || pari_Joueur2 == 0) {
                    textFieldArray[4].setEditable(true);
                    pariInvalid.setVisible(true);
                }
                total_Joueur2 = total_Joueur2 + (pari_Joueur2 * 2);
                Debogue("" + total_Joueur2);
            }
        });
//cette methode vas recommencer le jeu, sa reinitialise les variable et dispose du frame et ouvvre un nouveaux IUG
        recommencer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ab) {
                Debogue("reccommencer ActionListener");
                total = 0;
                montantPointTotal_Joueur1 = 0;
                montantPointTotal_Joueur2 = 0;
                montantdePointsPourGagner = 0;
                l = 1;
                pari_Joueur1 = 0;
                pari_Joueur2 = 0;

                frame.dispose();
                new IUGSevensOut();

            }
        });
//sa remet remets le total et le point recu a 0, de plus sa re ouvre les pari et points pour gagner pour qu'il puisse etre modifier a l'interet des joueurs
        continuer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ab) {
                Debogue("Dans continuer ActionListener");
                int point = 0, point1 = 0;
                String totalstr, totalstr1, totalpointsstr, totalpointsstr1;
                montantPointTotal_Joueur1 = 0;
                montantPointTotal_Joueur2 = 0;
                totalstr = Integer.toString(point);
                totalstr1 = Integer.toString(point1);
                totalpointsstr = Integer.toString(montantPointTotal_Joueur1);
                totalpointsstr1 = Integer.toString(montantPointTotal_Joueur2);
                jLabelArray[1].setText(totalpointsstr);
                jLabelArray[3].setText(totalpointsstr1);
                pointRecuArray[1].setText(totalstr);
                pointRecuArray[3].setText(totalstr1);
                l = 1;
                continuer.setVisible(false);
                recommencer.setVisible(false);
                textFieldArray[2].setEditable(true);
                textFieldArray[3].setEditable(true);
                textFieldArray[4].setEditable(true);
            }
        });
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int k = 2, l = 0;
        JLabel Pointrecu1 = new JLabel("0");
        JLabel Pointrecu3 = new JLabel("0");
//j'ai sauve le click du button un comme Jun donc quand il click button 1 sa vient dans cette if
        if ("Jun".equals(ae.getActionCommand())) {
            Debogue("Jun ");
            k = 1;
            l = 4;
            //seuelement 1 joueuers peut rouler a la fois donc quand le premier joueur roule sa lui laisse plus jusqua le deuxieme roule 
            button_Joueur1.setEnabled(false);
            button_Joueur2.setEnabled(true);
            //si le points pour gagner est en dessous 24 le joueurs peut gagner dans un tour donc sa sauve son montant total
            RouleDe();
            Debogue("totalpoints = " + montantPointTotal_Joueur1);
            montantPointTotal_Joueur1 = ButtonFrapper(montantPointTotal_Joueur1, k, nom1, pari_Joueur1, l, total_Joueur1);
        }
        if ("Jdeux".equals(ae.getActionCommand())) {
            Debogue("Jdeux ");
            o = 1;
            k = 3;
            l = 5;
            //seuelement 1 joueuers peut rouler a la fois donc quand le deuxieme joueur roule sa lui laisse plus jusqua le premier roule 
            button_Joueur2.setEnabled(false);
            button_Joueur1.setEnabled(true);
            RouleDe();
            Debogue("totalpoints1 = " + montantPointTotal_Joueur2);
            montantPointTotal_Joueur2 = ButtonFrapper(montantPointTotal_Joueur2, k, nom2, pari_Joueur2, l, total_Joueur2);
        }
    }
}
// fin constructeur

// le main
  // fin class
