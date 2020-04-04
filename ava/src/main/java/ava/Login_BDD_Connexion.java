package ava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login_BDD_Connexion {

    static String dbURL = "jdbc:mysql://localhost:3306/mabddtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";
    static Statement st;
    static ResultSet rst;
    static String enteredPassword;

    protected static String identifiant_user;
    protected static String mot_de_pass_user;
    protected static Integer grade_user;
    protected static Integer id_user;

    public static void connexionALaBDD() {

        String identifiant = Autre_ActionSimple.scannerLancement(1); // Scanner classique qui demande l'identifiant.
        String mot_de_pass = Autre_ActionSimple.scannerLancement(2); // Scanner avec charactères entrées cachés

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Si connexion effectuée avec succès

            }

        } catch (SQLException ex) {
            Autre_Menu.messageMenuAffichage(4); // Afficher le menu "ÉCHEC DE CONNEXION"
        }

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password); // Initialisation de la connexion

            st = conn.createStatement();

            // Éxecusion de la requête SQL ->
            rst = st.executeQuery(
                    "SELECT id_user, identifiant_user, mot_de_pass_user, grade_user FROM utilisateurs WHERE identifiant_user LIKE '%"
                            + identifiant + "%' LIMIT 1");

            while (rst.next()) {

                identifiant_user = rst.getString("identifiant_user");
                mot_de_pass_user = rst.getString("mot_de_pass_user");
                grade_user = rst.getInt("grade_user");
                id_user = rst.getInt("id_user");

            }

            String originalString = mot_de_pass_user;
            String decryptedString = Autre_Crypteur.decrypt(originalString);
            //String encryptString = crypteur.encrypt(mot_de_pass);

           if (decryptedString.equals(mot_de_pass) && identifiant.equals(identifiant_user)) { // Vérification si le mot
                                                                                               // de passe entré est le
                                                                                               // bon
                Autre_Menu.messageMenuAffichage(3); // Afficher que la connexion a bien était effectuée

                if (grade_user == 1) { // action quand simple utilisateurs
                    Visiteurs_Launcher.main(id_user);
                } else if (grade_user == 2) { // action quand comptable
                    Comptables_Launcher.main();
                } else {
                    Autre_Menu.messageMenuAffichage(7);
                    System.exit(0);
                }

            } else {
                Autre_Menu.messageMenuAffichage(4); // Afficher que la connexion a échouée
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
