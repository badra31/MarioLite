package com.badra.ApplicationDuJeu;

import com.badra.ObjetsDuJeu.BlocPierre;
import com.badra.ObjetsDuJeu.ObjetJeu;
import com.badra.ObjetsDuJeu.Piece;
import com.badra.ObjetsDuJeu.TuyauRouge;
import com.badra.personnagesDuJeu.Champ;
import com.badra.personnagesDuJeu.Mario;
import com.badra.personnagesDuJeu.Tortue;

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

    public Champ champ1;
    public Champ champ2;
    public Champ champ3;
    public Champ champ4;
    public Champ champ5;
    public Champ champ6;
    public Champ champ7;
    public Champ champ8;


    public Tortue tortue1;
    public Tortue tortue2;
    public Tortue tortue3;
    public Tortue tortue4;
    public Tortue tortue5;
    public Tortue tortue6;
    public Tortue tortue7;
    public Tortue tortue8;
    public Tortue tortue9;

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

    public Piece piece1;
    public Piece piece2;
    public Piece piece3;
    public Piece piece4;
    public Piece piece5;
    public Piece piece6;
    public Piece piece7;
    public Piece piece8;
    public Piece piece9;
    public Piece piece10;


    // Déclaration ArrayList d'ObjetJeu
    private ArrayList<ObjetJeu> tabObjets; // tableau qui enregistre tous les objets du jeu
    private ArrayList<Piece> tabPieces; // tableau qui enregistre toutes les pieces du jeu
    private ArrayList<Champ> tabChamps; // Tableau de tous les champignions du jeu
    private ArrayList<Tortue> tabTortues; // Tableau de touts les tortues du jeu

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

        champ1 = new Champ(800, 263);
        champ2 = new Champ(1100, 263);
        champ3 = new Champ(2100, 263);
        champ4 = new Champ(2400, 263);
        champ5 = new Champ(3200, 263);
        champ6 = new Champ(3500, 263);
        champ7 = new Champ(3700, 263);
        champ8 = new Champ(4500, 263);

        tortue1 = new Tortue(950, 243);
        tortue2 = new Tortue(1500, 243);
        tortue3 = new Tortue(1800, 243);
        tortue4 = new Tortue(2400, 243);
        tortue5 = new Tortue(3100, 243);
        tortue6 = new Tortue(3600, 243);
        tortue7 = new Tortue(3900, 243);
        tortue8 = new Tortue(4200, 243);
        tortue9 = new Tortue(4400, 243);

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

        piece1 = new Piece(402, 145);
        piece2 = new Piece(1202, 140);
        piece3 = new Piece(1272, 95);
        piece4 = new Piece(1342, 40);
        piece5 = new Piece(1650, 145);
        piece6 = new Piece(2650, 145);
        piece7 = new Piece(3000, 135);
        piece8 = new Piece(3400, 125);
        piece9 = new Piece(4200, 145);
        piece10 = new Piece(4600, 40);

        // Instancié l'objet "tabObjets"
        tabObjets = new ArrayList<ObjetJeu>();
        tabPieces = new ArrayList<Piece>();
        tabChamps = new ArrayList<Champ>();
        tabTortues = new ArrayList<Tortue>();

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

        this.tabPieces.add(this.piece1);
        this.tabPieces.add(this.piece2);
        this.tabPieces.add(this.piece3);
        this.tabPieces.add(this.piece4);
        this.tabPieces.add(this.piece5);
        this.tabPieces.add(this.piece6);
        this.tabPieces.add(this.piece7);
        this.tabPieces.add(this.piece8);
        this.tabPieces.add(this.piece9);
        this.tabPieces.add(this.piece10);

        // Initialisé contenue de tabChamps et tabTortues

        this.tabChamps.add(this.champ1);
        this.tabChamps.add(this.champ2);
        this.tabChamps.add(this.champ3);
        this.tabChamps.add(this.champ4);
        this.tabChamps.add(this.champ5);
        this.tabChamps.add(this.champ6);
        this.tabChamps.add(this.champ7);
        this.tabChamps.add(this.champ8);

        this.tabTortues.add(this.tortue1);
        this.tabTortues.add(this.tortue2);
        this.tabTortues.add(this.tortue3);
        this.tabTortues.add(this.tortue4);
        this.tabTortues.add(this.tortue5);
        this.tabTortues.add(this.tortue6);
        this.tabTortues.add(this.tortue7);
        this.tabTortues.add(this.tortue8);
        this.tabTortues.add(this.tortue9);

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

        // Detection contact mario avec un objet fixe si condition "mario.proche" valide
        for (int i = 0; i < this.tabObjets.size(); i++){
            // mario
            if (this.mario.procheObjet(this.tabObjets.get(i))){this.mario.contactObjet(this.tabObjets.get(i));}

            // Detection contact mario avec les champignons si condition valide
            for (int j = 0; j < this.tabChamps.size(); j++) {
                if (this.tabChamps.get(j).procheObjet(this.tabObjets.get(i))){this.tabChamps.get(j).contactObjet(this.tabObjets.get(i));}
            }

            // Detection contact mario avec les tortues si condition valide
            for (int j = 0; j < this.tabTortues.size(); j++) {
                if (this.tabTortues.get(j).procheObjet(this.tabObjets.get(i))){this.tabTortues.get(j).contactObjet(this.tabObjets.get(i));}
            }
        }


        // Detection contact mario avec les pieces
        for (int i = 0; i < this.tabPieces.size(); i++) {
            if (this.mario.procheObjet(this.tabPieces.get(i))) {
                if (this.mario.contactPiece(this.tabPieces.get(i))){
                    this.tabPieces.remove(i);
                }
            }
        }

        // Détection contact entre ennemi: Champignon avec Champignon ainsi que Champignon avec Tortue
        for (int i = 0; i < this.tabChamps.size(); i++){
            // Champignons
            for (int j = 0; j < this.tabChamps.size(); j++){
                if (j != i) {
                    if (this.tabChamps.get(j).procheObjet(this.tabChamps.get(i))) {this.tabChamps.get(j).contactObjet(this.tabChamps.get(i));}
                }
            }
            // Tortues
            for (int j = 0; j < this.tabTortues.size(); j++) {
                if (this.tabTortues.get(j).procheObjet(this.tabChamps.get(i))) {this.tabTortues.get(j).contactObjet(this.tabChamps.get(i));}
            }
        }

        // Détection inverse contact entre ennemi: Tortue avec Champignon ainsi que Tortue avec Tortue
        for (int i = 0; i < this.tabTortues.size(); i++){
            // Champignons
            for (int j = 0; j < this.tabChamps.size(); j++){
                if (this.tabChamps.get(j).procheObjet(this.tabTortues.get(i))) {this.tabChamps.get(j).contactObjet(this.tabTortues.get(i));}
            }
            // Tortues
            for (int j = 1; j < this.tabTortues.size(); j++) {
                if (j != i) {
                    if (this.tabTortues.get(j).procheObjet(this.tabTortues.get(i))) {this.tabTortues.get(j).contactObjet(this.tabTortues.get(i));}
                }
            }
        }




        // Détection contact de Mario avec les ennemis
        // Avec les champignons
        for (int i = 0; i < this.tabChamps.size(); i++) {
            if (this.mario.procheObjet(this.tabChamps.get(i)) & this.tabChamps.get(i).isVivant() == true) {
                this.mario.contactEnnemi(this.tabChamps.get(i));
            }
        }
        // Avec les tortues
        for (int i = 0; i < this.tabTortues.size(); i++) {
            if (this.mario.procheObjet(this.tabTortues.get(i)) && this.tabTortues.get(i).isVivant() == true) {
                this.mario.contactEnnemi(this.tabTortues.get(i));
            }
        }


        //  Gestion du placement de touts les objets fixe du jeu
        this.deplacementFond();
        if (this.xPos >= 0 && this.xPos <= 4430) {
            for (int i = 0; i < this.tabObjets.size(); i++) {this.tabObjets.get(i).deplacement();}
            for (int i = 0; i < this.tabPieces.size(); i++) {this.tabPieces.get(i).deplacement();}
            for (int i = 0; i < this.tabChamps.size(); i++) {this.tabChamps.get(i).deplacement();}
            for (int i = 0; i < this.tabTortues.size(); i++){this.tabTortues.get(i).deplacement();}
        }

        // Dessin de l'image de fond.
        g.drawImage(this.imgFond1, this.xFond1, 0, null);
        g.drawImage(this.imgFond2, this.xFond2, 0, null);

        // Dessin de l'image des objetJeu.
        for (int i = 0; i < this.tabObjets.size(); i++){
            g.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(),this.tabObjets.get(i).getY(), null);
        }

        // Dessin de l'image des Pieces du Jeu.
        for (int i = 0; i < this.tabPieces.size(); i++){
            g.drawImage(this.tabPieces.get(i).animePiece(), this.tabPieces.get(i).getX(),this.tabPieces.get(i).getY(), null);
        }

        // Dessin des image de départ et fin de jeu de mario
        g.drawImage(this.imgChateaux1, 10 - this.xPos, 95, null); // dessin de l'image du chatêaud de départ
        g.drawImage(this.imgDepart, 220 - this.xPos, 234, null); // dessin de l'image du panneaux de départ
        g.drawImage(this.imgDrapeau, 4650 - this.xPos, 115, null); // dessin de l'image du drapeau de fin
        g.drawImage(this.imgChateauFin, 5000 - this.xPos, 145, null); // dessin de l'image du chateau de fin

        // Dessin des images des personnages.

        // Image de mario
        if(this.mario.isSaut()) {
            g.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(),null);
        }else{
            g.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
        }

        // images des champignons
        for (int i = 0; i < this.tabChamps.size(); i++){
            if (this.tabChamps.get(i).isVivant() == true){
                g.drawImage(this.tabChamps.get(i).marche("champ", 45),this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY(), null);
            }else{ g.drawImage(this.tabChamps.get(i).meurt(),this.tabChamps.get(i).getX(), this.tabChamps.get(i).getY() + 20, null);}
        }

        // images des tortues
        for (int i = 0; i < this.tabTortues.size(); i++){
            if (this.tabTortues.get(i).isVivant() == true){
                g.drawImage(this.tabTortues.get(i).marche("tortue", 50), this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY(), null);
            }else{ g.drawImage(this.tabTortues.get(i).meurt(),this.tabTortues.get(i).getX(), this.tabTortues.get(i).getY() + 30, null);}
        }
    }
}
