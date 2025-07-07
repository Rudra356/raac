package com.infinity_life.torque_tribe_backend.controller;

import com.infinity_life.torque_tribe_backend.model.User;
import com.infinity_life.torque_tribe_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        if (userService.userExists(user.getEmail())) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<User>> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getByUsername(username));
    }
}
