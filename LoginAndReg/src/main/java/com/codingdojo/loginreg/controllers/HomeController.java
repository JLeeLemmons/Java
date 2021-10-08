package com.codingdojo.loginreg.controllers;

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

import com.codingdojo.loginreg.models.Menu;
import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;
import com.codingdojo.loginreg.validations.UserValidator;

@Controller
public class HomeController {

	private final UserService userServ;
	//Bring in validator
	private final UserValidator userVal;
	
	public HomeController (UserService userServ, UserValidator userVal) {
		this.userServ = userServ; 
		this.userVal = userVal; 
	}
	
	
	
	//This is for all the Menus and the User who created them. 
		@GetMapping("/success")
		public String success(Model model, HttpSession session) {
			//below two lines sets the session login value and the products associated with this user. This needs to be articulated in the Get and Post routes. 
			Long id = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findUserById(id)); 
			
			model.addAttribute("allMenus", userServ.getAllMenus()); 
			return "success.jsp"; 
		}
		
		
		@GetMapping("/newMenu")
			public String newMenu(@ModelAttribute("menu")Menu menu, Model model, HttpSession session) {
			Long id = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findUserById(id)); 
				return "newMenu.jsp";
			}
		
		@PostMapping("/makeMenu")
		public String makeMenu(@Valid @ModelAttribute("menu")Menu menu, BindingResult result, Model model,HttpSession session){
			if(result.hasErrors()) {
				return "newMenu.jsp"; 
			}else {
				Long userID = (Long)session.getAttribute("userId");
				User user = userServ.findUserById(userID);
				userServ.create(menu);
				menu.setUser(user); 
				
				return "redirect:/success";
			}
			
		}
		
		
		
		@GetMapping("/oneMenu/{id}")
		public String oneMenu(@PathVariable("id") Long id, Model model) {
			model.addAttribute("thisMenu", userServ.getMenu(id));
			return "oneMenu.jsp";
		}
		
		
		
		@GetMapping("editMenu/{id}")
		public String editMenu(@PathVariable("id") Long id, Model model, @ModelAttribute("menu")Menu menu, HttpSession session){
			Long uid = (Long) session.getAttribute("userId");
			model.addAttribute("user", userServ.findUserById(uid)); 
			
			model.addAttribute("thisMenu",userServ.getMenu(id)); 
			return "editMenu.jsp"; 
		}
		
		@RequestMapping(value= "/editingMenu/{id}", method=RequestMethod.POST)
		public String editingMenu(@Valid @ModelAttribute("menu")Menu menu, BindingResult result, @RequestParam("name") String name, @RequestParam("description") String description, @PathVariable("id") Long id, HttpSession session) {
			if(result.hasErrors()) {
				return "editMenu.jsp";
			}
			userServ.updatingThisMenu(id,name,description);
				return "redirect:/success"; 
			
		}
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			userServ.deleteMenu(id); 
			return "redirect:/success"; 
		}
		
		
	
	
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
