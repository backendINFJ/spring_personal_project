package com.sparta.personalproject.controller;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import com.sparta.personalproject.service.ScheduleManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor

public class ScheduleManagementController {

    private final ScheduleManagementService scheduleManagementService;

    @PostMapping("/create") // 일정 생성
    public ScheduleManagementResponseDto createSchedule(@RequestBody ScheduleManagementRequestDto requestDto) {
        return scheduleManagementService.createSchedule(requestDto);
    }
    @GetMapping("/{schedulesId}") // 선택한 일정 조회
    public ScheduleManagementResponseDto findSchedule(@PathVariable Long schedulesId) {
        return scheduleManagementService.findSchedule(schedulesId);
    }
    @GetMapping  // 전체 일정조회
    public List<ScheduleManagementResponseDto> getAllSchedules() {
        return scheduleManagementService.getAllSchedules(); // service에서 전체 목록 조회하는로직짜기
    }

    @PutMapping("/{schedulesId}") // 선택한 일정 수정
    public ScheduleManagementResponseDto updateSchedule(@PathVariable Long schedulesId, @RequestBody ScheduleManagementRequestDto requestDto) {
        return scheduleManagementService.updateSchedule(schedulesId,requestDto,requestDto.getPassword()); // 4단계 조건 : 비밀번호 같이 전달
    }

    @DeleteMapping("/{scheduleId}") // 선택한 일정 삭제
    public Long deleteSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleManagementRequestDto requestDto) {
        return scheduleManagementService.deleteSchedule(scheduleId, requestDto.getPassword());
    }


}