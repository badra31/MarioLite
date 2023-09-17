package com.badra.ObjetsDuJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BlocPierre extends ObjetJeu{

    ////////  VARIABLES  //////////

    private ImageIcon icoBlocPierre;
    private Image imgBlocPierre;

    ////////  CONSTRUCTEUR  //////////

    public BlocPierre( int x, int y) {
        super(x, y, 30, 30);
        this.icoBlocPierre = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/bloc.png")));
        this.imgBlocPierre = icoBlocPierre.getImage();
    }

    ////////  GETTERS  //////////

    public Image getImgBlocPierre() {return imgBlocPierre;}

    ////////  SETTERS  //////////


    ////////  METHODES  //////////
}
