package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO{
	@Autowired
	private VilleDAO villeDAO;

	@Override
	public ArrayList<Ville> getInfoVilles(String codPostal) {
		// TODO Auto-generated method stub
		ArrayList<Ville> listVille = new ArrayList<>();
		listVille = villeDAO.findAllVilles();
		return listVille;
	}

	
}
