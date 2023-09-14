package com.badra.jeu;

import javax.swing.*;

public class Main {

    //Initialisation de la variable scene.
    public static Scene scene;

    public static void main(String[] args) {

        // Création de la fenêtre de l'application
        JFrame frame = new JFrame("Jeu Mario lite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 360);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);

        //Instanciation de l'objet scène.
        scene = new Scene();

        // On associe la scene à la fenêtre(Frame) de l'application.
        frame.setContentPane(scene);
        frame.setVisible(true);
    }
}
