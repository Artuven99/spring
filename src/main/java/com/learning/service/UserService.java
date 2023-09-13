package com.learning.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.entities.User;
import com.learning.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Autowired
    BCryptPasswordEncoder encoder;

    // Create
    public User saveUser(User user) {
    	
    	String encodePassword = encoder.encode(user.getPassword());
    	user.setPassword(encodePassword);
        return userRepository.save(user);
    }

    // Read (Single user by ID)
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Read (All users)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    
    public User findByMail(String mail) {
    	return userRepository.findUserByMail(mail);
    }
    // Update
    public User updateUser(User user) {
        // This check can be more detailed, like checking if the user really exists.
        // For this basic example, if the user has an ID, we assume it exists.
        if (user.getId() != null) {
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("User ID cannot be null when updating");
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
