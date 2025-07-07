package com.infinity_life.torque_tribe_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private String password; // Hashed password

    private String bio;
    private String role; // USER, ADMIN, etc.

    private LocalDateTime createdAt;
}
