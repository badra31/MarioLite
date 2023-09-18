package com.badra.ObjetsDuJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Piece extends ObjetJeu implements Runnable {

    //////  VARIABES  //////

    private int compteur;
    private final int PAUSE = 15;  // Temps d'attente enter 2 tours de boucle ou piece en l'occurence

    ///////  CONSTRUCTEUR  ///////

    public Piece(int x, int y) {
        super(x, y, 30, 50);

        super.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/piece1.png")));
        super.imgObjet = super.icoObjet.getImage();
    }

    ///////  METHODES  ///////

    public Image animePiece() {

        String str;
        ImageIcon ico;
        Image img;

        this.compteur++;
        if (this.compteur / 100 == 0) {str = "/images/piece1.png";}
        else{str = "/images/piece2.png";}
        if (this.compteur == 200) {this.compteur = 0;}

        // Affichage de l'image du personnage
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);  // Temps d'attente avant d'appeler animePiece pour que tous soit créés complètement
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            this.animePiece();
            try {
                Thread.sleep(PAUSE);
            }catch (InterruptedException e){}
        }
    }
}
