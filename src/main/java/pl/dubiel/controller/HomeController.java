package pl.dubiel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Flat;
import pl.dubiel.entity.User;
import pl.dubiel.repository.FlatRepository;

@Controller
public class HomeController {
	
	@Autowired
	FlatRepository flatrepo;
	
	@GetMapping("")
	public String home(Model m) {
		m.addAttribute("flat", new Flat());
		return "home";
	}
	
//	@GetMapping("/proba")
//	public String proba() {
//		return "proba";
//	}
	
	@GetMapping("userFlats/{userId}")
	public String userTweets(@PathVariable long userId, Model m) {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		if (u != null && u.getId() == userId) {
			return "redirect:/user";
		}
		List<Flat> userFlats = this.flatrepo.findByUserIdOrderByCreatedDesc(userId);
		Flat flat = this.flatrepo.findFirstByUserId(userId);
		m.addAttribute("flat",flat);
		m.addAttribute("userFlats", userFlats);
		return "userId";
	}
	
	
	@ModelAttribute("availableFlats")
	public List<Flat> getAllFlats() {
		return this.flatrepo.findAllOrder();
		
	}
	
	
	
}
