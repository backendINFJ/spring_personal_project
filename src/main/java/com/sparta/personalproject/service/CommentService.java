package com.sparta.personalproject.service;

import com.sparta.personalproject.dto.CommentRequestDto;
import com.sparta.personalproject.dto.CommentResponseDto;
import com.sparta.personalproject.entity.Comment;
import com.sparta.personalproject.entity.ScheduleManagement;
import com.sparta.personalproject.repository.CommentRepository;
import com.sparta.personalproject.repository.ScheduleManagementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true) // 트랜잭션 데이터를 변경하지 않겠다.
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final ScheduleManagementRepository scheduleManagementRepository;



    public CommentService(CommentRepository commentRepository, ScheduleManagementRepository scheduleManagementRepository) {
        this.commentRepository = commentRepository;
        this.scheduleManagementRepository = scheduleManagementRepository;
    }


    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        // 주어진 scheduleId로 ScheduleManagement 엔티티를 찾습니다.
        ScheduleManagement scheduleManagement = scheduleManagementRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new EntityNotFoundException("ScheduleManagement not found with id: " + requestDto.getScheduleId()));

        // Comment 엔티티를 생성하고 필드를 초기화합니다.
        Comment comment = new Comment(requestDto);
        comment.setScheduleManagement(scheduleManagement); // ScheduleManagement 엔티티를 설정합니다.

        // Comment 엔티티를 저장하고 저장된 엔티티를 반환합니다.
        Comment savedComment = commentRepository.save(comment);

        // 저장된 Comment 엔티티를 사용하여 CommentResponseDto를 생성하고 반환합니다.
        return new CommentResponseDto(savedComment);

    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId ,CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(null);// 일정 id 필요없이 그냥 댓글 id만 불러오기
        comment.update(requestDto);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }

    @Transactional
    public Long deleteComment(Long commentId) { // 댓글삭제 구현
        Comment comment = this.findComment(commentId);
        commentRepository.delete(comment);
        return commentId;
    }

    private void validatePassword(ScheduleManagement scheduleManagement, String password) { // 비밀번호 검증
        // 필수요건에 없어서 삭제 고민중
        if (!scheduleManagement.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private Comment findByUserId(Long commentId) throws IllegalArgumentException {
        return commentRepository.findById(commentId) // 등록한 댓글 수정
                .orElseThrow(() -> new IllegalArgumentException("조회 실패: 해당 ID의 댓글이 존재하지 않습니다."));  // 예외 처리 추가
    }

    private Comment findComment(Long commentId) { // 댓글 고유 Id 찾기
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));
    }
}
