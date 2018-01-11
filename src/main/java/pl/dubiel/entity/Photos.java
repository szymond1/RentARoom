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
public class Photos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Flat flat;
	
	private Date created;
	
	private String url;
	
	private String description;

	public Photos() {
		super();
	this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public Flat getFlat() {
		return flat;
	}

	public Date getCreated() {
		return created;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
