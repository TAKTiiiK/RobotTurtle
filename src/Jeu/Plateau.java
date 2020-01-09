package Jeu;

import Graphisme.FenetreJeuCont.Case;
import Jeu.Tuiles.Joyau;
import Jeu.Tuiles.Mur;
import Jeu.Tuiles.Tortue;
import Jeu.Tuiles.Tuile;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau {

    //*************   VARIABLES  *************
    protected Tuile[][] plateau = new Tuile[8][8];
    private Case[][] ListeCase = new Case[8][8];
    private ArrayList<Joueur> ListeJoueur = new ArrayList<>();
    private int nbJoueur;
    private Joueur TourJoueur;

    //*************   CONSTRUCTEUR  *************
    public Plateau(int nbJoueur) {
        iniPlateau(nbJoueur);
    }

    private void iniPlateau(int nbJoueur) {
        this.nbJoueur = nbJoueur;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = null;
            }
        }
        if (nbJoueur == 2) {
            plateau[0][1] = new Tortue(0, 1, "ROUGE", "S");
            plateau[0][5] = new Tortue(0, 1, "BLEU", "S");
            plateau[7][3] = new Joyau(0, 1, "VERT");
            Joueur Rouge = new Joueur("ROUGE");
            Joueur Bleu = new Joueur("BLEU");
            ListeJoueur.add(Rouge);
            ListeJoueur.add(Bleu);
            this.nbJoueur = nbJoueur;
            for (int i = 0; i < plateau.length; i++) {
                plateau[i][7] = new Mur(7, i, "PIERRE");
            }
        }
        if (nbJoueur == 3) {
            plateau[0][0] = new Tortue(0, 0, "ROUGE", "S");
            plateau[0][3] = new Tortue(0, 0, "BLEU", "S");
            plateau[0][6] = new Tortue(0, 0, "ROSE", "S");
            plateau[7][0] = new Joyau(0, 1, "ROSE");
            plateau[7][3] = new Joyau(0, 1, "VERT");
            plateau[7][6] = new Joyau(0, 1, "BLEU");
            for (int i = 0; i < plateau.length; i++) {
                plateau[i][7] = new Mur(7, i, "PIERRE");
            }
            Joueur Rouge = new Joueur("ROUGE");
            Joueur Bleu = new Joueur("BLEU");
            Joueur Rose = new Joueur("ROSE");
            ListeJoueur.add(Rouge);
            ListeJoueur.add(Bleu);
            ListeJoueur.add(Rose);
            this.nbJoueur = nbJoueur;
        }
        if (nbJoueur == 4) {
            plateau[0][0] = new Tortue(0, 0, "ROUGE", "S");
            plateau[0][2] = new Tortue(0, 0, "BLEU", "S");
            plateau[0][5] = new Tortue(0, 0, "ROSE", "S");
            plateau[0][7] = new Tortue(0, 0, "VERT", "S");
            plateau[7][1] = new Joyau(0, 1, "ROSE");
            plateau[7][6] = new Joyau(0, 1, "BLEU");
            Joueur Rouge = new Joueur("ROUGE");
            Joueur Bleu = new Joueur("BLEU");
            Joueur Rose = new Joueur("ROSE");
            Joueur Vert = new Joueur("VERT");
            ListeJoueur.add(Rouge);
            ListeJoueur.add(Bleu);
            ListeJoueur.add(Rose);
            ListeJoueur.add(Vert);
            this.nbJoueur = nbJoueur;
        }

        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                Case c = new Case(i, j);
                ListeCase[i][j] = c;
                c.updateCase(plateau[i][j]);
            }
        }
        iniTourJoueur();
    }

    public Case[][] getCases() {
        return ListeCase;
    }

    public int getNombreJoueur() {
        return this.nbJoueur;
    }

    public ArrayList<Joueur> getListeJoueur(){
        return this.ListeJoueur;
    }

    public void iniTourJoueur(){
        Collections.shuffle(ListeJoueur);
        TourJoueur =  ListeJoueur.get(0);
        //System.out.println(ListeJoueur.get(0).getCouleur());
        for (int i = 0 ; i < ListeJoueur.size(); i++) {
            // System.out.println(ListeJoueur.get(i).getCouleur());
        }
    }

    public void updateTourJoueur(int Tour){
        TourJoueur = ListeJoueur.get((Tour+1)%3);
    }

    public Joueur getTourJoueur() {
        return TourJoueur;
    }

}
