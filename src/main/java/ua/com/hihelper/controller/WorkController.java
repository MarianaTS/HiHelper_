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

import ua.com.hihelper.entity.Schedule;
import ua.com.hihelper.entity.User;
import ua.com.hihelper.entity.Work;
import ua.com.hihelper.repository.ScheduleRepository;
import ua.com.hihelper.service.AppointmentService;
import ua.com.hihelper.service.MailService;
import ua.com.hihelper.service.UserService;
import ua.com.hihelper.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	private WorkService workservice;
	@Autowired
	private UserService userservice;

	@Autowired
	private ScheduleRepository schedulerep;

	@Autowired
	private AppointmentService appservice;
	
	@Autowired
	private MailService mailservice;
	

	@RequestMapping(value = "/allworks", method = RequestMethod.GET)
	public String allworks(@ModelAttribute Work work, Model model) {

		model.addAttribute("works", workservice.findAll());

		return "allworks";
	}

	@RequestMapping(value = "/deletework/{id}", method = RequestMethod.GET)
	public String deletework(@PathVariable String id, Model model) {
		workservice.delete(Integer.parseInt(id));
		return "redirect:/profile";

	}

	@RequestMapping(value = "/likeit/{id}", method = RequestMethod.GET)
	public String likeit(@PathVariable String id, Model model, Principal principal) {
		workservice.like(principal, Integer.parseInt(id));
		return "redirect:/allworks";

	}

	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public String appointment(Model model, Principal principal, @RequestParam String id) {

		Work work = workservice.findOne(Integer.parseInt(id));
		userservice.findFetchUser(Integer.parseInt(principal.getName()));
		model.addAttribute("work", workservice.findOne(Integer.parseInt(id)));
		User sender = userservice.findFetchUser(Integer.parseInt(principal.getName()));
		model.addAttribute("employeer", work.getUser());
		model.addAttribute("sender", sender);
		return "appointment";

	}

	@RequestMapping(value = "/addschedule/{id}", method = RequestMethod.GET)
	public String addschedule(@PathVariable String id, Model model) {

		Work work = workservice.findOne(Integer.parseInt(id));
		model.addAttribute("work", work);
		model.addAttribute("schedule", work.getSchedule());
		return "addschedule";

	}

	@RequestMapping(value = "/addnewsc/{id}", method = RequestMethod.GET)
	public String addscheduletowork_(@ModelAttribute("schedule") Schedule schedule, @PathVariable String id) {

		Work work = workservice.findOne(Integer.parseInt(id));
		workservice.addSchedule(work, schedule);

		return "profile";

	}

	@RequestMapping(value = "/appointmnetwork", method = RequestMethod.GET)
	public String sendappointmentmessage(@RequestParam("sender_id") String sender_id,
			@RequestParam("work_id") String work_id, @RequestParam("textmessage") String textmessage) {

		// model.addAttribute("user", new User());

		Work work = workservice.findOne(Integer.parseInt(work_id));
		User sender = userservice.findOne(Integer.parseInt(sender_id));
		appservice.sendmessage(work, sender, textmessage);

		return "home";

	}

	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public String appointments(Model model, @RequestParam("id") String id) {

		// model.addAttribute("user", new User());

		Work work = workservice.findOne(Integer.parseInt(id));
		model.addAttribute("appointments", work.getAppointment());

		return "appointments";

	}

	@RequestMapping(value = "/deleteapp", method = RequestMethod.GET)
	public String deleteapp(Model model, @RequestParam("app_id") String id_app, @RequestParam("id") String id) {

		// model.addAttribute("user", new User());

		appservice.delete(Integer.parseInt(id_app));

		return "redirect:/profile";

	}
	
	@RequestMapping(value = "/answer", method = RequestMethod.GET)
	public String answere(Model model, @RequestParam("id_client") String id_client, @RequestParam("id_work") String id_work, Principal principal) {

		
		model.addAttribute("client", userservice.findOne(Integer.parseInt(id_client)));
		model.addAttribute("sender", userservice.findFetchUser(Integer.parseInt(principal.getName())));
		return "answer";

	}
	
	
	@RequestMapping(value = "/answertoappointmentr", method = RequestMethod.GET)
	public String sendanswer(Model model, Principal principal, @RequestParam("text") String text, @RequestParam("client_email") String clem,
			@RequestParam("password") String password) {

		User sender=userservice.findFetchUser(Integer.parseInt(principal.getName()));
		
		mailservice.sendMessagefromuser("answer", clem, text, sender.getEmail(), password);

		return "home";

	}

}
