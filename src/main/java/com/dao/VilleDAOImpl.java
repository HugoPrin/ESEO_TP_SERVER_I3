package com.dao;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	@Override
	public Ville findVille() {
		Ville ville  =  new Ville();
		ville.setCodeCommune("plop");
		return ville;
		
	}
}
