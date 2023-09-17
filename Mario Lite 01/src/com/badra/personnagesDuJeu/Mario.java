package com.badra.personnagesDuJeu;

import com.badra.ApplicationDuJeu.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Mario extends Personnage {

    ///////  VARIABLES  ///////
    private Image imgMario;
    private ImageIcon icoMario;

    private boolean saut;  // Vrai si mario saute
    private int compteurSaut;  //Duré du saut et sa hauteur

    ///////  CONSTRUCTEUR  /////
    public Mario(int x, int y) {

        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/marioArretDroite.png")));
        this.imgMario = this.icoMario.getImage();

        this.saut = false;
        this.compteurSaut = 0;
    }

    ////////  GETTERS  //////////
    public Image getImgMario() {
        return imgMario;
    }

    public boolean isSaut() {
        return saut;
    }

    ///////  SETTERS  /////////

    public void setSaut(boolean saut) {
        this.saut = saut;
    }

    //////  METHODES  ///////

    public Image saute() {

        String str;
        ImageIcon ico;
        Image img;

        this.compteurSaut++;
        // Montée du saut
        if (this.compteurSaut <= 35) {
            if (this.getY() > Main.scene.getHauteurPlafond()) {
                this.setY(this.getY() - 4);
            } else {
                this.compteurSaut = 36;
            }
            if (this.isVersDroite() == true) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/marioSautGauche.png";
            }

            // Retombé du saut
        } else if (this.getY() + this.getHauteur() < Main.scene.getySol()) {this.setY(this.getY() + 1);
            if (this.isVersDroite() == true) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/marioSautGauche.png";
            }

        // Saut terminé
        }else{

        if (this.isVersDroite() == true) {
            str = "/images/marioArretDroite.png";
        } else {
           str = "/images/marioArretGauche.png";
        }
        this.saut = false;
        this.compteurSaut = 0;
    }

        // Affivhahge de l'image ico
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }

}



