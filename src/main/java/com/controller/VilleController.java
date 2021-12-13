package com.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController //veut dire que la classe est un controller
public class VilleController {
	private static final Logger logger = LoggerFactory.getLogger(VilleController.class);
	@Autowired
	private VilleBLO villeService;
	
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET) 
	@ResponseBody public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codeCommune") String codeCommune) { 
		return villeService.getALLInfovilles(codeCommune);
	
	}

	
	
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody Ville ville) {
		villeService.addVille(ville);
		logger.info("ville ajoutée");
	}
	
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	public void appelDelete(@RequestParam(required = true, value = "code_commune_INSEE") String code_commune_INSEE) {
		System.out.println("Appel DELETE");
		villeService.deleteVille(code_commune_INSEE);
		logger.info("ville supprimée");	
	}
	
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	public void appelPut(@RequestBody Ville ville, @RequestParam(required = true, value = "codeCommune") String codeCommune) {
		System.out.println("Appel PUT");
		villeService.updateVille(ville, codeCommune);
		logger.info("ville modifiée");
	}
}

