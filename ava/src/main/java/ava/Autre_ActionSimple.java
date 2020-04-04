package ava;

import java.io.Console;
import java.util.Scanner;

public class Autre_ActionSimple {

    static String scannerLancement(int methode) { // Scanner avec choix de méthode
        if (methode == 1) { // méthode simple avec Scanner
            Scanner identifiant_ou_mdp = new Scanner(System.in);
            System.out.print("Identifiant: ");
            String var_identifiant_ou_mdp = identifiant_ou_mdp.nextLine();
            return var_identifiant_ou_mdp;
        } else if (methode == 2) { // méthode plus complexe avec charactères invisibles
            Console cons = System.console();
            char[] passwd = cons.readPassword("Mot de passe: ");
            String var_identifiant_ou_mdp = String.valueOf(passwd);
            return var_identifiant_ou_mdp;
        } else {
            return "";
        }

    }

    public static void nettoyerLePrompt() {
        System.out.print("\033[H\033[2J"); // Print d'un ASCII qui clean le prompt
    }

    public static void sleep(int timeMilliseconde) { // fonction qui Slepp x Milliseconde le programme
        try {
            Thread.sleep(timeMilliseconde);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
