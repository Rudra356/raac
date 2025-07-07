package com.infinity_life.torque_tribe_backend.controller;

import com.infinity_life.torque_tribe_backend.model.Reply;
import com.infinity_life.torque_tribe_backend.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
@RequiredArgsConstructor

public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<Reply> addReply(@RequestBody Reply reply) {
        return ResponseEntity.ok(replyService.addReply(reply));
    }

    @GetMapping("/thread/{threadId}")
    public ResponseEntity<List<Reply>> getRepliesByThread(@PathVariable String threadId) {
        return ResponseEntity.ok(replyService.getRepliesByThread(threadId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reply>> getRepliesByUser(@PathVariable String userId) {
        return ResponseEntity.ok(replyService.getRepliesByUser(userId));
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable String replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.noContent().build();
    }
}
