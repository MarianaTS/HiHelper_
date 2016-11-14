package ua.com.hihelper.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.hihelper.entity.Work;
import ua.com.hihelper.service.UserService;
import ua.com.hihelper.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	private WorkService workserv;
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/allworks", method = RequestMethod.GET)
	public String allworks(@ModelAttribute Work work, Model model) {

		model.addAttribute("works", workserv.findAll());
		return "allworks";
	}

	@RequestMapping(value = "/deletework/{id}", method = RequestMethod.GET)
	public String deletework(@PathVariable String id, Model model) {
		workserv.delete(Integer.parseInt(id));
		return "redirect:/profile";

	}

	@RequestMapping(value = "/likeit/{id}", method = RequestMethod.GET)
	public String likeit(@PathVariable String id, Model model, Principal principal) {
		Work work = workserv.findOne(Integer.parseInt(id));
		workserv.like(principal, work);
		return "redirect:/allworks";

	}
}
