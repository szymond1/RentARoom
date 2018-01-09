package pl.dubiel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.dubiel.entity.Flat;
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
	
	@ModelAttribute("availableFlats")
	public List<Flat> getAllFlats() {
		return this.flatrepo.findAll();
		
	}
	
}
