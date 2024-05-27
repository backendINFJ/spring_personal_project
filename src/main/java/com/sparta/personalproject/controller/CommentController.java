package com.sparta.personalproject.controller;


import com.sparta.personalproject.dto.CommentRequestDto;
import com.sparta.personalproject.dto.CommentResponseDto;
import com.sparta.personalproject.entity.Comment;
import com.sparta.personalproject.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
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


    @PutMapping("/{scheduleId}/{commentId}/update")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable("commentId") Long commentId,@RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.updateComment(commentId,requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/delete/{commentId}")
    public Long deleteComment(@PathVariable("commentId") Long commentId) {
     return commentService.deleteComment(commentId);
    }
}
