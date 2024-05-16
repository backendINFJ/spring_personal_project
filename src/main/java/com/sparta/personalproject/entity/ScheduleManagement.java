package com.sparta.personalproject.entity;

import com.sparta.personalproject.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleManagement {

    private String writer;

    private int passward;

    private double date;

    private String title;

    private String content;


    public ScheduleManagement(ScheduleRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.passward = requestDto.getPassward();
        this.date = requestDto.getDate();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.passward = requestDto.getPassward();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
