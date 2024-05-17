package com.sparta.personalproject.dto;

import com.sparta.personalproject.entity.ScheduleManagement;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class ScheduleManagementResponseDto {

    private Long id;
    private String manager;
    private LocalDate date;
    private String title;
    private String content;

    public ScheduleManagementResponseDto(ScheduleManagement scheduleManagement) {
        this.id = scheduleManagement.getId();
        this.manager = scheduleManagement.getManager();
        this.date = scheduleManagement.getDate();
        this.title = scheduleManagement.getTitle();
        this.content = scheduleManagement.getContent();
    }
}
