package com.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.config.DriverJDBC;
import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	private VilleDAO villeDAO;

	public void init(){
		DriverJDBC JDBCConf = DriverJDBC.getInstance();
		this.villeDAO = JDBCConf.getVilleDao();
	}


	public ArrayList<Ville> getALLInfovilles(String nom_Commune) {
		init();
		ArrayList<Ville> listVille;
		if (nom_Commune != null) {
			listVille = villeDAO.findSpecificVille(nom_Commune);
		}
		else {
			listVille = villeDAO.findAllVilles();
			System.out.println("Nombre de ville récupérée(s) : " + listVille.size());
			
		}
		return listVille;
		
	}
	
	public void addVille(Ville ville) {
		villeDAO.addVille(ville);
	}
	
	public void deleteVille(String code_commune_INSEE) {
		villeDAO.deleteVille(code_commune_INSEE);
	}

}

