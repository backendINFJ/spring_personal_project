package com.sparta.personalproject.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private Long id;

    private String manager;

    private int passward;

    private double date;

    private String title;

    private String content;
}
