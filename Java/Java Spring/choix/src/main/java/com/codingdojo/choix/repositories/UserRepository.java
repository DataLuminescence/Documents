package com.codingdojo.choix.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.choix.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
	Optional<User> findByEmail(String email);
	Optional<User> findByUserName(String userName);
	List<User> findAll(); 
}

