package com.godigital.services;

import com.godigital.entities.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user, Integer userId);

    User getSingleUser(Integer userId);

    List<User> getAllUsers();

    void deleteUser(Integer userId);

}
