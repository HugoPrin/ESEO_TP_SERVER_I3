package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
//	Ville findVille();

	ArrayList<Ville> findAllVilles();

	void addVille(Ville ville);
	
	void deleteVille(String code_commune_INSEE);

	ArrayList<Ville> findSpecificVille(String nom_Commune);
	
	void updateVille(Ville ville, String codeCommune);
}
