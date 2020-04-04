package ava;

public final class AVA {

    public static void main(final String[] args) {
        systemDeConnexion(); // Système complet d'authentification
    }

    public static void systemDeConnexion() { // Ensemble des manoeuvres nécessaires à la connexion
        Autre_Menu.messageMenuAffichage(1);
        Autre_Menu.messageMenuAffichage(2);
        Login_BDD_Connexion.connexionALaBDD();
    }
}