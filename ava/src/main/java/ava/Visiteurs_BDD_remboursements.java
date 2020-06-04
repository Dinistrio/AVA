package ava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Visiteurs_BDD_remboursements {

    static String dbURL = "jdbc:mysql://localhost:3306/mabddtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";
    static Statement st;
    static Statement st2;
    static ResultSet rst;
    static ResultSet rst2;

    protected static Integer montant_remboursement;
    protected static Integer id_perso_ok_remboursement;
    protected static Integer accepter_remboursement;
    protected static String accept = "";
    protected static String nom_user;
    protected static String prenom_user;
    protected static String nom_user2;
    protected static String prenom_user2;
    protected static String raison_remboursement;
    protected static String date_remboursement;
    protected static String date_remboursement_month;
    

    public static void connexionALaBDD(final int id_user) {

        Calendar cal = Calendar.getInstance();
        String CurDate = (new SimpleDateFormat("MM").format(cal.getTime()));

        try {

            final Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Si connexion effectuée avec succès

            }

        } catch (final SQLException ex) {
            Autre_Menu.messageMenuAffichage(4); // Afficher le menu "ÉCHEC DE CONNEXION"
        }

        try {

            Autre_Menu.messageMenuAffichage(8);

            final Connection conn = DriverManager.getConnection(dbURL, username, password); // Initialisation de la
                                                                                            // connexion

            st = conn.createStatement();
            st2 = conn.createStatement();

            // Éxecusion de la requête SQL ->
            rst = st.executeQuery(
                    "SELECT utilisateurs.nom_user, utilisateurs.prenom_user, remboursement.montant_remboursement, remboursement.id_perso_ok_remboursement, remboursement.accepter_remboursement, remboursement.raison_remboursement, remboursement.date_ask_remboursement FROM remboursement JOIN utilisateurs on remboursement.id_user_ask_remboursement = utilisateurs.id_user WHERE id_user_ask_remboursement = "
                            + id_user);

            while (rst.next()) {

                nom_user = rst.getString("nom_user");
                prenom_user = rst.getString("prenom_user");
                montant_remboursement = rst.getInt("montant_remboursement");
                id_perso_ok_remboursement = rst.getInt("id_perso_ok_remboursement");
                accepter_remboursement = rst.getInt("accepter_remboursement");
                raison_remboursement = rst.getString("raison_remboursement");

                SimpleDateFormat formater = null;
                formater = new SimpleDateFormat("dd-MM-yyyy");
                date_remboursement = formater.format(rst.getDate("date_ask_remboursement"));

                formater = new SimpleDateFormat("MM");

                date_remboursement_month = formater.format(rst.getDate("date_ask_remboursement"));

                rst2 = st2.executeQuery(
                        "SELECT nom_user, prenom_user FROM utilisateurs WHERE id_user = " + id_perso_ok_remboursement);

                while (rst2.next()) {
                    nom_user2 = rst2.getString("nom_user");
                    prenom_user2 = rst2.getString("prenom_user");
                }

                if (accepter_remboursement != 0) {
                    if (CurDate.equals(date_remboursement_month)){
                        System.out.println("[ Remboursement demandé par " + nom_user + " " + prenom_user
                            + " pour un montant de " + montant_remboursement + "€ le " + date_remboursement + " pour la raison suivante: \"" + raison_remboursement
                            + "\". Accepté par " + nom_user2 + " " + prenom_user2 + " ]");
                    }
                }

            }
            final Scanner reload = new Scanner(System.in);
            System.out.println("");
            System.out.print("Appuyez sur une touche pour continuer...");
            final String reloadWait = reload.nextLine();
            Visiteurs_Launcher.main(id_user);

        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void ajouterP(final int id_user_ask_remboursement, final double montant, final String raison,
            final int id_user) {
        try {

            final String query = "INSERT INTO remboursement (id_remboursement, id_user_ask_remboursement, montant_remboursement, id_perso_ok_remboursement, accepter_remboursement, raison_remboursement) VALUES (NULL,'" + id_user_ask_remboursement + "', '"
                    + montant + "', '0', '0', '" + raison + "')";

            final Connection conn = DriverManager.getConnection(dbURL, username, password);
            st = conn.createStatement();
            st.executeUpdate(query);
            final Scanner reload = new Scanner(System.in);
            System.out.println("");
            System.out.print("Appuyez sur une touche pour continuer...");
            final String reloadWait = reload.nextLine();
            Visiteurs_Launcher.main(id_user);

        } catch (final SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
