package com.infinity_life.torque_tribe_backend.controller;

import com.infinity_life.torque_tribe_backend.model.Thread;
import com.infinity_life.torque_tribe_backend.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threads")
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadService threadService;

    @PostMapping
    public ResponseEntity<Thread> createThread(@RequestBody Thread thread) {
        return ResponseEntity.ok(threadService.createThread(thread));
    }

    @GetMapping
    public ResponseEntity<List<Thread>> getAllThreads() {
        return ResponseEntity.ok(threadService.getAllThreads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Thread> getThreadById(@PathVariable String id) {
        return threadService.getThreadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Thread>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(threadService.getThreadsByCategory(category));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Thread>> getByUser(@PathVariable String userId) {
        return ResponseEntity.ok(threadService.getThreadsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThread(@PathVariable String id) {
        threadService.deleteThread(id);
        return ResponseEntity.noContent().build();
    }
}
