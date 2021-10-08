package com.codingdojo.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.services.DojoNinjaService;

@Controller
public class HomeController {
	
	private final DojoNinjaService dojoNinjaService;
	
	public HomeController(DojoNinjaService dojoNinjaService) {
		this.dojoNinjaService = dojoNinjaService; 
	}
	
	@RequestMapping("/")
	public String notAvailable() {
		return "redirect:/dojo";
	}
	
	@GetMapping("/dojo")
	public String index(@ModelAttribute("dojo")Dojo dojo, Model model) {
		return "index.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String processOfDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			this.dojoNinjaService.addDojo(dojo);
			return "redirect:/ninja";
		}
	}
	@GetMapping("/ninja")
	public String addNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoNinjaService.allDojos());
		return "ninja.jsp"; 
	}
	
	@PostMapping("/ninja/new")
	public String processAddNinja(@Valid @ModelAttribute("ninja")Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.dojoNinjaService.allDojos();
			model.addAttribute("alldojos",allDojos);
			return "ninja.jsp";
		}else {
			this.dojoNinjaService.addNinja(ninja);
			List<Dojo> allDojos = this.dojoNinjaService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "redirect:/dojos/{id}";
		}
	}
	
	@GetMapping("dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = this.dojoNinjaService.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "everyone.jsp";
	}
	
	


}
