package com.sparta.personalproject.entity;

import com.sparta.personalproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long id; // bigint MYSQL 자료형에서 -21억4천~ +21억4천까지라 long 선언 // 아이디(고유번호)

    @NotNull(message = "댓글 내용을 입력해주세요!")  // 댓글 내용 비었을 때 예외처리
    @Column(name = "commentText", nullable = false, length = 50)
    private String commentText; // 댓글 내용

    @Column(name = "userId", nullable = false)
    private String userId; // 사용자 아이디


    @Column(name = "createAt", nullable = false)
    private LocalDateTime createdAt; // 작성일자

    @ManyToOne // N:1 관계
    @JoinColumn(name = "schedule_id", nullable = false)
    private ScheduleManagement scheduleManagement; // 일정 관리 엔티티 참조

    public Comment(CommentRequestDto requestDto) {
        this.commentText = requestDto.getCommentText();
        this.userId = requestDto.getUserId();
        this.scheduleManagement = scheduleManagement;
    }

    public void update(CommentRequestDto requestDto) {
        this.commentText = requestDto.getCommentText();
        this.userId = requestDto.getUserId();
    }
}