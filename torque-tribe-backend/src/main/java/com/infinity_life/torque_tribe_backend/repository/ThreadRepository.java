package com.infinity_life.torque_tribe_backend.repository;

import com.infinity_life.torque_tribe_backend.model.Thread;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ThreadRepository extends MongoRepository<Thread, String> {
    List<Thread> findByCategory(String category);
    List<Thread> findByCreatedByUserId(String userId);
}
