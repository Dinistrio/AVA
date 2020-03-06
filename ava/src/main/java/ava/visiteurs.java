package ava;

import java.util.Scanner;

public class visiteurs {
    public static void main(int id_user) {
        actionsVisteurs();
        visiteursInstructions(id_user);
    }

    public static void actionsVisteurs() {
        menu.messageMenuAffichage(5);
    }

    public static void visiteursInstructions(int id_user) {
        System.out.println("1 - Afficher les remboursements.");
        System.out.println("2 - Demander un remboursement.");
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
                    remboursement.main(id_user);
                }
                if (y == 2) {
                    demande_remboursement.main(id_user);
                }
            } catch (NumberFormatException e) {
                System.out.println("/!\\ Vous devez entrer un nombre. /!\\");
            }
        }

    }
}
