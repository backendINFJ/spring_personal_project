package com.sparta.personalproject.service;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import com.sparta.personalproject.repository.ScheduleManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // @Transactional 임포트 추가

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ScheduleManagementService {

    private final ScheduleManagementRepository scheduleManagementRepository;

    @Transactional // 모든 메서드에 트랜잭션 적용
    public ScheduleManagementResponseDto createSchedule(ScheduleManagementRequestDto requestDto) {

        ScheduleManagement schedule = new ScheduleManagement();
        schedule.setManager(requestDto.getManager());
        schedule.setDate(LocalDate.now()); // 현재 날짜를 사용하여 작성일을 설정
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());


        ScheduleManagement savedSchedule = scheduleManagementRepository.save(schedule);

        return new ScheduleManagementResponseDto(savedSchedule);
    }
}
