package pl.dubiel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Flat;
import pl.dubiel.entity.User;
import pl.dubiel.repository.FlatRepository;

@Controller
public class UserViewController {
	
	@Autowired
	private FlatRepository flatrepo;
	
	@GetMapping("/user")
	public String user(Model m) {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		m.addAttribute("flat", new Flat());
		m.addAttribute("user", u);
		return "user";
	}
	
	@ModelAttribute("userFlats")
	public List<Flat> getUserFlats() {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		return this.flatrepo.findByUserId(u.getId());
	}
}
