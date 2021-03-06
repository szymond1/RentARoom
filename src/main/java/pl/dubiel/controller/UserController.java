package pl.dubiel.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dubiel.bean.LoginData;
import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Message;
import pl.dubiel.entity.Rating;
import pl.dubiel.entity.User;
import pl.dubiel.repository.MessageRepository;
import pl.dubiel.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	MessageRepository mrepo;
	

@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "account/register";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "redirect:/register";
		}
		
		List<User> users = this.userrepo.findAll();
		for (User u : users) {
			if (u.getEmail().equals(user.getEmail())) {
				m.addAttribute("msg", "This email address is already used. Try different email.");
				return "account/register";
			}
			if (u.getUserName().equals(user.getUserName())) {
				m.addAttribute("msg1", "This username is already used. Try different username.");
				return "account/register";
			}
		}
		
		this.userrepo.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/accountOpt")
	public String accountOpt(Model m) {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		m.addAttribute("user", u);
		return "account/accountOpt";
	}
	
	@PostMapping("/accountOpt")
	public String accountOptPost(@Valid @ModelAttribute User user, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "redirect:/accountOpt";
		}
		
//		List<User> users = this.userrepo.findAll();
//		for (User u : users) {
//			if (u.getEmail().equals(user.getEmail())) {
//				m.addAttribute("msg", "This email address is already used. Try different email.");
//				return "accountOpt";
//			}
//			if (u.getUserName().equals(user.getUserName())) {
//				m.addAttribute("msg1", "This username is already used. Try different username.");
//				return "accountOpt";
//			}
//		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		user.setId(u.getId());
		this.userrepo.save(user);
		return "redirect:/";
	}
	
	
	@GetMapping("/delete")
	public String delete(Model m) {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		m.addAttribute("user", u);
		return "account/delete";
	}
	
	@GetMapping("/delete/{decision}")
	public String deletePost(@PathVariable int decision) {
	if (decision == 1) {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		s.invalidate();
		List<Message> mess = this.mrepo.findBySenderOrderByCreatedDesc(u);
		for (Message m: mess) {
			this.mrepo.delete(m);
		}
		this.userrepo.delete(u);
		return "redirect:/login";
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/login")
		public String login(Model m) {
			m.addAttribute("loginData", new LoginData());
			return "account/login";
		}
	
		@PostMapping("/login")
		public String loginPost(@ModelAttribute LoginData loginData, Model m, RedirectAttributes ra) {
			User u = this.userrepo.findOneByuserName(loginData.getUserName());
				if (u != null && u.isPasswordCorrect(loginData.getPassword())) {
					HttpSession s = SessionManager.session();
					s.setAttribute("user", u);
					ra.addFlashAttribute("msg", "Logged");
					return "redirect:/";
			}
			m.addAttribute("msg", "Invalid username or password");
			return "account/login";
		}
		
		@GetMapping("/logout")
		public String logout(Model m) {
			HttpSession s = SessionManager.session();
			s.invalidate();
			return "redirect:/";
		}
	
	
}
