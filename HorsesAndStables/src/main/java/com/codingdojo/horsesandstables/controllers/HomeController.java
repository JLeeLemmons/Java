package com.codingdojo.horsesandstables.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.horsesandstables.models.Horse;
import com.codingdojo.horsesandstables.models.Stable;
import com.codingdojo.horsesandstables.services.HorseAndStableService;

@Controller
public class HomeController {
	private HorseAndStableService horseStableServ;
	
	public HomeController(HorseAndStableService horseStableServ) {
		this.horseStableServ = horseStableServ; 
	}
	
	//Show all horses
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allStables", horseStableServ.getAllStables());
		model.addAttribute("newHorse", new Horse());
		model.addAttribute("allHorses", horseStableServ.getAll());
		return "index.jsp";
	}
	
	
	//create a horse
	@PostMapping("/horse")
	public String create(@Valid @ModelAttribute("newHorse") Horse newHorse, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			model.addAttribute("allHorses", horseStableServ.getAll()); 
			return "index.jsp";
		}
		// otherwise create a horse and redirect back
		horseStableServ.create(newHorse);
		return "redirect:/";
	}
	
	//create a stable
	@GetMapping("/stable")
	public String stable(@ModelAttribute("addStable") Stable newStable) {
		return "newStable.jsp";
	}
	
	//creating a new stable
	@PostMapping("newStable")
	public String createStable(@Valid @ModelAttribute("addStable") Stable newStable, BindingResult result) {
		if(result.hasErrors()) {
			return "newStable.jsp";
		}
		horseStableServ.createStable(newStable);
		return "redirect:/";
	}
	
	//View one horse
	@GetMapping("/view/{id}")
	public String viewHorse(@PathVariable("id") Long id, Model model) {
		Horse horseToShow = this.horseStableServ.getHorse(id);
		model.addAttribute("thisHorse", horseToShow); 
		return "viewAHorse.jsp";
	}
	
	//View one stable         ------> w/ horses in that stable
	@GetMapping("/stable/{id}")
	public String viewStable(@PathVariable("id") Long id, Model model) {
		Stable stableToShow = this.horseStableServ.getStable(id);
		model.addAttribute("thisStable", stableToShow);
		return "viewAStable.jsp";
	}
	
	//show a horse for updating
	@GetMapping("/update/{id}")
	public String updateHorse(@PathVariable("id") Long id, @ModelAttribute("horse") Horse horse, Model model) {
		Horse horseToShow = this.horseStableServ.getHorse(id);
		model.addAttribute("thisHorse", horseToShow);
		return "updateHorse.jsp";
	}
	
	//updating horse
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
		public String update(@Valid @ModelAttribute("horse") Horse horse, BindingResult result) {
			if(result.hasErrors()) {
				return "updateHorse.jsp";
			}else {
				horseStableServ.updateHorse(horse);
				return "redirect:/";
			}
	}
	
	//deleting a horse
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.horseStableServ.deleteHorse(id);
		return "redirect:/"; 
	}
		
	
	
	
	
	
	

}
