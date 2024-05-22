package com.sparta.personalproject.entity;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor // 기본 생성자 생성
public class ScheduleManagement extends Timestamped {

    @Id // 고유 아이디
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @Column(name = "manager", nullable = false)
    private String manager;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;

@Builder
    public ScheduleManagement(ScheduleManagementRequestDto requestDto) {
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(ScheduleManagementRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();


    }
}
