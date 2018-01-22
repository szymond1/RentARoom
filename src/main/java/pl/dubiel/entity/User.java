package pl.dubiel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(unique = true)
	private String userName;
	
	@NotEmpty
	private String password;
	
	private boolean enabled;
	
	@NotEmpty
	@Email(message="Niepoprawny email")
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Flat> flats = new ArrayList<>();
	
	@OneToMany(mappedBy = "sender",cascade = CascadeType.ALL,orphanRemoval=true)
	List<User> sender = new ArrayList<>();
	
	@OneToMany(mappedBy = "receiver",cascade = CascadeType.ALL,orphanRemoval=true)
	List<User> receiver = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Comment> comment = new ArrayList<>();

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean isPasswordCorrect(String pwd) {
		return BCrypt.checkpw(pwd, this.password);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Flat> getFlats() {
		return flats;
	}

	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}

	public List<User> getSender() {
		return sender;
	}

	public List<User> getReceiver() {
		return receiver;
	}

	public void setSender(List<User> sender) {
		this.sender = sender;
	}

	public void setReceiver(List<User> receiver) {
		this.receiver = receiver;
	}


	
}
