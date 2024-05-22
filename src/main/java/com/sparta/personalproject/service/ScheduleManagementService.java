package com.sparta.personalproject.service;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import com.sparta.personalproject.repository.ScheduleManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // @Transactional 임포트 추가

import java.time.LocalDate;

@Transactional
@Service
public class ScheduleManagementService {

    private final ScheduleManagementRepository scheduleManagementRepository; // DI 주입

    public ScheduleManagementService(ScheduleManagementRepository scheduleManagementRepository) {
        this.scheduleManagementRepository = scheduleManagementRepository; // Autowired 생략
    }
    public ScheduleManagementResponseDto createSchedule(ScheduleManagementRequestDto requestDto) { // 일정생성
        ScheduleManagement scheduleManagement = new ScheduleManagement(requestDto);
        ScheduleManagement savedSchedule = scheduleManagementRepository.save(scheduleManagement); // 일정 저장
        return new ScheduleManagementResponseDto(savedSchedule);
    }
    public ScheduleManagementResponseDto findSchedule(Long scheduleId) { // id를 통해 선택 일정 조회
        ScheduleManagement scheduleManagement = findScheduleManagement(scheduleId);  //DB 조회
        return new ScheduleManagementResponseDto(scheduleManagement);
    }
