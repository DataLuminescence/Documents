package com.codingdojo.javabelt.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javabelt.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{


	// this method retrieves all the books from the database
	List<Show> findAll();

	Optional<Show> findByTitle(String title);

//	// this method counts how many titles contain a certain string
//	List<Band> findByDescriptionContaining(String searh);
//	
//	// this method counts how many titles contain a certain string
//	Long countByTitleContaining(String search);
//	
//	// this method deletes a book that starts with a specific title
//	Long deleteByTitleStartingWith(String search);

}
