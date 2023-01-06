package com.godigital.services.impl;

import com.godigital.entities.User;
import com.godigital.exceptions.ResourceNotFoundException;
import com.godigital.repositories.UserRepository;
import com.godigital.services.UserService;
import com.godigital.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreatedOn(new Date());
        user.setChangedOn(null);
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer userId) {
        User userUpdate = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        userUpdate.setUserName(user.getUserName());
        userUpdate.setUserPhoneNumber(user.getUserPhoneNumber());
        userUpdate.setChangedOn(new Date());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setUserPersonal(user.getUserPersonal());

        return userRepository.save(userUpdate);
    }

    @Override
    public User getSingleUser(Integer userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepository.delete(user);
    }
}
