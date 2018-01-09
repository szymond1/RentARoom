package pl.dubiel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Flat;
import pl.dubiel.entity.User;
import pl.dubiel.repository.FlatRepository;

@Controller
@RequestMapping("/flat")
public class FlatController {

	@Autowired
	FlatRepository flatrepo;

	@GetMapping("/addoffer")
	public String addOffer(Model m) {
		m.addAttribute("flat", new Flat());
		return "addoffer";
	}

	@PostMapping("/addoffer")
	public String addOfferPost(@Valid @ModelAttribute Flat flat, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "redirect:/flat/addoffer";
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		flat.setUser(u);
		this.flatrepo.save(flat);
		return "redirect:/";
	}
	
	@ModelAttribute("voivodeship")
	public List<String> getVoivodeship() {
		String voivo[] = new String[] {"Podkarpackie", "Malopolskie", "Swietokrzyskie", "Slaskie", "Opolskie", "Dolnoslaskie", "Mazowieckie", "Lubelskie", "Wielkopolskie", "Lubuskie" , "Pomorskie", "Lodzkie", "Podlaskie" , "Kujawsko-pomorskie","Warminsko-Mazurskie", "Zachodniopomorskie"};
		Arrays.sort(voivo);
		return Arrays.asList(voivo);
	}
	
	@ModelAttribute("typeOfFlat")
	public List<String> gettypeOfFlat() {
		String typeOfFlat[] = new String[] {"Dom", "Mieszkanie", "Pokoj"};
		Arrays.sort(typeOfFlat);
		return Arrays.asList(typeOfFlat);
	}
	
	
}
