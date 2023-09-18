package com.badra.personnagesDuJeu;

import com.badra.ApplicationDuJeu.Main;
import com.badra.ObjetsDuJeu.ObjetJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Personnage {

    ////////  VARIABLES  ///////////

    private int largeur, hauteur;  // Dimension du personnage
    private int x, y;  // Position du personnage
    private boolean marche; // true quand le personnage marche
    private boolean versDroite;  // true quand le personnage est tourné vers la droite
    private int compteur;  // compteur des pas du personnage

    protected  boolean vivant; // true si personnage est vivant



    public  Personnage(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
        this.vivant = true;
    }

    /////// GETTERS ////////

    public int getX() {return x;}

    public int getY() {return y;}

    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public boolean isMarche() {return marche;}

    public boolean isVersDroite() {return versDroite;}

    public int getCompteur() {return compteur;}

    public boolean isVivant() {return vivant;}

    ////// SETTERS ///////

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setMarche(boolean marche) {this.marche = marche;}

    public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

    public void setCompteur(int compteur) {this.compteur = compteur;}

    public void setVivant(boolean vivant) {this.vivant = vivant;}

    //////  METHODES  ////////

    public void deplacement() {
        if (Main.scene.getxPos() >= 0) {
            this.x = this.x - Main.scene.getDx();
        }
    }

    public Image marche(String nom, int frequence) {

        String str;
        ImageIcon ico;
        Image img;

        // Condition de posture et de position du Personnage
        if(this.marche == false ) {
            if(this.versDroite) {str = "/images/" + nom + "ArretDroite.png";}
            else {str = "/images/" + nom + "ArretGauche.png";}
        }else{
                this.compteur++;
                if(this.compteur / frequence == 0) {
                    if(this.versDroite == true) {str = "/images/" + nom + "ArretDroite.png";}
                    else {str = "/images/" + nom + "ArretGauche.png";}
                }else{
                    if(this.versDroite == true) {str = "/images/" + nom + "MarcheDroite.png";}
                    else {str = "/images/" + nom + "MarcheGauche.png";}
                }
                if (this.compteur == 2 * frequence) {this.compteur = 0;}
        }

        // Affichage de l'image du personnage
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }


/*
    public boolean contactAvant(ObjetJeu objet) {
        if (this.isVersDroite() == true){
            if (this.x + this.largeur < objet.getX() // mario trop a gauche
                    || this.x + this.largeur < objet.getX() + 5 // mario trop à droite
                    || this.y + this.hauteur <= objet.getY() // mario est trop haut
                    || this.y >= objet.getY() + objet.getHauteur()) // mario est trop bas
            {
                return false;
            }else{return true;}
        } else {return  false;}
    }
*/
    // Détection contact à droite de mario
    protected boolean contactAvant(ObjetJeu objet) {

        if (this.x + this.largeur < objet.getX()
                || this.x + this.largeur > objet.getX() + 5
                || this.y + this.hauteur <= objet.getY()
                || this.y >= objet.getY() + objet.getHauteur()) {
            return false;
        }else{return true;}
    }

    // Détection contact à gauche de mario
    protected boolean contactArriere(ObjetJeu objet) {
        if (this.x > objet.getX() + objet.getLargeur()
                || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5
                || this.y + this.hauteur <= objet.getY()
                || this.y >= objet.getY() + objet.getHauteur()) {
            return false;
        }else{return true;}
    }

    // Détection contact en dessous de mario
    protected boolean contactDessous(ObjetJeu objet) {
        if (this.x + this.largeur < objet.getX() + 5
                || this.x > objet.getX() + objet.getLargeur() - 5
                || this.y + this.hauteur < objet.getY()
                || this.y + this.hauteur > objet.getY() + 5) {
            return false;
        }else{return true;}
    }

    // Détection contact au dessus de mario
    protected boolean contactDessus(ObjetJeu objet) {
        if (this.x + this.largeur < objet.getX() + 5
                || this.x > objet.getX() + objet.getLargeur() - 5
                || this.y < objet.getY() + objet.getHauteur()
                || this.y > objet.getY() + objet.getHauteur() + 5) {
            return false;
        }else{return true;}
    }

    // Détection contact à droite du personnage ennemi
    protected boolean contactAvant(Personnage personnage) {

        if (this.isVersDroite() == true){
            if (this.x + this.largeur < personnage.getX()
                    || this.x + this.largeur > personnage.getX() + 5
                    || this.y + this.hauteur <= personnage.getY()
                    || this.y >= personnage.getY() + personnage.getHauteur()) {
                return false;
            }else{return true;}
        }else {return false;}
    }

    // Détection contact à gauche du Personnage ennemi
    protected boolean contactArriere(Personnage personnage) {
        if (this.x > personnage.getX() + personnage.getLargeur()
                || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5
                || this.y + this.hauteur <= personnage.getY()
                || this.y >= personnage.getY() + personnage.getHauteur()) {
            return false;
        }else{return true;}
    }

    protected boolean contactDessous(Personnage personnage) {
        if (this.x + this.largeur < personnage.getX() || this.x > personnage.getX() + personnage.getLargeur()
                || this.y + this.hauteur < personnage.getY() || this.y + this.hauteur > personnage.getY() + 5) {
            return false;
        }else{return true;}
    }


    // Détection de l'objet proche de mario afin d'évité les conflis de contact
    // d'un objet a l'autre

    public boolean procheObjet(ObjetJeu objet) {
        if ((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10)
                || (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() +10)){
                return true;
        }else{return false;}
    }

    public boolean procheObjet(Personnage personnage) {
        if ((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getLargeur() + 10)
                || (this.x + this.largeur > personnage.getX() - 10 && this.x + this.largeur < personnage.getX() + personnage.getLargeur() +10)){
            return true;
        }else{return false;}
    }
}
