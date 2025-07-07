package com.infinity_life.torque_tribe_backend.service;

import com.infinity_life.torque_tribe_backend.model.Thread;
import com.infinity_life.torque_tribe_backend.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThreadService {

    private final ThreadRepository threadRepository;

    public Thread createThread(Thread thread) {
        thread.setCreatedAt(LocalDateTime.now());
        return threadRepository.save(thread);
    }

    public List<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    public Optional<Thread> getThreadById(String id) {
        return threadRepository.findById(id);
    }

    public List<Thread> getThreadsByCategory(String category) {
        return threadRepository.findByCategory(category);
    }

    public List<Thread> getThreadsByUserId(String userId) {
        return threadRepository.findByCreatedByUserId(userId);
    }

    public void deleteThread(String id) {
        threadRepository.deleteById(id);
    }
}
