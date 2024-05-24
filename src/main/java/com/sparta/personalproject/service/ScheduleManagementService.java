package com.sparta.personalproject.service;

import com.sparta.personalproject.dto.ScheduleManagementRequestDto;
import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import com.sparta.personalproject.repository.ScheduleManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // @Transactional 임포트 추가

import java.util.List;
import java.util.stream.Collectors;


@Transactional(readOnly = true)
@Service
public class ScheduleManagementService { // 비슷한게 있는지, 공통점 -> 메소드 분리

    private final ScheduleManagementRepository scheduleManagementRepository; // DI 주입

    public ScheduleManagementService(ScheduleManagementRepository scheduleManagementRepository) {
        this.scheduleManagementRepository = scheduleManagementRepository; // Autowired 생략
    }


    @Transactional
    public ScheduleManagementResponseDto createSchedule(ScheduleManagementRequestDto requestDto) { // Create
        ScheduleManagement scheduleManagement = new ScheduleManagement(requestDto);
        ScheduleManagement savedSchedule = scheduleManagementRepository.save(scheduleManagement); // 일정 저장
        return new ScheduleManagementResponseDto(savedSchedule);
    }

    public ScheduleManagementResponseDto findSchedule(Long Id) { // 선택한 일정 조회
        ScheduleManagement scheduleManagement = this.findById(Id);
        return new ScheduleManagementResponseDto(scheduleManagement);
    }

    public List<ScheduleManagementResponseDto> getAllSchedules() { // 전체일정 조회
        return scheduleManagementRepository.findAllByOrderByModifiedAtDesc().stream().map(ScheduleManagementResponseDto::new).toList();
    }

    @Transactional
    public ScheduleManagementResponseDto updateSchedule(Long scheduleId, ScheduleManagementRequestDto requestDto, String password) {
        ScheduleManagement scheduleManagement = this.findById(scheduleId); // 선택한 일정 수정
        this.validatePassword(scheduleManagement, password);
        scheduleManagement.update(requestDto);
        scheduleManagementRepository.save(scheduleManagement);  // 변경 사항을 저장

        return new ScheduleManagementResponseDto(scheduleManagement);
    }
    @Transactional
    public Long deleteSchedule(Long scheduleId, String password) {
        ScheduleManagement scheduleManagement = findScheduleManagement(scheduleId);
        this.validatePassword(scheduleManagement, password);
        scheduleManagementRepository.delete(scheduleManagement); // 비밀번호가 같을시 삭제
        return scheduleId;
    }

    private ScheduleManagement findScheduleManagement(Long scheduleId) {
        return scheduleManagementRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));
    }

    private ScheduleManagement findById(Long scheduleId) throws IllegalArgumentException {
        return scheduleManagementRepository.findById(scheduleId) // 선택한 일정 수정
                .orElseThrow(() -> new IllegalArgumentException("조회 실패: 해당 ID의 일정이 존재하지 않습니다."));  // 예외 처리 추가
    }

    private void validatePassword(ScheduleManagement scheduleManagement, String password) { // 비밀번호 검증
        // scheduleManagement의 패스워드와 password를 같은지 비교.
        if (!scheduleManagement.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
