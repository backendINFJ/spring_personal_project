package com.sparta.personalproject.dto;

import com.sparta.personalproject.entity.ScheduleManagement;
import lombok.Getter;

@Getter

public class ScheduleManagementResponseDto {

    private Long id;

    private String manager;

    private int passward;

    private double date;

    private String title;

    private String content;

    public ScheduleManagementResponseDto(ScheduleRequestDto scheduleRequestDto)
}
