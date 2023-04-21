package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	public ArrayList<Ville> getInfoVilles(String codePostal);

	public Ville createVille(String code, String nom, String postal, String libelle, String ligne, String latitude,
			String longitude);
	
	public Ville modifyVille(String code, String nom, String postal, String libelle, String ligne, String latitude,
			String longitude);
	
	public Ville deleteVille(String code);
}
