package org.bookcafe.controller;

import org.bookcafe.model.Book;
import org.bookcafe.model.User;
import org.bookcafe.model.request.UserRequestDTO;
import org.bookcafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Kullanıcı işlemleri için kontrolcü sınıfı
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Tüm kullanıcıları listeleme işlemi
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Belirli bir kullanıcıyı ID ile getirme işlemi
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Kullanıcı kaydı işlemi
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(userRequestDTO.getRole());

        User savedUser = userService.addUser(user);
        return ResponseEntity.ok(savedUser);
    }


}
