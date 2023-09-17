package com.badra.ObjetsDuJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BlocPierre extends ObjetJeu{

    ////////  VARIABLES  //////////



    ////////  CONSTRUCTEUR  //////////

    public BlocPierre( int x, int y) {
        super(x, y, 30, 30);
        super.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/bloc.png")));
        super.imgObjet = icoObjet.getImage();
    }

    ////////  GETTERS  //////////



    ////////  SETTERS  //////////


    ////////  METHODES  //////////
}
