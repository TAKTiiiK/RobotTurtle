package Graphisme;


import Jeu.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame {
    private final Dimension TAILLE_BOUTON = new Dimension(150, 40);
    private Fenetre fenetre;
    private FenetreJeu FeJeu;
    private Plateau plateau;
    private JButton Bouton2J = new JButton("2 Joueurs");
    private JButton Bouton3J = new JButton("3 Joueurs");
    private JButton Bouton4J = new JButton("4 Joueurs");

    public Fenetre() {
        fenetre = this;
        Background Back = new Background();
        //Parametre de base
        this.setTitle("Turtle Game");
        this.setSize(775, 1002);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Back);
        Back.setLayout(new BorderLayout());

        //Conteneur principal
        JPanel conteneurMenu = new JPanel();
        conteneurMenu.setPreferredSize(new Dimension(100, 100));
        conteneurMenu.setOpaque(false);

        //Position composants
        conteneurMenu.add(Bouton2J);
        conteneurMenu.add(Bouton3J);
        conteneurMenu.add(Bouton4J);
        this.getContentPane().add(conteneurMenu, BorderLayout.SOUTH);
        this.setVisible(true);
        iniBouton();
    }

    private void iniBouton() {
        Bouton2J.setPreferredSize(TAILLE_BOUTON);
        Bouton3J.setPreferredSize(TAILLE_BOUTON);
        Bouton4J.setPreferredSize(TAILLE_BOUTON);
        Bouton2J.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("2 Joueurs");
                plateau = new Plateau(2);
                FeJeu = new FenetreJeu(plateau);
                dispose();
            }
        });
        Bouton3J.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("3 Joueurs");
                plateau = new Plateau(3);
                FeJeu = new FenetreJeu(plateau);
                dispose();

            }
        });
        Bouton4J.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("4 Joueurs");
                plateau = new Plateau(4);
                FeJeu = new FenetreJeu(plateau);
                dispose();
            }
        });
    }

    public Plateau getPlateau() {
        return plateau;
    }


}