package com.codingdojo.choix.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="restrictions")
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // The user's consumption of animal products
    private String animal;
    
    // The user's food allergies
    private String [] allergies;
    
    // The user's food restrictions due to religious beliefs
    private String religious;
    
    // The user's food restrictions due to lifestyle or diet
//    private String [] lifestyle;
    
    // The user's preference in restaurants
//    private String [] cuisine;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "allergies", 
//        joinColumns = @JoinColumn(name = "restriction_id"), 
//        inverseJoinColumns = @JoinColumn(name = "allergie_id")
//    )
//    private List<Allergie> allergies;    
    
	// ------------------------------- CONSTRUCTORS -------------------------------   

	// Empty constructor
	
    public Restriction() {}
    
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getReligious() {
		return religious;
	}

	public void setReligious(String religious) {
		this.religious = religious;
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


	
}
	