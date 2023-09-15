package com.badra.ApplicationDuJeu;

import com.badra.ObjetsDuJeu.BlocPierre;
import com.badra.ObjetsDuJeu.TuyauRouge;
import com.badra.personnagesDuJeu.Mario;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

//***  La classe Scene est la classe la plus importante de l'application. ***//
//***  Elle est accessible par toutes les autres classes et contient le moteur de l'application. ***//
//***  Elle gère la partie graphique de l'application.  ***//

public class Scene extends JPanel {

    ////////  VARIABLES  ///////////

    private ImageIcon icoFond; // Création du fond d'ecran
    private Image imgFond1; // Image de fond1
    private Image imgFond2; // Copie image de fond 1 pour affichage à l'infini

    private ImageIcon icoDepart; // création d'un balisage de départ
    private Image imgDepart; // image (type: ponton de départ)
    private ImageIcon icoChateaux; // création d'un balisage de début(type: chateaux) de début
    private Image imgChateaux1;// Image symbolique(type chateaux)

    private int xFond1; // variable de position du fond
    private int xFond2;
    private int dx; // Variable de deplacement du fond
    private int xPos; // Position absolue dans le jeu

    // Initialisation Personnage
    public Mario mario;
    // Initalisation ObjetJeu
    public TuyauRouge tuyauRouge1;
    public BlocPierre blocPierre1;
    // Initalisation


    ///////  CONSTRUCTEUR  /////

    public Scene() {

        super();

        this.xFond1 = -50; // position initial
        this.xFond2 = 750; // position relative à la valeur initial
        this.dx = 0;
        this.xPos = -1;

        icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondEcran.png")));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        icoDepart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/depart.png")));
        this.imgDepart = icoDepart.getImage();

        icoChateaux = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateau1.png")));
        this.imgChateaux1 = icoChateaux.getImage();

        // Instancié les Personnage
        mario = new Mario(300, 245);
        // Instancié les ObjetJeu
        tuyauRouge1 = new TuyauRouge(600, 230);
        blocPierre1 = new BlocPierre(400, 180);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier()); // Ecouteur de touche clavier géré dans la classe Clavier

        Thread chronoEcran = new Thread(new Chrono()); // Création d'un Thread géré pr la classe Chrono
        chronoEcran.start();
    }

    /////// GETTERS AND SETTERS ///////

    public int getDx() {return dx;}

    public void setDx(int dx) {this.dx = dx;}

    public int getxPos() {return xPos;}

    public void setxPos(int xPos) {this.xPos = xPos;}

    public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

    public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

//////  METHODES  ////////

    public void deplacementFond() { // Déplacement des images de font simulant le dplacement de mario

        if(this.xPos >= 0) {
            // Mise à jour des positions des éléments du jeu lors du déplacement de mario
            this.xPos = this.xPos  + this.dx;
            this.xFond1 = this.xFond1 - this.dx;
            this.xFond2 = this.xFond2 - this.dx;
        }

        // Permanace du fond d'écran en simulant une boucle avec xFond1 et xFond2
        if(this.xFond1 == -800) {this.xFond1 = 800;}
        else if (this.xFond2 == -800) {this.xFond2 = 800;}
        else if(this.xFond1 == 800) {this.xFond1 = -800;}
        else if (this.xFond2 == 800) {this.xFond2 = -800;}
    }

    public void paintComponent(Graphics g) { // Dessin de toutes les images visible à l'écran (appel toute les 3ms ~)

        super.paintComponent(g);

        // Graphics g2 = (Graphics2D)g;
        //
        // this.deplacementFond();
        // g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond.
        // g2.drawImage(this.imgMario, 300, 245, null); // Provisore.

        // Detection contact gauche
        if (this.mario.contactAvant(tuyauRouge1) == true) {
            this.mario.setMarche(false);
            this.dx = 0;
        }

        this.deplacementFond();
        this.tuyauRouge1.deplacement();
        this.blocPierre1.deplacement();

        System.out.println(this.tuyauRouge1.getX());

        // Dessin de l'image de fond.
        g.drawImage(this.imgFond1, this.xFond1, 0, null);
        g.drawImage(this.imgFond2, this.xFond2, 0, null);

        // Dessin de l'image du personnage.
        g.drawImage(this.mario.marche("mario", 25), 300, 245, null); //

        g.drawImage(this.imgDepart, 220 - this.xPos, 234, null);
        g.drawImage(this.imgChateaux1, 10 - this.xPos, 95, null);

        // Dessin de l'image des objetJeu.
        g.drawImage(this.tuyauRouge1.getImgTuyauRouge(), this.tuyauRouge1.getX(), this.tuyauRouge1.getY(), null);
        g.drawImage(this.blocPierre1.getImgBlocPierre(), this.blocPierre1.getX(), this.blocPierre1.getY(), null);

    }
}
