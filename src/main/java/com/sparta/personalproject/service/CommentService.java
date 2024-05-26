package com.sparta.personalproject.service;

import com.sparta.personalproject.dto.CommentRequestDto;
import com.sparta.personalproject.dto.CommentResponseDto;
import com.sparta.personalproject.entity.Comment;
import com.sparta.personalproject.entity.ScheduleManagement;
import com.sparta.personalproject.repository.CommentRepository;
import com.sparta.personalproject.repository.ScheduleManagementRepository;
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
        scheduleManagementRepository.findById(requestDto.getScheduleId());
        Comment comment = new Comment(requestDto);
        Comment saveComment = commentRepository.save(comment); //
        return new CommentResponseDto(saveComment);

    }

    @Transactional
    public CommentResponseDto updateComment(Long userId, CommentRequestDto requestDto) {
        Comment comment = this.findById(userId);
        commentRepository.findById(userId);// 일정 id 필요없이 그냥 댓글 id만 불러오기
        comment.update(requestDto);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }

    @Transactional
    public Long deleteComment(Long userId) { // 댓글삭제 구현
        Comment comment = this.findComment(userId);
        commentRepository.delete(comment);
        return  userId;
    }

    private void validatePassword(ScheduleManagement scheduleManagement, String password) { // 비밀번호 검증
        // 필수요건에 없어서 삭제 고민중
        if (!scheduleManagement.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private Comment findById(Long userId) throws IllegalArgumentException {
        return commentRepository.findById(userId) // 등록한 댓글 수정
                .orElseThrow(() -> new IllegalArgumentException("조회 실패: 해당 ID의 댓글이 존재하지 않습니다."));  // 예외 처리 추가
    }

    private Comment findComment(Long userId) { // 댓글 고유 Id 찾기
        return commentRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));
    }
}
