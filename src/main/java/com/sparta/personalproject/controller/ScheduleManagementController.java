package com.sparta.personalproject.controller;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.service.ScheduleManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleManagementController {

    private final ScheduleManagementService scheduleManagementService;

    @PostMapping
    public ResponseEntity<ScheduleManagementResponseDto> createSchedule(@RequestBody ScheduleManagementRequestDto requestDto) {
        ScheduleManagementResponseDto responseDto = scheduleManagementService.createSchedule(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
