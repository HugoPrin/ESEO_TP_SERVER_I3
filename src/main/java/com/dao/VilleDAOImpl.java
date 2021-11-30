package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.DriverJDBC;
import com.dto.Ville;

//@Repository
public class VilleDAOImpl implements VilleDAO {
	
//	private DriverJDBC JDBCConf;
//
//	public VilleDAOImpl(DriverJDBC JDBCConf) {
//		this.JDBCConf = JDBCConf;
//	}	
//
//
////	@Override
////	public Ville findVille() {
////		Ville ville  =  new Ville("plop");
////		ville.setCodeCommune("plop");
////		return ville;
////		
////	}
//	
//	@Override
//	public ArrayList<Ville> findAllVilles(String param) {
//		ArrayList<Ville> listVille = new ArrayList<Ville>();
//
//		Connection connexion = null;
//		Statement statement = null;
//		ResultSet resultat = null;
//		try {
//			connexion = JDBCConf.getConnection();
//			statement = connexion.createStatement();
//			resultat = statement.executeQuery("SELECT * FROM ville_france ;");
//			
//			while (resultat.next()) {
//				Ville ville = new Ville(resultat.getString("Nom_Commune"));
//				//Ville ville = new Ville();
//				
//				//System.out.println(resultat.getString("Nom_Commune"));
//				listVille.add(ville);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return listVille;
//	}
//	
	private DriverJDBC JDBCConf;
	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	public VilleDAOImpl(DriverJDBC JDBCConf) {
		this.JDBCConf = JDBCConf;
	}

	@Override
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = JDBCConf.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM ville_france");
			
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getString(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),resultat.getString(5),resultat.getString(6),resultat.getString(7));
				//Ville ville = new Ville();
				
				//System.out.println(resultat.getString("Nom_Commune"));
				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listVille;
	}
	
	@Override
	public ArrayList<Ville> findSpecificVille(String nom_Commune) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultat = null;
		try {
			connexion = JDBCConf.getConnection();
			String requeteSql = "SELECT * FROM ville_france WHERE Nom_Commune=?";
			preparedStmt = connexion.prepareStatement(requeteSql);
			preparedStmt.setString(1, nom_Commune);
			resultat = preparedStmt.executeQuery();
			
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getString(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),resultat.getString(5),resultat.getString(6),resultat.getString(7));
				//Ville ville = new Ville();
				
				//System.out.println(resultat.getString("Nom_Commune"));
				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;
		
	}
	
	
	@Override
	public void addVille(Ville ville) {
		Connection connexion = null;
		//Statement statement = null;
		//ResultSet resultat = null;
		PreparedStatement preparedStmt = null;
		
		try {
			connexion = JDBCConf.getConnection();
			
			String requeteSql = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES (?,?,?,?,?,?,?)";
			preparedStmt = connexion.prepareStatement(requeteSql);
			preparedStmt.setString(1, ville.getCodeCommune());
			preparedStmt.setString(2, ville.getNom_commune());
			preparedStmt.setString(3, ville.getCode_postal());
			preparedStmt.setString(4, ville.getLibelle_acheminement());
			preparedStmt.setString(5, ville.getLigne_5());
			preparedStmt.setString(6, ville.getLatitude());
			preparedStmt.setString(7, ville.getLongitude());
			
			try {
				preparedStmt.executeUpdate();
				preparedStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void updateVille(Ville ville, String codeCommune){
		Connection connexion = null;
		//Statement statement = null;
		//ResultSet resultat = null;
		PreparedStatement preparedStmt = null;
		try {
			connexion = JDBCConf.getConnection();
			preparedStmt = connexion.prepareStatement("UPDATE ville_france SET Code_Commune_INSEE = ?, Nom_Commune = ?, Code_postal = ?, Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ? where Code_Commune_INSEE = ?");    
			preparedStmt.setString(1, ville.getCodeCommune());
			preparedStmt.setString(2, ville.getNom_commune());
			preparedStmt.setString(3, ville.getCode_postal());
			preparedStmt.setString(4, ville.getLibelle_acheminement());
			preparedStmt.setString(5, ville.getLigne_5());
			preparedStmt.setString(6, ville.getLatitude());
			preparedStmt.setString(7, ville.getLongitude());
			preparedStmt.setString(8, codeCommune);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteVille(String code_commune_INSEE) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;

		try {
			connexion = JDBCConf.getConnection();
			preparedStmt = connexion.prepareStatement("DELETE FROM ville_france WHERE Code_commune_INSEE=?");
			preparedStmt.setString(1, code_commune_INSEE);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
