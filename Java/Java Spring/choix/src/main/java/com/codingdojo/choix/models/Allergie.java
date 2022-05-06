package com.codingdojo.choix.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="allergies")
public class Allergie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "allergiesuser", 
//        joinColumns = @JoinColumn(name = "user_id"), 
//        inverseJoinColumns = @JoinColumn(name = "allergie_id")
//    )
//    private List<User> users;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "allergiesrestriction", 
//        joinColumns = @JoinColumn(name = "restriction_id"), 
//        inverseJoinColumns = @JoinColumn(name = "allergie_id")
//    )
//    private List<Restriction> restrictions;    
//    
    public Allergie() {}
//    
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//
//	public List<Restriction> getRestrictions() {
//		return restrictions;
//	}
//
//	public void setRestrictions(List<Restriction> restrictions) {
//		this.restrictions = restrictions;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
	
}
