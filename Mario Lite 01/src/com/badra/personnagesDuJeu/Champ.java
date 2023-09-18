package com.badra.personnagesDuJeu;

import com.badra.ApplicationDuJeu.Main;
import com.badra.ObjetsDuJeu.ObjetJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Champ extends Personnage implements Runnable{

    private ImageIcon icoCamp;
    private Image imgChamp;

    private final int PAUSE = 15; // Temps d'attente en ms entre 2 tours de boucle
    private int dxChamp; // Déplacement du champignon

    ////////  CONSTRUCTEUR   ///////////

    public Champ(int x, int y) {

        super(x, y, 27, 30);
        super.setVersDroite(true);
        super.setMarche(true);

        this.dxChamp = 1;
        this.icoCamp = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/champArretDroite.png")));
        this.imgChamp = icoCamp.getImage();

        Thread chronoChamp = new Thread(this);
        chronoChamp.start();
    }

    ////////  GETTERS   /////////

    public Image getImgChamp() {return imgChamp;}

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
        if (super.isVersDroite() == true){this.dxChamp = 1;}
        else{this.dxChamp = -1;}
        super.setX(super.getX() + this.dxChamp);
    }

    public void contactObjet(ObjetJeu objet) {
        // Contact horizontal
        if (super.contactAvant(objet) == true && this.isVersDroite() == true){
            super.setVersDroite(false);
            this.dxChamp = -1;
        } else if (super.contactArriere(objet) == true && this.isVersDroite() == false) {
            super.setVersDroite(true);
            this.dxChamp = 1;
        }

    }
}
