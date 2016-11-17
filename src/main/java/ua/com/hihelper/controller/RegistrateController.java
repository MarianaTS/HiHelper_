package ua.com.hihelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.hihelper.entity.User;
import ua.com.hihelper.service.MailService;
import ua.com.hihelper.service.UserService;

@Controller
public class RegistrateController {

	
	@Autowired
	private UserService userservice;
	@Autowired
	private MailService mailservice;
	
	
	@RequestMapping(value="/registrate", method=RequestMethod.GET )
	public String registratep()
	{
		return"registration";
	}
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public String loginpage(){
		return "loginpage";
	}
	
	@RequestMapping(value={"/logout", "/home"}, method=RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registration(@ModelAttribute User user){
		userservice.save(user);
		mailservice.sendMessage("registration", user.getEmail(), "You are registered in hihelper.");
		return "redirect:/";
	}
	
	




	
}