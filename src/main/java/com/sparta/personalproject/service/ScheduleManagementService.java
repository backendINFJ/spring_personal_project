package com.sparta.personalproject.service;

import com.sparta.personalproject.repository.ScheduleManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 컴포넌트 스캔방식으로 자동 의존관계 설정
public class ScheduleManagementService {

    private final ScheduleManagementRepository scheduleManagementRepository;

    @Autowired // DI 주입 , (생성자 주입)
    public ScheduleManagementService(ScheduleManagementRepository scheduleManagementRepository) {
        this.scheduleManagementRepository = scheduleManagementRepository;
    }
}
