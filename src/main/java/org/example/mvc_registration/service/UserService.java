package org.example.mvc_registration.service;

import org.example.mvc_registration.model.User;
import org.example.mvc_registration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> getUserByName(String name) {
       return userRepository.findByName(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    // написать к ним тесты
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
