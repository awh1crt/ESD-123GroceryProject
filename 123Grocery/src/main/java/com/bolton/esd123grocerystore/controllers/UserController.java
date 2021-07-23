package com.bolton.esd123grocerystore.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.UserRepository;
import com.bolton.esd123grocerystore.services.UserService;

@SessionAttributes("userName")
@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String loginPage() {
		return("login");
	}
	@PostMapping("/login")
	public String userLogin(@RequestParam String userEmail, String password, ModelMap model) {
	
		String userName = userService.validateRegisteredUser(userEmail, password);
		if(userName==null) {
			model.put("errorMessage", "Not a valid user");
			return "login";
		}
		model.put("userName", userName);
		
	
		return "index";
	}
	@GetMapping("/registeruser")
	public String userRegistrationPage() {

		return "register";
	}
	@PostMapping("/register")
	public String user(@RequestParam String ufirstname, String ulastname, String upass, String uemail, String uaddress) {

			
		User newUser = new User(ufirstname,ulastname, upass, uemail, uaddress);
		System.out.println(newUser);
		userRepository.save(newUser);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String userLogOut(ModelMap model, HttpSession session) {
		session.invalidate();
		model.put("loggedout", "Your are successfully logged out!");
		return ("/login");
	}
}
