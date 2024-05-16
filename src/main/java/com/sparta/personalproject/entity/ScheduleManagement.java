package com.sparta.personalproject.entity;

import com.sparta.personalproject.dto.ScheduleRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table = ( ="schedule")
@NoArgsConstructor
public class ScheduleManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "담당자",nullable = false)
    private String manager;
    @Column(name = "비밀번호",nullable = false)
    private int passward;
    @Column(name = "작성일",nullable = false)
    private double date;
    @Column(name = "할일 제목",nullable = false)
    private String title;
    @Column(name = "할일 내용",nullable = false)
    private String content;


    public ScheduleManagement(ScheduleRequestDto requestDto) {
        this.manager = requestDto.getManager();
        this.passward = requestDto.getPassward();
        this.date = requestDto.getDate();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.manager = requestDto.getManager();
        this.passward = requestDto.getPassward();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
