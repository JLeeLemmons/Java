package com.codingdojo.clowns;

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

import com.codingdojo.clowns.models.Circus;
import com.codingdojo.clowns.models.Clown;
import com.codingdojo.clowns.services.ClownService;

@Controller
public class HomeController {

	private ClownService clownServ;
	
	public HomeController(ClownService clownServ) {
		this.clownServ = clownServ;
	}
	
	//showing all clowns
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allCircus", clownServ.getAllCircus());
		model.addAttribute("newClown", new Clown()); // binds to form helper in index.jsp
		model.addAttribute("allClowns", clownServ.getAll()); // displays all clowns
		return "index.jsp";
	}
	
	//Making a new circus
	@GetMapping("/circus")
	public String circus(@ModelAttribute("addCircus") Circus newCircus) {
		return "newCircus.jsp";
	}
	
	//creating a new circus
	@PostMapping("newCircus")
	public String createCirc(@Valid @ModelAttribute("addCircus") Circus newCircus, BindingResult result) {
		if(result.hasErrors()) {
			return"newCircus.jsp";
		}
		clownServ.createCirc(newCircus);
		return "redirect:/";
	}
	
	//display one circus
	@GetMapping("/circus/{id}")
	public String viewCircus(@PathVariable("id") Long id, Model model) {
		Circus circusToShow = this.clownServ.getCircus(id);
		model.addAttribute("thisCircus", circusToShow);
				return "oneCircus.jsp";
	}
	
	
	//creating a new clown
	@PostMapping("/clown")
	public String create(@Valid @ModelAttribute("newClown") Clown newClown, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			model.addAttribute("allClowns", clownServ.getAll()); 
			return "index.jsp";
		}
		// otherwise create a note and redirect back
		clownServ.create(newClown);
		return "redirect:/";
	}
	
	//deleting a clown
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.clownServ.deleteClown(id);
		return "redirect:/";
	}
	
	//view one clown
	@GetMapping("/view/{id}")
	public String viewClown(@PathVariable("id") Long id, Model model) {
		Clown clownToShow = this.clownServ.getClown(id);
		model.addAttribute("thisClown", clownToShow);
		return "view.jsp";
	}
	
	//shows a clown
	@GetMapping("/update/{id}")
	public String updateClown(@PathVariable("id") Long id, @ModelAttribute("clown") Clown clown, Model model) {
		Clown clownToShow = this.clownServ.getClown(id);
		model.addAttribute("thisClown", clownToShow);
		return "update.jsp";
	}
	
	//updating a clown 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("clown") Clown clown, BindingResult result) {
	        if (result.hasErrors()) {
	            return "update.jsp";
	        } else {
	            clownServ.updateClown(clown);
	            return "redirect:/";
	        }
	    }
	
	
}
