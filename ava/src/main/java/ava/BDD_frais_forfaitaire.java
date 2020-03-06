package ava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD_frais_forfaitaire {

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

    public static void connexionALaBDD(int id_user) {

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Si connexion effectuée avec succès

            }

        } catch (SQLException ex) {
            menu.messageMenuAffichage(4); // Afficher le menu "ÉCHEC DE CONNEXION"
        }

        try {

            menu.messageMenuAffichage(8);

            Connection conn = DriverManager.getConnection(dbURL, username, password); // Initialisation de la connexion

            st = conn.createStatement();
            st2 = conn.createStatement();

            // Éxecusion de la requête SQL ->
            rst = st.executeQuery(
                    "SELECT utilisateurs.nom_user, utilisateurs.prenom_user, remboursement.montant_remboursement, remboursement.id_perso_ok_remboursement, remboursement.accepter_remboursement FROM remboursement JOIN utilisateurs on remboursement.id_user_ask_remboursement = utilisateurs.id_user WHERE id_user_ask_remboursement = "
                            + id_user);

            while (rst.next()) {

                nom_user = rst.getString("nom_user");
                prenom_user = rst.getString("prenom_user");
                montant_remboursement = rst.getInt("montant_remboursement");
                id_perso_ok_remboursement = rst.getInt("id_perso_ok_remboursement");
                accepter_remboursement = rst.getInt("accepter_remboursement");

                rst2 = st2.executeQuery(
                        "SELECT nom_user, prenom_user FROM utilisateurs WHERE id_user = " + id_perso_ok_remboursement);

                while (rst2.next()) {
                    nom_user2 = rst2.getString("nom_user");
                    prenom_user2 = rst2.getString("prenom_user");
                }

                if (accepter_remboursement != 0) {
                    System.out.println("[ Remboursement demandé par " + nom_user + " " + prenom_user
                            + " pour un montant de " + montant_remboursement + "€. Accepté par " + nom_user2 + " "
                            + prenom_user2 + " ]");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void ajouterP(int id_user_ask_remboursement, double montant, String raison) {
        try {

            String query = "INSERT INTO remboursement VALUES (NULL,'" + id_user_ask_remboursement + "', '" + montant
                    + "', '0', '0', '" + raison + "')";

            Connection conn = DriverManager.getConnection(dbURL, username, password);
            st = conn.createStatement();
            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
