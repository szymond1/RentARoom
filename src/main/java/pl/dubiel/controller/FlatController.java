package pl.dubiel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlatController {

	@GetMapping("/flat")
	@ResponseBody
	public String flat() {
		return "flat to tutaj";
	}
}
