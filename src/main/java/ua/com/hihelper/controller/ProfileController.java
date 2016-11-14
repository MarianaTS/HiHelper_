package ua.com.hihelper.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;
import ua.com.hihelper.service.UserService;
import ua.com.hihelper.service.WorkService;

@Controller
public class ProfileController {

	@Autowired
	private UserService userService;
	@Autowired
	private WorkService workService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, Principal principal) {
		User user = userService.findFetchUser(Integer.parseInt(principal.getName()));
		model.addAttribute("works", user.getWorks());

		model.addAttribute("user", user);
		return "profile";
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image) {

		userService.saveImg(principal, image);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String editProfile(Model model, Principal principal) {

		User user = userService.findFetchUser(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);
		return "editprofile";
	}

	@RequestMapping(value = "/editthisuser", method = RequestMethod.POST)
	public String editProfileUser(@ModelAttribute User user, Model model, Principal principal) {

		User user2 = userService.findFetchUser(Integer.parseInt(principal.getName()));
		user2.setAge(user.getAge());
		user2.setCity(user.getCity());
		user2.setPhonenumber(user.getPhonenumber());
		user2.setEmail(user.getEmail());
		user2.setCountry(user.getCountry());
		user2.setDescription(user.getDescription());
		userService.save(user2);
		return "redirect:/profile";
	}

	@RequestMapping(value = "/createnewwork", method = RequestMethod.GET)
	public String createworknew(Principal principal, @ModelAttribute Work work) {
		User user = userService.findFetchUser(Integer.parseInt(principal.getName()));

		workService.addwork(principal, work);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/creatework", method = RequestMethod.GET)
	public String creatework(Model model, Principal principal) {
		User user = userService.findFetchUser(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);

		return "creatework";
	}

	@RequestMapping(value = "/wholikes/{id}", method = RequestMethod.GET)
	public String wholikes(Model model, Principal principal, @PathVariable String id) {
		User user = userService.findFetchUser(Integer.parseInt(principal.getName()));
		Work work = workService.findOne(Integer.parseInt(id));
		return "infowork";
	}
}
