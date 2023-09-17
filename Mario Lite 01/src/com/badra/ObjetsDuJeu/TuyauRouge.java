package com.badra.ObjetsDuJeu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TuyauRouge extends ObjetJeu{

    ////////  VARIABLES  ///////////



    ////////  CONSTRUCTEUR  ///////////

    public TuyauRouge( int x, int y) {
        super( x, y, 43, 65);
        super.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/tuyauRouge.png")));
        super.imgObjet = icoObjet.getImage();
    }

    ////////  GETTERS  //////////



    ////////  SETTERS  //////////


    ////////  METHODES  //////////
}
