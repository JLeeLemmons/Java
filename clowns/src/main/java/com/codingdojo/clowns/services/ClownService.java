package com.codingdojo.clowns.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.clowns.models.Circus;
import com.codingdojo.clowns.models.Clown;
import com.codingdojo.clowns.repositories.CircusRepository;
import com.codingdojo.clowns.repositories.ClownRepository;

@Service
public class ClownService {

	private ClownRepository clownRepo;
	private CircusRepository circRepo; 
	
	public ClownService(ClownRepository clownRepo, CircusRepository circRepo) {
		this.clownRepo = clownRepo;
		this.circRepo = circRepo; 
	}
	
	
	//CIRCUS AREA
	
	//get all circuses
	public List<Circus> getAllCircus(){
		return circRepo.findAll();
	}
	
	//create a circus
	public Circus createCirc(Circus newCircus) {
		return circRepo.save(newCircus);
	}
	
	//get individual circus
	public Circus getCircus(Long id) {
		Optional<Circus> optionalCircus = this.circRepo.findById(id);
		if(optionalCircus.isPresent()) {
			return optionalCircus.get();
		}else {
			return null; 
		}
}
	
	
	
	//CLOWN AREA
	
	//see all of the clowns
	public ArrayList<Clown> getAll() {
		return (ArrayList<Clown>) clownRepo.findAll();
	}
	
	//creates a clown
	public Clown create(Clown newClown) {
		return clownRepo.save(newClown);
	}
	
	//delete a clown
	public void deleteClown(Long id) {
		this.clownRepo.deleteById(id);
	}
	
	//get a individual clown by id
	public Clown getClown(Long id) {
		Optional<Clown> optionalClown = this.clownRepo.findById(id);
		if(optionalClown.isPresent()) {
			return optionalClown.get();
		}else {
			return null; 
		}
}
	
	//Update a clown w/ new values being sent to Repo. 
	public Clown updateClown(Long id, String name, String shoeColor, Integer pinsJuggled, Integer childrenLaughed) {
		Clown toUpdate = this.clownRepo.findById(id).orElse(null);
		if(toUpdate == null) {
			return null;
		}else {
			toUpdate.setName(name);
			toUpdate.setShoeColor(shoeColor);
			toUpdate.setPinsJuggle(pinsJuggled);
			toUpdate.setChildrenLaughed(childrenLaughed);
			
			return this.clownRepo.save(toUpdate); 
		}
		
	}
	
	//Updating a clown, so values update 
	public Clown updateClown(Clown clown) {
		return this.clownRepo.save(clown); 
	}

}
