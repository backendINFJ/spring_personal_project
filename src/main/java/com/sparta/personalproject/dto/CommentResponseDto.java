package com.sparta.personalproject.dto;

import com.sparta.personalproject.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private Long id; // 댓글의 고유 ID
    private String commentText; // 댓글 내용
    private Long userId; // 댓글을 작성한 사용자의 ID

    private Long scheduleId; // 댓글이 속한 일정의 ID

    // 생성자를 통해 Comment 엔티티로부터 데이터를 받아와 초기화
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.commentText = comment.getCommentText();
        this.userId = comment.getUserId();
        this.scheduleId = comment.getScheduleManagement().getId(); // ScheduleManagement 엔티티에서 ID를 가져옴
    }
}
