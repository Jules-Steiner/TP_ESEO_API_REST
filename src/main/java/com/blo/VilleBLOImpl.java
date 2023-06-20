package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Coordonnee;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO; 

	public ArrayList<Ville> getInfoVilles(String code) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		if(code == null) {
			listVille = villeDAO.findAllVilles();
		} else {
			listVille = villeDAO.findVille(code);
		}

		return listVille;
	}

	public Ville createVille( 	 String codeCommune,
			
			String nomCommune,
			String codePostal,
			String libelleAcheminement,
			String ligne,
			String latitude,
			String longitude) {
		
		
		Ville ville = new Ville();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne(ligne);
		ville.setCoordonnee(new Coordonnee(Integer.parseInt(latitude), Integer.parseInt(longitude)));
		

		villeDAO.createVille(ville);

		return ville;
		
	}	

	public Ville modifyVille( 	String codeCommune,
								String nomCommune,
								String codePostal,
								String libelleAcheminement,
								String ligne,
								String latitude,
								String longitude) {
			
		if(getInfoVilles(codeCommune).size() == 1) {
			Ville ville = getInfoVilles(codeCommune).get(0);
			if(nomCommune != null) {
				ville.setNomCommune(nomCommune);
			}
			if(codePostal != null) {
				ville.setNomCommune(codePostal);
			}
			if(libelleAcheminement != null) {
				ville.setNomCommune(libelleAcheminement);
			}
			if(ligne != null) {
				ville.setNomCommune(ligne);
			}
			if(latitude != null && longitude != null) {
				ville.setCoordonnee(new Coordonnee(Integer.parseInt(latitude), Integer.parseInt(longitude)));
			}
			else if (latitude != null) {
				ville.setCoordonnee(new Coordonnee(Integer.parseInt(latitude), ville.getCoordonnee().getLongitude()));
			}
			else if (longitude != null) {
				ville.setCoordonnee(new Coordonnee(ville.getCoordonnee().getLatitude(), Integer.parseInt(longitude)));
			}
			
			villeDAO.updateVille(ville);

			return ville;
		}
		return null;
	}

	@Override
	public Ville deleteVille(String code) {
		if(getInfoVilles(code).size() == 1) {
			Ville ville = getInfoVilles(code).get(0);
			villeDAO.deleteVille(code);
			return ville;
		}
		return null;
	}	
}
