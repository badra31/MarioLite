package com.badra.jeu;

public class Chrono implements Runnable{

    ////////  VARIABLES  ///////////
    private final int PAUSE = 3; // Temps d'attente entre deux tours de boucle de 3ms

    ////////  METHODES  ///////////
    @Override
    public void run() {

        while (true) {
            Main.scene.repaint();  // Appel de la méthode PainComponent() de l'objet scene

            try {
                Thread.sleep(PAUSE);  // Temps de pause du flux
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
