package org.example.SpringSem2Ex4.service;

import org.example.SpringSem2Ex4.model.User;
import org.example.SpringSem2Ex4.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }
}
