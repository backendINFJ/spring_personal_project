package com.sparta.personalproject.repository;

import com.sparta.personalproject.entity.ScheduleManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 컴포넌트 스캔방식으로 자동 의존관계 설정 ,  @Repository 안해도 되는 이유 SimpleJpaRepository 관련 설명
public interface ScheduleManagementRepository extends JpaRepository<ScheduleManagement,Long> {
} //
