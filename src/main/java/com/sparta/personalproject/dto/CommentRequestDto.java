package com.sparta.personalproject.dto;

import com.sparta.personalproject.entity.ScheduleManagement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentRequestDto {

    private String commentText;
    private Long userId;
    private ScheduleManagement scheduleId;
}



