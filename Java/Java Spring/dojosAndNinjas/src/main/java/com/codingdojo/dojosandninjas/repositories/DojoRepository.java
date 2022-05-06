package com.codingdojo.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    
	// this method retrieves all the books from the database
	List<Dojo> findAll();
	
//	// this method counts how many titles contain a certain string
//	List<Dojo> findByNameContaining(String search);
//	
//	// this method counts how many titles contain a certain string
//	Long countByNameContaining(String search);
//	
//	// this method deletes a book that starts with a specific title
//	Long deleteByNameStartingWith(String search);

}
