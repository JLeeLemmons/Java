package com.codingdojo.JavaExam.Controllers;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.JavaExam.Models.Idea;
import com.codingdojo.JavaExam.Models.User;
import com.codingdojo.JavaExam.Services.UserService;
import com.codingdojo.JavaExam.Validations.UserValidator;



@Controller
public class HomeController {
	
	private final UserService userServ;
	//Bring in validator
	private final UserValidator userVal;
	
	
	public HomeController (UserService userServ, UserValidator userVal) {
		this.userServ = userServ; 
		this.userVal = userVal; 
	}
	
	
	// this is the next page after login/account creation takes place.
	@GetMapping("/success")
	public String success(Model model, HttpSession session) {
		Long id = (Long)session.getAttribute("userId");
		
		model.addAttribute("user", userServ.findUserById(id));
		
//		model.addAttribute("thisUser", session.getAttribute("user"));
		
		model.addAttribute("allIdeas", userServ.getAll()); 
		return "success.jsp"; 
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("createIdea") Idea newIdea, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findUserById(id)); 
		return "createIdea.jsp"; 
	}
	
	@PostMapping("newIdea")
	public String createIdea(@Valid @ModelAttribute("createIdea") Idea newIdea, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "createIdea.jsp"; 
		}else {
		Long userID = (Long)session.getAttribute("userId");
		User user = userServ.findUserById(userID);
		userServ.create(newIdea);
		newIdea.setUser(user); 
		
		return "redirect:/success"; 
		}
	}
	
	@GetMapping("/view/{id}")
	public String oneIdea(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("thisIdea", userServ.getIdea(id));
		return "viewAll.jsp"; 
	}
	
	@GetMapping("/update/{id}")
	public String updateHorse(@PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, Model model) {
		Idea ideaToShow = this.userServ.getIdea(id);
		model.addAttribute("thisIdea", ideaToShow);
		return "editIdea.jsp"; 
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
		public String update(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
			if(result.hasErrors()) {
				return "editIdea.jsp";
			}else {
				userServ.updateIdea(idea);
				Long userID = (Long)session.getAttribute("userId");
				User user = userServ.findUserById(userID);
				idea.setUser(user);
				return "redirect:/success"; 
			}
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.userServ.deleteIdea(id); 
		return "redirect:/success"; 
	}
	
	
	
	//*******************************************
	
	//this links the model attribute in the form with this method. 
	@GetMapping("/")
	public String index(@ModelAttribute("user")User user) {
		return "index.jsp"; 
	}
	
	//creating a @PostMapping in order to allow the registration fields to be submitted. This mapping is linked to the action in the form. 
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user")User newUser, BindingResult result, HttpSession session) {
		userVal.validate(newUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			userServ.registerUser(newUser);
			session.setAttribute("userId", newUser.getId());
//			session.setAttribute("user", newUser); 
			return "redirect:/success";
		}
	}
	
	//setting up the login functionality-- to pull things from our form, we need to input @RequestParam.
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		boolean isAuth = userServ.authenticateUser(email, password);
		if(isAuth) {
			User u = userServ.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/success";
		}else {
			redirectAttributes.addFlashAttribute("error", "Invalid Login Attempt!!"); 
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}


}
