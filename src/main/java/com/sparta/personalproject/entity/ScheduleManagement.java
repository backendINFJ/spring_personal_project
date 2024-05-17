package com.sparta.personalproject.entity;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table (name = "schedule")
@NoArgsConstructor
public class ScheduleManagement extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "담당자",nullable = false)
    private String manager;
    @Column(name = "비밀번호",nullable = false)
    private int passward;
    @Column(name = "작성일",nullable = false)
    private LocalDate date;
    @Column(name = "할일 제목",nullable = false)
    private String title;
    @Column(name = "할일 내용",nullable = false)
    private String content;




    public ScheduleManagement(ScheduleManagementRequestDto requestDto) {
        this.manager = requestDto.getManager();
        this.passward = requestDto.getPassword();
        this.date = requestDto.getDate();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }


    }
