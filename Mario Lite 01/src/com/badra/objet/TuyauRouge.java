package com.badra.objet;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TuyauRouge extends ObjetJeu{

    ////////  VARIABLES  ///////////

    private ImageIcon icoTuyauRouge;
    private Image imgTuyauRouge;

    ////////  CONSTRUCTEUR  ///////////

    public TuyauRouge( int x, int y) {
        super( x, y, 43, 65);
        this.icoTuyauRouge = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/tuyauRouge.png")));
        this.imgTuyauRouge = icoTuyauRouge.getImage();
    }

    ////////  GETTERS  //////////

    public Image getImgTuyauRouge() {return imgTuyauRouge;}

    ////////  SETTERS  //////////


    ////////  METHODES  //////////
}
