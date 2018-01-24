package pl.dubiel.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dubiel.bean.SessionManager;
import pl.dubiel.entity.Comment;
import pl.dubiel.entity.Flat;
import pl.dubiel.entity.Photos;
import pl.dubiel.entity.Rating;
import pl.dubiel.entity.User;
import pl.dubiel.repository.CommentRepository;
import pl.dubiel.repository.FlatRepository;
import pl.dubiel.repository.PhotosRepository;
import pl.dubiel.repository.RatingRepository;

@Controller
@RequestMapping("/flat")
public class FlatController {

	@Autowired
	FlatRepository flatrepo;

	@Autowired
	CommentRepository comrepo;
	
	@Autowired
	PhotosRepository phrepo;
	
	@Autowired
	RatingRepository ratingrepo;

	@GetMapping("/addoffer")
	public String addOffer(Model m) {
		m.addAttribute("flat", new Flat());
		return "addoffer";
	}

	@PostMapping("/addoffer")
	public String addOfferPost(@Valid @ModelAttribute Flat flat, BindingResult bindingResult,
			@RequestParam("photo") MultipartFile file, RedirectAttributes ra, Model m) {
		if (bindingResult.hasErrors()) {
			// return "redirect:/flat/addoffer";
			return "addoffer";
		}

		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		flat.setUser(u);
		flat.setCreated(new Date());
		flat.setPhoto(null);
		String fileName = null;
		this.flatrepo.save(flat);
		Long imgId = flat.getId();
		if (!file.isEmpty()) {
			try {

				String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")) {

					fileName = "flat_" + imgId + "." + extension;
					byte[] bytes = file.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
							// TODO :: absolute - path & check after deployment without eclipse
							// "./../../../../webapp/WEB-INF/resources/picture/" + fileName)));
							"/home/szymon/Pulpit/RentaRoom/src/main/webapp/WEB-INF/resources/picture/" + fileName)));
					buffStream.write(bytes);
					buffStream.close();
					// seter dla url
					flat.setPhoto(fileName);
					// zapis db
					this.flatrepo.save(flat);
					m.addAttribute("message", "Dodano produkt do bazy.");
					return "redirect:/";

				} else {
					m.addAttribute("eMessage", "Niepoprawny format pliku graficznego.");
					return "redirect:/addoffer";
				}

			} catch (Exception e) {
				return "home";
			}
		}

		m.addAttribute("eMessage", "Brak zdjęcia.");
		return "addoffer";

	}

	@GetMapping("/{id}")
	public String particularFlat(Model m, @PathVariable Long id) {
		Flat flat = flatrepo.findOne(id);
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		List<Comment> comments = comrepo.findByFlatIdOrderByCreatedAsc(id);
		List<Photos> photos =phrepo.findByFlatId(id);
		Double rating = this.ratingrepo.getAverageRating(flat);
		Long rating1 = this.ratingrepo.countAverageRating(flat);
		m.addAttribute("user", u);
		m.addAttribute("flat", flat);
		m.addAttribute("comments", comments);
		m.addAttribute("photos", photos);
		m.addAttribute("rating", rating);
		m.addAttribute("rating1", rating1);
		m.addAttribute("comment", new Comment());
		return "single_flat";
	}


	@GetMapping("/edit/{id}")
	public String editFlat(@PathVariable long id, Model m) {
		Flat f = this.flatrepo.findOne(id);
		m.addAttribute("flat", f);
		return "editoffer";
	}

	@PostMapping("/edit/{id}")
	public String editFlatPost(@Valid @ModelAttribute Flat flat, BindingResult bindingResult,
			@RequestParam("photo") MultipartFile file, RedirectAttributes ra) {
		if (bindingResult.hasErrors()) {
			return "editoffer";
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		flat.setUser(u);
		flat.setCreated(new Date());
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				Random r = new Random();
				int num = r.nextInt(500);
				Random r1 = new Random();
				int num1 = r1.nextInt(500);
				fileName = "room" + num + "_" + num1 + file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
						"/home/szymon/Pulpit/RentaRoom/src/main/webapp/WEB-INF/resources/picture/" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				flat.setPhoto(fileName);
				this.flatrepo.save(flat);
				return "redirect:/";
			} catch (Exception e) {
				return "redirect:/";
			}
		}
		this.flatrepo.save(flat);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id, RedirectAttributes ra) {
		this.flatrepo.delete(id);
		return "redirect:/";

	}

	@PostMapping("/addComment/{flatId}")
	public String addPost(@Valid @ModelAttribute Comment comment, BindingResult bindingResult,
			@PathVariable long flatId, RedirectAttributes ra) {
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
	
	@GetMapping("/addRating/{flatId}")
	public String addRate(Model m) {
		m.addAttribute("rating", new Rating());
		return "addRate";
	}
	
	@PostMapping("/addRating/{flatId}")
	public String addRateForm(@Valid @ModelAttribute Rating rating, BindingResult bindingResult, @PathVariable long flatId, RedirectAttributes ra) {
		if (bindingResult.hasErrors()) {
			return "redirect:/flat/addRating/"+flatId;
		}
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		Flat flat = this.flatrepo.findOne(flatId);
		rating.setUser(u);
		rating.setFlat(flat);
		rating.setOverall((rating.getCleanliness()+rating.getComfort()+rating.getExtras()+rating.getLocalization()+rating.getPersonel())/5);
		this.ratingrepo.save(rating);
		return "redirect:/flat/" + flatId;
	}
	
	
	
	@ModelAttribute("voivodeship")
	public List<String> getVoivodeship() {
		String voivo[] = new String[] { "Podkarpackie", "Malopolskie", "Swietokrzyskie", "Slaskie", "Opolskie",
				"Dolnoslaskie", "Mazowieckie", "Lubelskie", "Wielkopolskie", "Lubuskie", "Pomorskie", "Lodzkie",
				"Podlaskie", "Kujawsko-pomorskie", "Warminsko-Mazurskie", "Zachodniopomorskie" };
		Arrays.sort(voivo);
		return Arrays.asList(voivo);
	}

	@ModelAttribute("typeOfFlat")
	public List<String> gettypeOfFlat() {
		String typeOfFlat[] = new String[] { "Dom", "Mieszkanie", "Pokoj", "Dom letniskowy" };
		Arrays.sort(typeOfFlat);
		return Arrays.asList(typeOfFlat);
	}

	@GetMapping("/search")
	public String searchFlats(@RequestParam String name, @RequestParam String city,
			@RequestParam(defaultValue="1") Double num1, @RequestParam(defaultValue="100000000") Double num2,
			@RequestParam(defaultValue="1") int num3, @RequestParam(defaultValue="200") int num4,Model m) {
		m.addAttribute("searchResult", this.flatrepo.findByGivenCityNameNumsGuests(name, city,num1, num2, num3, num4));
		m.addAttribute("name", name);
		m.addAttribute("city", city);
		m.addAttribute("num1", num1);
		m.addAttribute("num2", num2);
		m.addAttribute("num3", num3);
		m.addAttribute("num4", num4);
		return "search";
	}
//	@GetMapping("/search0")
//	public String searchFlats0(@RequestParam String search, Model m) {
//		m.addAttribute("searchResult", this.flatrepo.findByGivenName(search));
//		m.addAttribute("search", search);
//		return "search";
//	}
	
	
	
}
