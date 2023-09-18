package com.badra.personnagesDuJeu;

import com.badra.ObjetsDuJeu.ObjetJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Tortue extends Personnage implements Runnable{

    private ImageIcon icoTortue;
    private Image imgTortue;

    private final int PAUSE = 15; // Temps d'attente en ms entre 2 tours de boucle
    private int dxTortue; // Déplacement de la tortue

    ////////  CONSTRUCTEUR   ///////////

    public Tortue(int x, int y) {

        super(x, y, 27, 30);
        super.setVersDroite(true);
        super.setMarche(true);

        this.dxTortue = 1;
        this.icoTortue = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/tortueArretDroite.png")));
        this.imgTortue = icoTortue.getImage();

        Thread chronoChamp = new Thread(this);
        chronoChamp.start();
    }

    ////////  GETTERS   /////////

    public Image getImgTortue() {return imgTortue;}

    ////////  SETTERS   /////////


    ///////  METHODEs  ////////

    @Override
    public void run() {
        try{Thread.sleep(20);}
        catch (InterruptedException e){}

        while (true) {
            this.bouge();
            try {Thread.sleep(PAUSE);
            }catch (InterruptedException e) {}
        }
    }

    public void bouge() {
        if (super.isVersDroite() == true){this.dxTortue = 1;}
        else{this.dxTortue = -1;}
        super.setX(super.getX() + this.dxTortue);
    }

    public void contactObjet(ObjetJeu objet) {
        // Contact horizontal
        if (super.contactAvant(objet) == true && this.isVersDroite() == true){
            super.setVersDroite(false);
            this.dxTortue = -1;
        } else if (super.contactArriere(objet) == true && this.isVersDroite() == false) {
            super.setVersDroite(true);
            this.dxTortue = 1;
        }

    }

    public void contactObjet(Personnage personnage) {
        // Contact horizontal
        if (super.contactAvant(personnage) == true && this.isVersDroite() == true){
            super.setVersDroite(false);
            this.dxTortue = -1;
        } else if (super.contactArriere(personnage) == true && this.isVersDroite() == false) {
            super.setVersDroite(true);
            this.dxTortue = 1;
        }

    }
}
