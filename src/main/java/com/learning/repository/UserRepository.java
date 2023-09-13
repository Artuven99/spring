package com.learning.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	@Query("SELECT u FROM User u WHERE u.mail = ?1")
	User findUserByMail(String mail); 
}
