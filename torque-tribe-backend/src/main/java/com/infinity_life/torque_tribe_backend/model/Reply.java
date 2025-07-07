package com.infinity_life.torque_tribe_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "replies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {
    @Id
    private String id;

    private String threadId;
    private String userId;
    private String content;

    private LocalDateTime createdAt;
}
