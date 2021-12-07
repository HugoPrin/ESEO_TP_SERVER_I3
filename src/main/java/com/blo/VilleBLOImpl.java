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


	public ArrayList<Ville> getALLInfovilles(String codeCommune) {
		init();
		ArrayList<Ville> listVille;
		if (codeCommune != null) {
			listVille = villeDAO.findSpecificVille(codeCommune);
		}
		else {
			listVille = villeDAO.findAllVilles();
			System.out.println("Nombre de ville récupérée(s) : " + listVille.size());
			
		}
		return listVille;
		
	}
	
	public void addVille(Ville ville) {
		init();
		villeDAO.addVille(ville);
	}
	
	public void deleteVille(String code_commune_INSEE) {
		init();
		villeDAO.deleteVille(code_commune_INSEE);
	}
	
	public void updateVille(Ville ville, String codeCommune) {
		init();
		villeDAO.updateVille(ville, codeCommune);
	}

}

