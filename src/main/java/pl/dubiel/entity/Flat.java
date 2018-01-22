package pl.dubiel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Flat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min = 3)
	private String name;
	
	@ManyToOne
	private User user;
	
	private Date created;
	
	@NotEmpty
	@Size(min = 4)
	private String voivodeship;		
	@NotEmpty
	private String postCode;
	@NotEmpty
	@Size(min = 3)
	private String city;
	@NotEmpty
	@Size(min = 3)
	private String street;
	@NotEmpty
	@Size(min = 3)
	private String typeOfFlat;		
	@NotNull
	private double surface;
	@NotNull
	private double price;
	@NotNull
	private int numberOfGuests;
	@NotEmpty
	private String description;
	
	private String photo;
	
	@OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comment = new ArrayList<>();
	
	@OneToMany(mappedBy = "rating", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Rating> rating = new ArrayList<>();
	
	@OneToMany(mappedBy = "flat",cascade = CascadeType.ALL)
	private List<Photos> photos = new ArrayList<>();
	
	public Flat() {
		super();
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Date getCreated() {
		return created;
	}

	public String getVoivodeship() {
		return voivodeship;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getTypeOfFlat() {
		return typeOfFlat;
	}

	public double getSurface() {
		return surface;
	}

	public double getPrice() {
		return price;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setVoivodeship(String voivodeship) {
		this.voivodeship = voivodeship;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setTypeOfFlat(String typeOfFlat) {
		this.typeOfFlat = typeOfFlat;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	public int getCommentSize() {
		return this.comment.size();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	
	
}
