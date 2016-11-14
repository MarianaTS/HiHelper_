package ua.com.hihelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home()
	{
		return"home";
	}
	
	
	@RequestMapping(value="/adminpage", method=RequestMethod.GET)
	public String adminpage()
	{
		return"adminpage";
	}
	
	@RequestMapping(value="/loginpage")
	public String login()
	{
		return"loginpage";
	}
	
	
}
