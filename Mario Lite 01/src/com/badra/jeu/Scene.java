package com.badra.jeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Scene extends JPanel {

    ////////  VARIABLE  ///////////

    private ImageIcon icoFond;
    private Image imgFond1; // Image de fond1
    private Image imgFond2; // Copie image de fond 1 pour affichage infini

    private ImageIcon icoMario; // Provisoire
    private Image imgMario; // Provisoire

    private int xFond1;
    private int xFond2;
    private int dx;

    ///////  CONSTRUCTEUR  /////

    public Scene() {

        super();

        this.xFond1 = -50; // position initial
        this.xFond2 = 750; // position relative à la valeur initial
        this.dx = 0;

        icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondEcran.png")));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();
        icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/marioMarcheDroite.png")));
        this.imgMario = this.icoMario.getImage();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    /////// GETTERS AND SETTERS ///////

    public int getDx() {return dx;}

    public void setDx(int dx) {this.dx = dx;}


    //////  METHODE  ////////

    public void deplacementFond() {
        this.xFond1 = this.xFond1 - this.dx;
        this.xFond2 = this.xFond2 - this.dx;

        if(this.xFond1 == -800) {
            this.xFond1 = 800;
        } else if (this.xFond2 == -800) {
            this.xFond2 = 800;
        }else if(this.xFond1 == 800) {
            this.xFond1 = -800;
        } else if (this.xFond2 == 800) {
            this.xFond2 = -800;
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Graphics g2 = (Graphics2D)g;
        //
        // this.deplacementFond();
        // g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond.
        // g2.drawImage(this.imgMario, 300, 245, null); // Provisore.

        this.deplacementFond();

        g.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond.
        g.drawImage(this.imgFond2, this.xFond2, 0, null);
        g.drawImage(this.imgMario, 300, 245, null); // Provisore.
    }
}
