package com.blo;

import java.util.ArrayList;

import com.dto.Ville;


public interface VilleBLO {
	
	ArrayList<Ville> getALLInfovilles(String codeCommune);
	
	void addVille(Ville ville);
	
	void deleteVille(String code_commune_INSEE);
	
	void updateVille(Ville ville, String codeCommune);
}
