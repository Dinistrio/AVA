package ava;

import java.util.Scanner;

public class Visiteurs_Launcher {
    public static void main(int id_user) {
        actionsVisteurs();
        visiteursInstructions(id_user);
    }

    public static void actionsVisteurs() {
        Autre_Menu.messageMenuAffichage(5);
    }

    public static void visiteursInstructions(int id_user) {
        System.out.println("1 - Afficher les remboursements.");
        System.out.println("2 - Demander un remboursement hors forfait.");
        System.out.println("3 - Demander un remboursement forfaitaire.");
        System.out.println("4 - Fermer le programme.");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        choixInstruction(id_user);
    }

    public static void choixInstruction(int id_user) {
        int y;
        Scanner input = new Scanner(System.in);
        boolean isNumber = true;
        System.out.print("Votre choix: ");
        while (isNumber) {
            try {
                y = (int) Integer.valueOf(input.next());
                isNumber = false; // execute que si valueOf ne lance pas d'exception
                if (y == 1) {
                    Visiteurs_BDD_remboursements.connexionALaBDD(id_user);
                }
                if (y == 2) {
                    Visiteurs_demande_remboursement.main(id_user);
                }
                if (y == 3) {
                    Visiteurs_demande_remboursement_frais_forfait.main(id_user);
                }
                if (y == 4) {
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.out.println("/!\\ Vous devez entrer un nombre. /!\\");
            }
        }
        
    }
}
