package com.badra.ApplicationDuJeu;

import com.badra.ObjetsDuJeu.BlocPierre;
import com.badra.ObjetsDuJeu.ObjetJeu;
import com.badra.ObjetsDuJeu.TuyauRouge;
import com.badra.personnagesDuJeu.Mario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

//***  La classe Scene est la classe la plus importante de l'application. ***//
//***  Elle est accessible par toutes les autres classes et contient le moteur de l'application. ***//
//***  Elle gère la partie graphique de l'application.  ***//

public class Scene extends JPanel {

    ////////  VARIABLES  ///////////

    // Déclaration images du jeu
    private ImageIcon icoFond; // Création du fond d'ecran
    private Image imgFond1; // Image de fond1
    private Image imgFond2; // Copie image de fond 1 pour affichage à l'infini

    private ImageIcon icoDepart; // création d'un balisage de départ
    private Image imgDepart; // image (type: ponton de départ)
    private ImageIcon icoChateaux; // création d'un balisage de début(type: chateaux) de début
    private Image imgChateaux1;// Image symbolique(type chateaux)
    private ImageIcon icoDrapeau;
    private Image imgDrapeau;
    private ImageIcon icoChateauFin;
    private Image imgChateauFin;

    // Déclaration des différentes position en abscisse et ordonnée
    private int xFond1; // variable de position du fond
    private int xFond2;
    private int dx; // Variable de deplacement du fond
    private int xPos; // Position absolue dans le jeu

    private int ySol; // Hauteur absolue du sol
    private int hauteurPlafond; // Hauteur absolue du plafont

    // Declaration Personnage
    public Mario mario;

    // Déclaration ObjetJeu
    public TuyauRouge tuyauRouge1;
    public TuyauRouge tuyauRouge2;
    public TuyauRouge tuyauRouge3;
    public TuyauRouge tuyauRouge4;
    public TuyauRouge tuyauRouge5;
    public TuyauRouge tuyauRouge6;
    public TuyauRouge tuyauRouge7;
    public TuyauRouge tuyauRouge8;

    public BlocPierre blocPierre1;
    public BlocPierre blocPierre2;
    public BlocPierre blocPierre3;
    public BlocPierre blocPierre4;
    public BlocPierre blocPierre5;
    public BlocPierre blocPierre6;
    public BlocPierre blocPierre7;
    public BlocPierre blocPierre8;
    public BlocPierre blocPierre9;
    public BlocPierre blocPierre10;
    public BlocPierre blocPierre11;
    public BlocPierre blocPierre12;

    // Déclaration ArrayList d'ObjetJeu
    private ArrayList<ObjetJeu> tabObjets;

    ///////  CONSTRUCTEUR  /////

