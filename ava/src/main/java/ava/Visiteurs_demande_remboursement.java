package ava;

import java.util.Scanner;

public class Visiteurs_demande_remboursement {
    public static void main(int id_user) {

        
        Autre_Menu.messageMenuAffichage(10);

        Scanner montant_demande_remboursement = new Scanner(System.in);
        System.out.print("Montant du remboursement: ");
        Double var_montant_demande_remboursement = montant_demande_remboursement.nextDouble();

        Scanner text_raison = new Scanner(System.in);
        System.out.print("Raison: ");
        String var_text_raison = text_raison.nextLine().replaceAll("'", "\\\\'");
        
        Visiteurs_BDD_remboursements.ajouterP(id_user, var_montant_demande_remboursement, var_text_raison, id_user);
    }
}
