package com.codingdojo.horsesandstables.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.horsesandstables.models.Horse;
import com.codingdojo.horsesandstables.models.Stable;
import com.codingdojo.horsesandstables.repositories.HorseRepository;
import com.codingdojo.horsesandstables.repositories.StableRepository;

@Service
public class HorseAndStableService {
	private HorseRepository horseRepo;
	private StableRepository stableRepo; 
	
	public HorseAndStableService (HorseRepository horseRepo, StableRepository stableRepo) {
		this.horseRepo = horseRepo;
		this.stableRepo = stableRepo; 
	}
	
	//horse section
	
	//See all horses
	public ArrayList<Horse> getAll(){
		return (ArrayList<Horse>) horseRepo.findAll(); 
	}
	
	//create a horse
	public Horse create(Horse newHorse) {
		return horseRepo.save(newHorse); 
	}
	
	//update a horse
	public Horse updateHorse(Long id, String name, String horseColor, String sizeOfHorse, Integer numOfFriends) {
		Horse toUpdate = this.horseRepo.findById(id).orElse(null);
		if(toUpdate == null) {
			return null; 
		}else {
			toUpdate.setName(name);
			toUpdate.setHorseColor(horseColor);
			toUpdate.setSizeOfHorse(sizeOfHorse);
			toUpdate.setNumOfFriends(numOfFriends);
			
			return this.horseRepo.save(toUpdate); 
		}
	}
	
	public Horse updateHorse(Horse horse) {
		return this.horseRepo.save(horse); 
	}
	
	
	//view an individual horse
	public Horse getHorse(Long id) {
		Optional<Horse> optionalHorse = this.horseRepo.findById(id);
		if(optionalHorse.isPresent()) {
			return optionalHorse.get();
		}else {
			return null; 
		}
	}
	
	//delete a horse
	public void deleteHorse(Long id) {
		this.horseRepo.deleteById(id);
	}
	
	
	//stable section
	
	//create a stable
	public Stable createStable(Stable newStable) {
		return stableRepo.save(newStable); 
	}
	
	//get all stables
//	public List<Stable> getAllStables(){
//		return stableRepo.findAll();
//	}
	public ArrayList<Stable> getAllStables(){
		return (ArrayList<Stable>) stableRepo.findAll(); 
	}
	
	//get individual stable
	public Stable getStable(Long id) {
		Optional<Stable> optionalStable = this.stableRepo.findById(id);
		if(optionalStable.isPresent()) {
			return optionalStable.get();
		}else {
			return null; 
		}
	}
	

}
