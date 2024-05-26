package com.sparta.personalproject.controller;


import com.sparta.personalproject.dto.CommentRequestDto;
import com.sparta.personalproject.dto.CommentResponseDto;
import com.sparta.personalproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
@RestControllerAdvice
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }


    @PutMapping("/{scheduleId}/comment/{userId}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long userId, @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.updateComment(userId, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
