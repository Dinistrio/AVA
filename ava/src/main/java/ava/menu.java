package ava;

public class menu {
    public static void messageMenuAffichage(int choix) {
        if (choix == 1) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§           LANCEMENT DE AVA 1.0              §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            actionSimple.sleep(1000);
        } else if (choix == 2) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§          IDENTIFICATION AVA 1.0             §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
        } else if (choix == 3) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§       CONNEXION EFFECTUÉE AVEC SUCCÈS       §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            actionSimple.sleep(1000);
        } else if (choix == 4) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§              ÉCHEC DE CONNEXION             §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            actionSimple.sleep(1000);
            actionSimple.nettoyerLePrompt();
        } else if (choix == 5) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§                  VISITEURS                  §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            actionSimple.sleep(1000);
            actionSimple.nettoyerLePrompt();
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println();
        } else if (choix == 6) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§                  COMPTABLES                 §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            actionSimple.sleep(1000);
            actionSimple.nettoyerLePrompt();
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println();
        } else if (choix == 7) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§              ANOMALIE DÉTECTÉE              §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println();
            actionSimple.sleep(1000);
            actionSimple.nettoyerLePrompt();
        } else if (choix == 8) {
            actionSimple.nettoyerLePrompt();
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            System.out.println("§               REMBOURSEMENTS                §");
            System.out.println("§ § § § § § § § § § § § § § § § § § § § § § § §");
            actionSimple.sleep(1000);
            System.out.println();
        }
    }
}
