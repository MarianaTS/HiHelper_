package ua.com.hihelper.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;
import ua.com.hihelper.service.UserService;
import ua.com.hihelper.service.WorkService;

@Controller
public class AdminController {

	
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/addnewuser", method=RequestMethod.POST)
	public String newUser(@ModelAttribute("user") User user  )
	{
		
		userservice.save(user);
		
		return"redirect:/adduser";
	}
	
	
	@Autowired
	private WorkService workservice;
	

	@RequestMapping(value="/addnewwork", method=RequestMethod.POST)
	public String newUser(@ModelAttribute("work") Work work  )
	{
		
		workservice.save(work);
		
		
		return"redirect:/addwork";
	}
	
	@RequestMapping(value="/activity", method=RequestMethod.GET)
	public String activity()
	{
		return"activity";
	}
	
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public String messages()
	{
		return"messages";
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public String adduser()
	{
		return"adduser";
	}
	
	@RequestMapping(value="/addwork", method=RequestMethod.GET)
	public String addwork()
	{
		return"addwork";
	}
	
	@RequestMapping(value="/edituser", method=RequestMethod.GET)
	public String edituser(Model model)
	{
		   model.addAttribute("users", userservice.findAll());
		return"edituser";
	}
	@RequestMapping(value="/deluser/{id}", method=RequestMethod.GET)
	public String deluser(@PathVariable String id)
	{
		  userservice.delete(Integer.parseInt(id));
		return"redirect:/edituser";
	}
	
	@RequestMapping(value="/delwork/{id}", method=RequestMethod.GET)
	public String delwork(@PathVariable String id)
	{
		  workservice.delete(Integer.parseInt(id));
		return"redirect:/editwork";
	}
	
	@RequestMapping(value="/editwork", method=RequestMethod.GET)
	public String editwork()
	{
		return"editwork";
	}




	
}
	

