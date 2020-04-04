package ava;

public class Autre_Menu {
    public static void messageMenuAffichage(int choix) {
        if (choix == 1) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§           LANCEMENT DE AVA 1.0              §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            Autre_ActionSimple.sleep(1000);
        } else if (choix == 2) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§          IDENTIFICATION AVA 1.0             §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
        } else if (choix == 3) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§       CONNEXION EFFECTUÉE AVEC SUCCÈS       §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            Autre_ActionSimple.sleep(1000);
        } else if (choix == 4) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§              ÉCHEC DE CONNEXION             §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            Autre_ActionSimple.sleep(1000);
            Autre_ActionSimple.nettoyerLePrompt();
        } else if (choix == 5) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§                  VISITEURS                  §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            Autre_ActionSimple.sleep(1000);
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println();
        } else if (choix == 6) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§                  COMPTABLES                 §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            Autre_ActionSimple.sleep(1000);
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println();
        } else if (choix == 7) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§              ANOMALIE DÉTECTÉE              §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            Autre_ActionSimple.sleep(1000);
            Autre_ActionSimple.nettoyerLePrompt();
        } else if (choix == 8) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§               REMBOURSEMENTS                §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            Autre_ActionSimple.sleep(1000);
            System.out.println();
        }else if (choix == 9) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§        REMBOURSEMENTS FORFAITAIRES          §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            Autre_ActionSimple.sleep(1000);
            System.out.println();
        }else if (choix == 10) {
            Autre_ActionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§       REMBOURSEMENTS HORS-FORFAITAIRES      §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            Autre_ActionSimple.sleep(1000);
            System.out.println();
        }
    }
}
