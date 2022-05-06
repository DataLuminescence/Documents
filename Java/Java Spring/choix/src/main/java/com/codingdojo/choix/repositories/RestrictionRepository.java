package com.codingdojo.choix.repositories;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.choix.models.Restriction;

public interface RestrictionRepository extends CrudRepository<Restriction, Long>{


	// this method retrieves all the books from the database
	List<Restriction> findAll();

//	Optional<Restriction> findByTitle(String title);

//	// this method counts how many titles contain a certain string
//	List<Band> findByDescriptionContaining(String searh);
//	
//	// this method counts how many titles contain a certain string
//	Long countByTitleContaining(String search);
//	
//	// this method deletes a book that starts with a specific title
//	Long deleteByTitleStartingWith(String search);

}