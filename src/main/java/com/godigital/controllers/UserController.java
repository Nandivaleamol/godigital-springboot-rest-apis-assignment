package com.godigital.controllers;

import com.godigital.entities.User;
import com.godigital.services.UserService;
import com.godigital.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> saveUser(@RequestBody User user){
        this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Message("Record Inserted Successfully",true));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer userId){
        User user = userService.getSingleUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(this.userService.getAllUsers());
    }
    @PutMapping("/{userId}")
    public ResponseEntity<Message> updateUser(@RequestBody User user, @PathVariable Integer userId ){
        User updatedUser = this.userService.updateUser(user, userId);
        return ResponseEntity.status(HttpStatus.OK).body(new Message("Record Updated Successfully",true));
    }

    @DeleteMapping(value = "/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.ok().body(new Message("Record Deleted Successfully",true));
    }
}
