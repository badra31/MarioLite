package com.badra.personnagesDuJeu;

import com.badra.ApplicationDuJeu.Main;
import com.badra.ObjetsDuJeu.ObjetJeu;
import com.badra.ObjetsDuJeu.Piece;

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
    public Image getImgMario() {return imgMario;}

    public boolean isSaut() {return saut;}

    ///////  SETTERS  /////////

    public void setSaut(boolean saut) {this.saut = saut;}

    //////  METHODES  ///////

    public Image saute() {

        String str;
        ImageIcon ico;
        Image img;

        this.compteurSaut++;
        // Montée du saut
        if (this.compteurSaut <= 40) {
            if (this.getY() > Main.scene.getHauteurPlafond()) {this.setY(this.getY() - 4);
            } else {
                this.compteurSaut = 41;
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

        // Affichage de l'image ico
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }

    public void contactObjet(ObjetJeu objet) {
        // Contact horizontal
        if (super.contactAvant(objet) == true && this.isVersDroite() == true || super.contactArriere(objet) == true && this.isVersDroite() == false){
            Main.scene.setDx(0);
            this.setMarche(false);
        }

        // Contact avec un objet en desous
        if (super.contactDessous(objet) == true && this.saut == true) {
            Main.scene.setySol(objet.getY());
        }else if (super.contactDessous(objet) == false) {
            Main.scene.setySol(293);
            if (this.saut == false) {this.setY(243);}
        }

        // Contact avec un objet en dessus
        if (super.contactDessus(objet) == true) {
            Main.scene.setHauteurPlafond(objet.getY() + objet.getHauteur());
        }else if (super.contactDessus(objet) == false && this.saut == false) {
            Main.scene.setHauteurPlafond(0);
        }

    }

    public boolean contactPiece(Piece piece) {
        // Contact pieces n'a pas de répercution sur mario
        if (this.contactArriere(piece) == true
                || this.contactAvant(piece) == true
                || this.contactDessous(piece) == true
                || this.contactDessus(piece) == true) {
            return true;
        }else{return false;}

    }

}



