package com.configue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.Ville;

public class JDBCConfigue{

	private Connection connexion;

    
    public List<Ville> listVille() {
        List<Ville> villes = new ArrayList<Ville>();
        
        Statement statement = null;
        ResultSet resultat = null;
        loadDatabase();
        
        try {
        
	        
	        statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT Nom_Commune FROM ville_france;");
            // Récupération des données
            
            while (resultat.next()) {
                String nom = resultat.getString("Nom_commune");
             
                
                Ville ville = new Ville();
                ville.setNomCommune(nom);
                
                villes.add(ville);
        	}
        }
        catch (SQLException e) {
        }
        finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return villes;
	
    }
    
     private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
        	connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/twic", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
