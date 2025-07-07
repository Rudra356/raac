package com.infinity_life.torque_tribe_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "threads")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Thread {
    @Id
    private String id;

    private String title;
    private String content;
    private String category;

    private String createdByUserId; // Reference to User
    private LocalDateTime createdAt;
}
