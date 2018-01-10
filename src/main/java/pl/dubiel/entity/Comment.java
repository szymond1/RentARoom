package pl.dubiel.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Comment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Flat flat;
	
	private Date created;
	
	@Size(max = 300)
	@NotEmpty
	private String text;

	public Comment() {
		super();
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Flat getFlat() {
		return flat;
	}

	public Date getCreated() {
		return created;
	}

	public String getText() {
		return text;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
