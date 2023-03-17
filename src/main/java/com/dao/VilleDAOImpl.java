package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	@Override
	public ArrayList<Ville>findAllVilles() {
		// TODO Auto-generated method stub
		System.out.println("findAllVilles");
		@SuppressWarnings("unused")
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		Ville ville = new Ville();
		ville.setCodePostal("49000");
		ville.setLigne("ligne");
		ville.setNomCommune("Saumur");
		listVille.add(ville);
		return listVille;
	}

}
