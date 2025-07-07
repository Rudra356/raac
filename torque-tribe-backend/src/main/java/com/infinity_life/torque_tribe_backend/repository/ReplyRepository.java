package com.infinity_life.torque_tribe_backend.repository;

import com.infinity_life.torque_tribe_backend.model.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReplyRepository extends MongoRepository<Reply, String> {
    List<Reply> findByThreadId(String threadId);
    List<Reply> findByUserId(String userId);
}
