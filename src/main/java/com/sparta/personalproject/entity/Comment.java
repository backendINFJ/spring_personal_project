package com.sparta.personalproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // bigint MYSQL 자료형에서 -21억4천~ +21억4천까지라 long 선언 // 아이디(고유번호)

    @Column(name = "commentText", nullable = false, length = 50)
    private String commentText; // 댓글 내용

    @Column(name = "userId", nullable = false)
    private String userId; // 사용자 아이디


    @Column(name = "createAt", nullable = false)
    private LocalDate createAt; // 작성일자

    @ManyToOne // N:1 관계
    @JoinColumn(name = "schedule_id",nullable = false)
    private ScheduleManagement scheduleManagement; // 일정 관리 엔티티 참조
}