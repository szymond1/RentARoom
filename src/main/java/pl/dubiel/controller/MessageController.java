package pl.dubiel.controller;

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

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Message;
import pl.dubiel.entity.User;
import pl.dubiel.repository.MessageRepository;
import pl.dubiel.repository.UserRepository;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageRepository mrepo;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("")
	public String messageList(Model m) {
		m.addAttribute("message", new Message());
		return "mess/message_list";
	}

	
	@GetMapping("/{id}")
	public String message(Model m, @PathVariable long id) {
		HttpSession s = SessionManager.session();
		if (s != null) {
			User sender = (User) s.getAttribute("user");
			if (sender != null && sender.getId() == id) {
				return "redirect:/message";
			}
		}
		m.addAttribute("message", new Message());
		m.addAttribute("recieverId", id);
		return "mess/send_message";
	}
	
	@PostMapping("/add/{recieverId}")
	public String addPost(@Valid @ModelAttribute Message message, @PathVariable long recieverId,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/message/" + recieverId;
		}
		HttpSession s = SessionManager.session();
		User sender = (User) s.getAttribute("user");
		message.setSender(sender);
		User reciever = this.userRepository.findOne(recieverId);
		message.setReciever(reciever);
		message.setCreated(new Date());
		this.mrepo.save(message);
		return "redirect:/message";
	}
	
	@ModelAttribute("userMessages")
	public List<Message> getMessages() {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		return this.mrepo.findByRecieverOrderByCreatedDesc(u);
	}

	@ModelAttribute("sentMessages")
	public List<Message> getSentMessages() {
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		return this.mrepo.findBySenderOrderByCreatedDesc(u);
	}


}
