package com.sparta.personalproject.repository;

import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 컴포넌트 스캔방식으로 자동 의존관계 설정
public interface ScheduleManagementRepository extends JpaRepository<ScheduleManagement,Long> {

    List<ScheduleManagementResponseDto> findAllByOrderByModifiedAtDesc(); // 내림차순 정렬
}
