package pl.dubiel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Message;
import pl.dubiel.entity.User;
import pl.dubiel.repository.MessageRepository;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageRepository mrepo;

	@GetMapping("")
	public String messageList(Model m) {
		m.addAttribute("message", new Message());
		return "mess/message_list";
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
