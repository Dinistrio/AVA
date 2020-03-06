package ava;

public final class AVA {

    public static void main(final String[] args) {
        systemDeConnexion(); // Système complet d'authentification
    }

    public static void systemDeConnexion() { // Ensemble des manoeuvres nécessaires à la connexion
        menu.messageMenuAffichage(1);
        menu.messageMenuAffichage(2);
        baseDeDonneeConnexion.connexionALaBDD();
    }
}