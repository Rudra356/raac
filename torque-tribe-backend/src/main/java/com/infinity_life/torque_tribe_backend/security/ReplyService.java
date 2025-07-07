package com.infinity_life.torque_tribe_backend.service;

import com.infinity_life.torque_tribe_backend.model.Reply;
import com.infinity_life.torque_tribe_backend.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public Reply addReply(Reply reply) {
        reply.setCreatedAt(LocalDateTime.now());
        return replyRepository.save(reply);
    }

    public List<Reply> getRepliesByThread(String threadId) {
        return replyRepository.findByThreadId(threadId);
    }

    public List<Reply> getRepliesByUser(String userId) {
        return replyRepository.findByUserId(userId);
    }

    public void deleteReply(String replyId) {
        replyRepository.deleteById(replyId);
    }
}
