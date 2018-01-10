package pl.dubiel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Comment;
import pl.dubiel.entity.Flat;
import pl.dubiel.entity.User;
import pl.dubiel.repository.CommentRepository;
import pl.dubiel.repository.FlatRepository;

@Controller
@RequestMapping("/flat")
public class FlatController {

	@Autowired
	FlatRepository flatrepo;
	
	@Autowired
	CommentRepository comrepo;

	@GetMapping("/addoffer")
	public String addOffer(Model m) {
		m.addAttribute("flat", new Flat());
		return "addoffer";
	}

	@PostMapping("/addoffer")
	public String addOfferPost(@Valid @ModelAttribute Flat flat, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			//return "redirect:/flat/addoffer";
			return "addoffer";
		}
		
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		flat.setUser(u);
		flat.setCreated(new Date());
		this.flatrepo.save(flat);
		return "redirect:/";
		
	}
	
	@GetMapping("/{id}")
	public String particularFlat(Model m, @PathVariable long id) {
		Flat flat = flatrepo.findOne(id);
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		List<Comment> comments = comrepo.findByFlatIdOrderByCreatedAsc(id);

		m.addAttribute("user", u);
		m.addAttribute("flat", flat);
		m.addAttribute("comments", comments);
		m.addAttribute("comment", new Comment());
		return "single_flat";
	}
	
	@PostMapping("/addComment/{flatId}")
	public String addPost(@Valid @ModelAttribute Comment comment, BindingResult bindingResult, @PathVariable long flatId) {
		if (bindingResult.hasErrors()) {
			return "redirect:/flat/" + flatId;
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		Flat flat = this.flatrepo.findOne(flatId);
		comment.setFlat(flat);
		comment.setUser(u);
		comment.setCreated(new Date());
		this.comrepo.save(comment);
		return "redirect:/flat/" + flatId;
	}
	
	
	@GetMapping("/edit/{id}")
	public String editFlat(@PathVariable long id, Model m) {
		Flat f = this.flatrepo.findOne(id);
		m.addAttribute("flat", f);
		return "editoffer";
	}
	
	@PostMapping("/edit/{id}")
	public String editFlatPost(@Valid @ModelAttribute Flat f,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "editoffer";
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		f.setUser(u);
		f.setCreated(new Date());
		this.flatrepo.save(f);
		return "redirect:/";
	}
	

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id) {
		this.flatrepo.delete(id);
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
