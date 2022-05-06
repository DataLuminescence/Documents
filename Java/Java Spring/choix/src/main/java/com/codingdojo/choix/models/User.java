package com.codingdojo.choix.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Transient;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.codingdojo.choix.models.Restriction;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Username is required.")
	@Size(min=8, max=20, message="Username must be 8 and 20 characters long.")
	private String userName;

	//Verify email doesn't already exist in database
	@NotBlank(message="Email is required.")
	@Email(message="Please enter a valid email ex:name@server.com.")
	private String email;
	
	@NotBlank(message="Zipcode is required.")
	@Size(min=5, max=5, message="Please use 5 digit zipcode.")
	private String zipcode;
	
//	@Size(min=1, max=1, message="Please check to indicate you have read these terms.")
//	@NotNull(message="Please check to indicate you have read these terms.")
	private Boolean terms;

	@NotBlank(message="Password is required!")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
	private String password;

	@Transient
	@NotEmpty(message="Confirm Password is required.")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters.")
	private String confirm;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	// MappedBy searches Book model for user in order to create the join
	@OneToOne(mappedBy="user", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Restriction> restrictions;
    
	
	
	
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "allergie", 
//        joinColumns = @JoinColumn(name = "allergie_id"), 
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<Allergie> allergies;
	
	
	// ------------------------------- CONSTRUCTORS -------------------------------   

	// Empty constructor
    public User() {}
    
	// Sets datetime when expense is created
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	// Sets datetime when expense is updated
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// ---------------------------- GETTERS & SETTERS ---------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void setTerms(Boolean terms) {
		this.terms = terms;
	}

	public Boolean getTerms() {
		return terms;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}
	
}