    public Scene() {

        super();

        this.xFond1 = -50; // position initial
        this.xFond2 = 750; // position relative à la valeur initial
        this.dx = 0;
        this.xPos = -1;

        this.ySol = 293;
        this.hauteurPlafond = 0;

        icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondEcran.png")));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        icoDepart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/depart.png")));
        this.imgDepart = icoDepart.getImage();

        icoChateaux = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateau1.png")));
        this.imgChateaux1 = icoChateaux.getImage();

        icoDrapeau = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/drapeau.png")));
        this.imgDrapeau = icoDrapeau.getImage();

        icoChateauFin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateauFin.png")));
        this.imgChateauFin = icoChateauFin.getImage();

        // Instancié initialisé les Personnages
        mario = new Mario(300, 245);

        // Instancié les ObjetJeu
        blocPierre1 = new BlocPierre(400, 180);
        blocPierre2 = new BlocPierre(1200, 180);
        blocPierre3 = new BlocPierre(1270, 170);
        blocPierre4 = new BlocPierre(1340, 160);
        blocPierre5 = new BlocPierre(2000, 180);
        blocPierre6 = new BlocPierre(2600, 160);
        blocPierre7 = new BlocPierre(2650, 180);
        blocPierre8 = new BlocPierre(3500, 160);
        blocPierre9 = new BlocPierre(3550, 140);
        blocPierre10 = new BlocPierre(4000, 170);
        blocPierre11 = new BlocPierre(4200, 200);
        blocPierre12 = new BlocPierre(4300, 210);

        tuyauRouge1 = new TuyauRouge(600, 230);
        tuyauRouge2 = new TuyauRouge(1000, 230);
        tuyauRouge3 = new TuyauRouge(1600, 230);
        tuyauRouge4 = new TuyauRouge(1900, 230);
        tuyauRouge5 = new TuyauRouge(2500, 230);
        tuyauRouge6 = new TuyauRouge(3000, 230);
        tuyauRouge7 = new TuyauRouge(3800, 230);
        tuyauRouge8 = new TuyauRouge(4500, 230);

        // Instancié l'objet "tabObjets"
        tabObjets = new ArrayList<ObjetJeu>();

        // Initialisé contenu tabObjets
        this.tabObjets.add(this.tuyauRouge1);
        this.tabObjets.add(this.tuyauRouge2);
        this.tabObjets.add(this.tuyauRouge3);
        this.tabObjets.add(this.tuyauRouge4);
        this.tabObjets.add(this.tuyauRouge5);
        this.tabObjets.add(this.tuyauRouge6);
        this.tabObjets.add(this.tuyauRouge7);
        this.tabObjets.add(this.tuyauRouge8);

        this.tabObjets.add(this.blocPierre1);
        this.tabObjets.add(this.blocPierre2);
        this.tabObjets.add(this.blocPierre3);
        this.tabObjets.add(this.blocPierre4);
        this.tabObjets.add(this.blocPierre5);
        this.tabObjets.add(this.blocPierre6);
        this.tabObjets.add(this.blocPierre7);
        this.tabObjets.add(this.blocPierre8);
        this.tabObjets.add(this.blocPierre9);
        this.tabObjets.add(this.blocPierre10);
        this.tabObjets.add(this.blocPierre11);
        this.tabObjets.add(this.blocPierre12);


        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier()); // Ecouteur de touche clavier géré dans la classe Clavier

        Thread chronoEcran = new Thread(new Chrono()); // Création d'un Thread géré pr la classe Chrono
        chronoEcran.start();
    }

    /////// GETTERS //////////

    public int getDx() {return dx;}

    public int getxPos() {return xPos;}

    public int getySol() {return ySol;}

    public int getHauteurPlafond() {return hauteurPlafond;}

    ///////  SETTERS ///////

    public void setxPos(int xPos) {this.xPos = xPos;}

    public void setDx(int dx) {this.dx = dx;}

    public void setySol(int ySol) {this.ySol = ySol;}

    public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

    public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

    public void setHauteurPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

    //////  METHODES  ////////

    public void deplacementFond() { // Déplacement des images de font simulant le dplacement de mario

        if(this.xPos >= 0 && this.xPos <= 4430) {
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

        // Detection contact mario avec un objet si condition "mario.proche" valide
        for (int i = 0; i < this.tabObjets.size(); i++){
            // mario
            if (this.mario.procheObjet(this.tabObjets.get(i))){this.mario.contact(this.tabObjets.get(i));}
        }

        //  Gestion du déplacement de touts les objets fixe du jeu

        this.deplacementFond();
        if (this.xPos >= 0 && this.xPos <= 4430) {
            for (int i = 0; i < this.tabObjets.size(); i++) {this.tabObjets.get(i).deplacement();}
        }

        // Dessin de l'image de fond.
        g.drawImage(this.imgFond1, this.xFond1, 0, null);
        g.drawImage(this.imgFond2, this.xFond2, 0, null);

        // Dessin de l'image des objetJeu.
        for (int i = 0; i < this.tabObjets.size(); i++){
            g.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(),this.tabObjets.get(i).getY(), null);
        }

        // Dessin des image de départ et fin de jeu de mario
        g.drawImage(this.imgChateaux1, 10 - this.xPos, 95, null); // dessin de l'image du chatêaud de départ
        g.drawImage(this.imgDepart, 220 - this.xPos, 234, null); // dessin de l'image du panneaux de départ
        g.drawImage(this.imgDrapeau, 4650 - this.xPos, 115, null); // dessin de l'image du drapeau de fin
        g.drawImage(this.imgChateauFin, 5000 - this.xPos, 145, null); // dessin de l'image du chateau de fin

        // Dessin de l'image du personnage.
        if(this.mario.isSaut()) {
            g.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(),null);
        }else{
            g.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
        }

    }
}
