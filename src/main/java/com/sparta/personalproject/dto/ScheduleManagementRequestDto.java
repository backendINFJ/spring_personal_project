package com.sparta.personalproject.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ScheduleManagementRequestDto {

    private String manager;
    private int password;
    private LocalDate date;
    private String title;
    private String content;
}
