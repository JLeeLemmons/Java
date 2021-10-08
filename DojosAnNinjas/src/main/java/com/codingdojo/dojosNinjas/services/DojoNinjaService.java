package com.codingdojo.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.repositories.DojoRepository;
import com.codingdojo.dojosNinjas.repositories.NinjaRepository;


@Service
public class DojoNinjaService {
	
	private final DojoRepository dojoRepo; 
	private final NinjaRepository ninjaRepo; 
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo; 
		this.ninjaRepo = ninjaRepo; 
	}
	
	
	public Dojo addDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo); 
	}
	
	public List<Dojo> allDojos(){
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	public Dojo getDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get(); 
		}else {
			return null; 
		}
	}

	public Ninja addNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja); 
	}
	
	public Optional<Ninja> getNinja(Long id){
		return this.ninjaRepo.findById(id); 
	}
	

}
