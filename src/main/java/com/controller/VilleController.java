

package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLOService;
//	
//	@RequestMapping(value="/ville", method=RequestMethod.GET)
//	public String get(@RequestParam(required = false, value="codePostal") String codePostal) {
//		System.out.println("get : " + codePostal);
//		return "test";
//	}
	
	
	@RequestMapping(value="/ville", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal) {
	    ArrayList<Ville> ville = villeBLOService.getInfoVilles(codePostal); // Exemple de récupération de ville depuis un service BLO
	    
	        return ville; // La ville sera automatiquement sérialisée en JSON grâce à Jackson
	}

}
