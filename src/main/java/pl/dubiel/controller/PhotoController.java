package pl.dubiel.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Comment;
import pl.dubiel.entity.Flat;
import pl.dubiel.entity.Photos;
import pl.dubiel.entity.User;
import pl.dubiel.repository.CommentRepository;
import pl.dubiel.repository.FlatRepository;
import pl.dubiel.repository.PhotosRepository;

@Controller
@RequestMapping
public class PhotoController {

	@Autowired
	FlatRepository flatrepo;

	@Autowired
	PhotosRepository phrepo;

	@GetMapping("/add/photos/{id}")
	public String addOffer(Model m) {
		m.addAttribute("flat", new Flat());
		m.addAttribute("photos", new Photos());
		return "multipleUpload";
	}

	@PostMapping("/add/photos/{id}")
	public String addOfferPost(@ModelAttribute Photos p, @RequestParam("photo") MultipartFile[] files,
			@PathVariable Long id) {

		Flat flat = this.flatrepo.findFirstById(id);
		String fileName = null;
		String msg = "";

		for (int i = 0; i < files.length; i++) {
			Photos newPhoto = new Photos();
			newPhoto.setFlat(flat);
			newPhoto.setUrl(null);
			newPhoto.setCreated(new Date());
			this.phrepo.save(newPhoto);
			Random r = new Random();
			int num = r.nextInt(500);
			fileName = "room" + newPhoto.getId() + "_" + num + "_" + files[i].getOriginalFilename();
			try {
				byte[] bytes = files[i].getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
						"/home/szymon/Pulpit/RentaRoom/src/main/webapp/WEB-INF/resources/picture/" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				newPhoto.setUrl(fileName);
				this.phrepo.save(newPhoto);
				msg += "You have successfully uploaded " + fileName + "<br/>";
			} catch (Exception e) {
				return "redirect:/";
			}
		}
		return "redirect:/";
	}

//	@GetMapping("/edit/photos/{id}")
//	public String editFlat(@PathVariable long id, Model m) {
//		Flat f = this.flatrepo.findOne(id);
//		m.addAttribute("flat", f);
//		return "editoffer";
//	}
//
//	@PostMapping("/edit/photos/{id}")
//	public String editFlatPost(@Valid @ModelAttribute Flat flat, BindingResult bindingResult,
//			@RequestParam("photo") MultipartFile file) {
//		if (bindingResult.hasErrors()) {
//			return "editoffer";
//		}
//		HttpSession s = SessionManager.session();
//		User u = (User) s.getAttribute("user");
//		flat.setUser(u);
//		flat.setCreated(new Date());
//		String fileName = null;
//		if (!file.isEmpty()) {
//			try {
//				Random r = new Random();
//				int num = r.nextInt(500);
//				Random r1 = new Random();
//				int num1 = r1.nextInt(500);
//				fileName = "room" + num + "_" + num1 + file.getOriginalFilename();
//				byte[] bytes = file.getBytes();
//				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
//						"/home/szymon/Pulpit/RentaRoom/src/main/webapp/WEB-INF/resources/picture/" + fileName)));
//				buffStream.write(bytes);
//				buffStream.close();
//				flat.setPhoto(fileName);
//				this.flatrepo.save(flat);
//				return "redirect:/";
//			} catch (Exception e) {
//				return "redirect:/";
//			}
//		}
//		this.flatrepo.save(flat);
//		return "redirect:/";
//	}
//
//	@GetMapping("/delete/photos/{id}")
//	public String deleteBook(@PathVariable long id) {
//		this.flatrepo.delete(id);
//		return "redirect:/";
//
//	}

	// @ModelAttribute("typeOfFlat")
	// public List<String> gettypeOfFlat() {
	// String typeOfFlat[] = new String[] { "Dom", "Mieszkanie", "Pokoj" };
	// Arrays.sort(typeOfFlat);
	// return Arrays.asList(typeOfFlat);
	// }

}
