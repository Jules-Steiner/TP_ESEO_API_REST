package com.dto;

public class Ville {
	
	private String codeCommune;
	private String nomCommune;
	private String ligne;
	private String codePostal;
	
		
	
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

}
