package com.badra.affichage;

public class Score {

    ////////  VARIABLES  ///////////

    private  final int NBRE_TOTAL_PIECES = 10;
    private int nbrePieces;

    ////////  CONSTRUCTEUR  /////////

    public Score() {
        this.nbrePieces = 0;
    }

    ////////  GETTERS  /////////

    public int getNBRE_TOTAL_PIECES() {
        return NBRE_TOTAL_PIECES;
    }

    public int getNbrePieces() {
        return nbrePieces;
    }

    ////////  SETTERS  //////////

    public void setNbrePieces(int nbrePieces) {
        this.nbrePieces = nbrePieces;
    }
}
