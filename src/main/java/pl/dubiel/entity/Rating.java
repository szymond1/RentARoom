package pl.dubiel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private Double localization;
	
	@NotNull
	private Double comfort;
	
	@NotNull
	private Double cleanliness;
	
	@NotNull
	private Double extras;
	
	@NotNull
	private Double personel;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Flat flat;
	
	private Double overall;
	
	public Rating() {
	}

	public long getId() {
		return id;
	}

	public Double getLocalization() {
		return localization;
	}

	public Double getComfort() {
		return comfort;
	}

	public Double getCleanliness() {
		return cleanliness;
	}

	public Double getExtras() {
		return extras;
	}

	public Double getPersonel() {
		return personel;
	}

	public Double getOverall() {
		return overall;
	}

	public void setLocalization(Double localization) {
		this.localization = localization;
	}

	public void setComfort(Double comfort) {
		this.comfort = comfort;
	}

	public void setCleanliness(Double cleanliness) {
		this.cleanliness = cleanliness;
	}

	public void setExtras(Double extras) {
		this.extras = extras;
	}

	public void setPersonel(Double personel) {
		this.personel = personel;
	}

	public User getUser() {
		return user;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public void setOverall(Double overall) {
		this.overall = overall;
	}

	
	
}
