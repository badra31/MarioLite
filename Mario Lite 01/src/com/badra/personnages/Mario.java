package com.badra.personnages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Mario extends Personnage{

    ///////  VARIABLES  ///////
    private Image imgMario;
    private ImageIcon icoMario;

    ///////  CONSTRUCTEUR  /////
    public Mario(int x, int y) {

        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/marioArretDroite.png")));
        this.imgMario = this.icoMario.getImage();
    }

    ////////  GETTERS  //////////
    public Image getImgMario() {return imgMario;}


    ///////  SETTERS  /////////
}
