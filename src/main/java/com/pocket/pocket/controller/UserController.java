package com.pocket.pocket.controller;

import com.pocket.pocket.model.*;
import com.pocket.pocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User createdUser = service.addUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        boolean isValid = service.validatePassword(email, password);

        if (isValid) {
            UserDetail userDetail = service.getUserDetail(service.getToken(loginRequest.getEmail(), loginRequest.getPassword()));
            return ResponseEntity.ok(userDetail);
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }
    }

    @PostMapping("/token")
    public String getToken(@RequestBody Login user) {
        return service.getToken(user.getEmail(), user.getPassword());
    }

    @PostMapping("/validtoken/{token}")
    public boolean validToken(@PathVariable String token) {
        return service.validateToken(token);
    }

    @PostMapping("/logout/{token}")
    public void logout(@PathVariable String token) {
        service.logoutToken(token);
    }

    @GetMapping("/userDetail/{token}")
    public UserDetail getUserDetail(@PathVariable String token) {
        return service.getUserDetail(token);
    }

    @PutMapping("/updateEmail")
    public UpdateUser updateUserEmail(@RequestBody UpdateUser user) {
        return service.updateEmail(user);
    }

    @PutMapping("/updateName")
    public UpdateUser updateUserName(@RequestBody UpdateUser user) {
        return service.updateName(user);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<?> updateUserPassword(@RequestBody UpdateUser user) {
        UpdateUser updatedUser = service.updatePassword(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.badRequest().body("Bad Request.");
    }

    @DeleteMapping("/delete/{token}")
    public void deleteUser(@PathVariable String token) {
        service.deleteUser(token);
    }

    @GetMapping("/reports/{id}")
    public List<Report> userReports(@PathVariable int id) {
        return service.getReport(id);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody UserDetail user) {
        UserDetail userDetail = service.updateUser(user);
        if (userDetail != null) {
            return ResponseEntity.ok(userDetail);
        }
        return ResponseEntity.badRequest().body("Bad Request.");
    }

    @PutMapping("/send-otp")
    public boolean sendOtp(String email) {
        return service.sendOtp(email);
    }
}
