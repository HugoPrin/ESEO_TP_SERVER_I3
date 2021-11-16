package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
	
	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	private String codeCommune;
	
	/*
	 * public String getCodeCommune() { return codeCommune; }
	 * 
	 * public void setCodeCommune(String codeCommune) { this.codeCommune =
	 * codeCommune; }
	 */

}
