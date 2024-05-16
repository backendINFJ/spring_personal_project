package com.sparta.personalproject.dto;

import com.sparta.personalproject.entity.ScheduleManagement;
import lombok.Getter;

@Getter

public class ScheduleManagementResponseDto {

    private String writer;

    private int passward;

    private double date;

    private String title;

    private String content;

    public ScheduleManagementResponseDto(ScheduleManagement scheduleManagement) {
        this.writer = scheduleManagement.getWriter();
        this.passward = scheduleManagement.getPassward();
        this.date = scheduleManagement.getDate();
        this.title = scheduleManagement.getTitle();
        this.content = scheduleManagement.getContent();

    }
}
