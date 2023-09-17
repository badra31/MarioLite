package com.badra.ApplicationDuJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//****** La classe clavier gère les actions utilisateur au clavier **********//
public class Clavier implements KeyListener {


    //////  METHODES  ////////
    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) { // flèche droite clavier
            // Annule le decalage de 1 créé par le déplacement du fond
            if (Main.scene.getxPos() == -1) {
                Main.scene.setxPos(0); // Réinitialisation de setxPos
                Main.scene.setxFond1(-50);  // Réinitialisation de xFond1
                Main.scene.setxFond2(750);  // Réinitialisation de xFond2
            }
            Main.scene.mario.setMarche(true);
            Main.scene.mario.setVersDroite(true);
            Main.scene.setDx(1);  // Déplacement du fond vers la gauche lors de l,appuie de la touche "flèche droite"

        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) { // flèche gauche clavier
            Main.scene.setDx(-1); // Déplacement du fond vers la droite lors de l,appuie de la touche "flèche gauche"
            Main.scene.mario.setMarche(true);
            Main.scene.mario.setVersDroite(false);
        }

        // Mario Saute
        if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
            Main.scene.mario.setSaut(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.setDx(0);  // remise à 0 de la variable dx de l'objet scene au relachement des touches
        Main.scene.mario.setMarche(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}


